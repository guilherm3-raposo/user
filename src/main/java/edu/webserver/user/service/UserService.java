package edu.webserver.user.service;

import javax.annotation.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import edu.webserver.user.db.mappers.UserMapper;
import edu.webserver.user.model.PasswordUpdateDTO;
import edu.webserver.user.model.User;

@ManagedBean
public class UserService {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserMapper userMapper;

    public User getUser(final int id) {
        return userMapper.getUser(id);
    }

    public void putUser(final User user) {
        if (user.getId() == null) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
        } else {
            user.setPassword(null);
        }
        userMapper.putUser(user);
    }

    public void updatePassword(final PasswordUpdateDTO dto) throws Exception {
        Integer id = dto.getId();

        if (!passwordEncoder.matches(dto.getOldPassword(), userMapper.getPassword(id))) {
            throw new Exception("UNAUTHORIZED");
        }

        String nuPassword = dto.getNuPassword();

        if (nuPassword == null || nuPassword.isEmpty()) {
            throw new Exception("EMPTY_PASSWORD");
        }

        nuPassword = passwordEncoder.encode(nuPassword);

        userMapper.updatePassword(dto.getId(), nuPassword);
    }
}
