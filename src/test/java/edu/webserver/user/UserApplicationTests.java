package edu.webserver.user;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import edu.webserver.user.db.mappers.UserMapper;
import edu.webserver.user.model.User;

@SpringBootTest
@ContextConfiguration(classes = PersistenceConfig.class)
class UserApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private UserMapper userMapper;

	User user = new User(null, "test", "test_pw", "123.png");

	void makeUser() {
		userMapper.putUser(user);
	}
}
