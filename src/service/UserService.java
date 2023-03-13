package service;

import data.models.User;
import dto.requests.RegisterUserRequest;

public interface UserService {
    User registerNewUser(RegisterUserRequest registerUserRequest);
    User findUser(int id);
}
