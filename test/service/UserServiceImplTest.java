package service;

import data.models.User;
import dto.requests.RegisterUserRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserServiceImplTest {
    private UserService userService;

    @BeforeEach
    public void setUp(){
        userService = new UserServiceImpl();
    }

    @Test
    public void registerUserTest(){
        RegisterUserRequest request = new RegisterUserRequest();
        request.setPhoneNumber("07064591358");
        request.setLastName("Udousoro");
        request.setFirstName("Inem");
        request.setAddress("address");
        request.setEmail("enamesit@gmail.com");

        User user = userService.registerNewUser(request);[]

        assertEquals(1, user.getId());
        User foundUser = userService.findUser(1);
//        assertEquals(user, foundUser);
        assertSame(user, foundUser);
        System.out.println(foundUser);
    }

}