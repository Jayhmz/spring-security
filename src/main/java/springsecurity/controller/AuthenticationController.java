package springsecurity.controller;

import java.security.Principal;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import springsecurity.entity.ChangePasswordDTO;
import springsecurity.entity.UserEntity;
import springsecurity.service.UserService;

@Controller
public class AuthenticationController {

	@Autowired
	private PasswordEncoder encoder;

	@Autowired
	private JdbcUserDetailsManager jdbcUserDetailsManager;

	@Autowired
	private UserService service;

	@GetMapping("/login")
	public String loginPage() {
		return "login";
	}

	@GetMapping("/signup")
	public String signUpPage() {
		return "register";
	}

	@PostMapping("/signup")
	public String processSignUpPage(@ModelAttribute("user") UserEntity user) {

		user.setPassword(encoder.encode(user.getPassword()));

//		service.createUser(user); //this is the dao layer logic of creating a user
		
		//this is the internal logic of creating a user for a custom table
		String sql = "insert into clients(username, email, password, address, enabled, role) values(?,?,?,?,?,?)";
//		String roles = "insert into clients(username, authority) values(?,?)";
		
		
			try {
				jdbcUserDetailsManager.getJdbcTemplate().update(sql,  ps -> {
				ps.setString(1, user.getUsername());
				ps.setString(2, user.getEmail());
				ps.setString(3, user.getPassword());
				ps.setString(4, user.getAddress());
				ps.setInt(5, 1);
				ps.setString(6, "user");
				
			});
			
		}
			catch (Exception e) {
			System.out.println(e);
		}

		return "redirect:/login";
	}

	@GetMapping("/change-password")
	public String changePassword(@ModelAttribute("cpDTO") ChangePasswordDTO cpDTO) {

		return "changepassword";
	}

	@PostMapping("/change-password")
	public String processChangePassword(Principal principal, @ModelAttribute("cpDTO") ChangePasswordDTO cpDTO) {

		// new-password === old-password
		if (!cpDTO.getNewpassword().equals(cpDTO.getConfirmpassword())) {
			return "redirect:/change-password?PasswordMatchFailure";
		}

		// check the old password match db password.
		UserDetails user = jdbcUserDetailsManager.loadUserByUsername(principal.getName());
		boolean matches = encoder.matches(cpDTO.getOldpassword(), user.getPassword());
		if (matches) {
			jdbcUserDetailsManager.changePassword(user.getPassword(), encoder.encode(cpDTO.getConfirmpassword()));
			return "redirect:/";
		} else {
			return "redirect:/change-password?incorrectpassword";
		}

	}

}
