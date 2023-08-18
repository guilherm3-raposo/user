package edu.webserver.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import edu.webserver.user.model.PasswordUpdateDTO;
import edu.webserver.user.model.User;
import edu.webserver.user.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "USER_NOT_FOUND")
    public class UserNotFoundException extends RuntimeException {
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> user(@PathVariable("id") final int id) throws RuntimeException {
        User user = null;
        try {
            user = userService.getUser(id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (user == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        return ResponseEntity.ok(user);
    }

    @PutMapping("/put")
    public ResponseEntity<Integer> user(@RequestBody final User user) throws RuntimeException {
        userService.putUser(user);

        return ResponseEntity.ok(user.getId());
    }

    @PostMapping("/updatePassword")
    public ResponseEntity<Object> updatePassword(@RequestBody final PasswordUpdateDTO dto) throws RuntimeException {
        try {
            userService.updatePassword(dto);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("WRONG_PASSWORD");
        }

        return ResponseEntity.ok(null);
    }
}
