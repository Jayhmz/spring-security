package springsecurity.repository;

import springsecurity.entity.UserEntity;

public interface UserDAO {

	void createUser(UserEntity user);
	
}
