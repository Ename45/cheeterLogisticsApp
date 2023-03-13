package service;

import data.models.User;
import data.repositories.UserRepository;
import data.repositories.UserRepositoryImpl;
import dto.requests.RegisterUserRequest;

public class UserServiceImpl implements UserService{
    private UserRepository userRepository = new UserRepositoryImpl();
    public User registerNewUser(RegisterUserRequest request) {
        User newUser = new User();
        newUser.setFirstName(request.getFirstName());
        newUser.setLastName(request.getLastName());
        newUser.setEmail(request.getEmail());
        newUser.setAddress(request.getAddress());
        newUser.setPhoneNumber(request.getPhoneNumber());
//        User savedUser = userRepository.save(newUser);
//        return savedUser; OR
        return userRepository.save(newUser);
    }

    public User findUser(int id) {
        return userRepository.findById(id);
    }
}
