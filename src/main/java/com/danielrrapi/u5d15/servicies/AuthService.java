package com.danielrrapi.u5d15.servicies;

import com.danielrrapi.u5d15.entities.User;
import com.danielrrapi.u5d15.exceptions.BadRequestException;
import com.danielrrapi.u5d15.exceptions.UnauthorizedException;
import com.danielrrapi.u5d15.payloads.NewUserDTO;
import com.danielrrapi.u5d15.payloads.UserLoginDTO;
import com.danielrrapi.u5d15.repositories.UserDAO;
import com.danielrrapi.u5d15.security.JWTTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private UserService userService;
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private JWTTools jwtTools;
    @Autowired
    private PasswordEncoder bCrypt;

    public String authenticateUserAndGenerateToken(UserLoginDTO payload) {
        User user = userService.findByEmail(payload.email());
        if(bCrypt.matches(payload.password(), user.getPassword())) {
            return jwtTools.createToken(user);
        } else {
            throw new UnauthorizedException("Wrong email or password!");
        }
    }

    public User saveUser(NewUserDTO payload) {
        userDAO.findByEmail(payload.email()).ifPresent(user -> {
            throw new BadRequestException("Email " + payload.email() + " is already used");
        });
        User newUser = new User(payload.name(), payload.surname(), payload.email(), bCrypt.encode(payload.password()));
        return userDAO.save(newUser);
    }
}
