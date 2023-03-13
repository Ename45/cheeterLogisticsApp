package data.repositories;

import data.models.Package;
import data.models.User;
import data.models.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryImplTest {
    private UserRepository userRepository;

    @BeforeEach
    public void setUp(){
        userRepository = new UserRepositoryImpl();
    }

    @Test
    @DisplayName("Create new User test")
    public void saveOneUser_countIsOneTest(){
        assertEquals(0, userRepository.count());

        User user = new User();
        userRepository.save(user);

        assertEquals(1, userRepository.count());
    }

    @Test
    @DisplayName("Generate Id test")
    public void saveOneUser_idIsOneTest(){
        User user = new User();
        assertEquals(0, user.getId());

        userRepository.save(user);
        assertEquals(1, user.getId());
    }

    @Test
    @DisplayName("Find by Id test")
    public void saveOneUser_findUserById_returnsSavedUserTest(){
        User user = new User();
        user.setEmail("enamesit@gmail.com");
        userRepository.save(user);

        User savedUser = userRepository.findById(1);
        assertEquals(1, savedUser.getId());
        assertEquals("enamesit@gmail.com", savedUser.getEmail());
        assertEquals(user, savedUser);
    }

    @Test
    @DisplayName("Update test")
    public void saveTwoUsersWithSameId_countIsOneTest(){
        User user = new User();
        user.setEmail("enamesit@gmail.com");
//        var savedAUser = userRepository.save(user);
        userRepository.save(user);
        User savedAUser = userRepository.findById(1);
        assertEquals(user, savedAUser);


        User secondUser = new User();
        secondUser.setId(1);
        user.setEmail("legend@gmail.com");

        userRepository.save(secondUser);

        User foundUser = userRepository.findById(1);

        assertEquals(foundUser, secondUser);
        assertNotEquals(foundUser, user);
    }

    @Test
    @DisplayName("Delete test")
    public void deleteUserTest(){
        User user = new User();
        User bUser = new User();
        User cUser = new User();

        userRepository.save(user);
        userRepository.save(bUser);
        userRepository.save(cUser);

        userRepository.delete(bUser);
        User dUser = new User();
        userRepository.save(dUser);

        assertEquals(4, dUser.getId());
    }
}