package springsecurity.controller;

import java.security.Principal;
import java.util.Collection;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AppController {

	@GetMapping("/")
	public String homepage(Authentication auth, Model model) {
		
		model.addAttribute("user", auth.getName());
		
		Collection<? extends GrantedAuthority> authorities = auth.getAuthorities();
		
		model.addAttribute("roles",authorities);
		return "home";
	}
	
	@GetMapping("/admin")
	@ResponseBody
	public String admin() {
		return "This is an admin page";
	}
	
	@GetMapping("/user")
	@ResponseBody
	public String user() {
		return "This is a user page";
	}
	
	@GetMapping("/accessDenied")
	@ResponseBody
	public String error() {
		return "Error. You are not allowed to view this page.";
	}
}
