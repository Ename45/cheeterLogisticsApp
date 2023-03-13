package data.repositories;

import data.models.Package;
import data.models.User;
import data.models.User;
import data.models.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl implements UserRepository{
    private int count;
    private List<User> allUsers = new ArrayList<>();
    public User save(User user) {
        boolean isSavedUser = user.getId() != 0;
        if(isSavedUser) update(user);

        else saveNewUser(user);

        return user;
    }

    private void saveNewUser(User user){
        user.setId(generateUserId());
        allUsers.add(user);
        count++;
    }

//        private void update(User user){
//        User savedUser = findById(user.getId());
//        int indexOfSavedUser = allUsers.indexOf(savedUser);
//        allUsers.set(indexOfSavedUser, user);
////        allUsers[indexOfSavedUser] = user; for an array
//    }

//                             OR
    private void update(User user){
//        User savedUser = findById(user.getId());
//        savedUser.setEmail(user.getEmail());
//        savedUser.setAddress(user.getAddress());
//        savedUser.setEvents(a);
//
//                  OR
        User savedUser = findById(user.getId());
        allUsers.remove(savedUser);
        allUsers.add(user);
    }

    private int generateUserId() {
        return count+1;
    }


    public long count() {
        return count;
    }

    public void delete(User user) {
        allUsers.remove(user);
    }

    public void delete(int id) {
        User foundUser = findById(id);
        delete(foundUser);
    }

    public List<User> findAll() {
        return null;
    }

    public User findById(int id) {
        for (User user: allUsers) if (user.getId() == id) return user;
        return null;
    }
}
