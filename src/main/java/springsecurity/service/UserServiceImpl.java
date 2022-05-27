package springsecurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springsecurity.entity.UserEntity;
import springsecurity.repository.UserDAO;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	public UserDAO userdao;

	@Override
	public void createUser(UserEntity user) {
		
		userdao.createUser(user);
		
	}

}
