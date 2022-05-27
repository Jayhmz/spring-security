package springsecurity.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import springsecurity.entity.UserEntity;

@Repository
public class UserDAOImpl implements UserDAO{
	
	@Autowired
	private JdbcTemplate template;

	@Override
	public void createUser(UserEntity user) {
		
		String sql = "insert into clients values(?,?,?,?,?)";
		String authority = "insert into roles values(?,?)";
		
		template.update(sql, user.getUsername(), user.getEmail(), user.getPassword(), user.getAddress(), 1);
		template.update(authority, user.getUsername(), "USER");
		
	}

	
}
