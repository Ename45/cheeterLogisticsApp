package data.repositories;

import data.models.User;

import java.util.List;

public interface UserRepository {
    //    THIS REPO IS RESPONSIBLE FOR STORING AND RETRIEVING A USER
    User save(User user);

    long count();
    void delete(User user);
    void delete(int id);
    List<User> findAll();
    User findById(int id);
}
