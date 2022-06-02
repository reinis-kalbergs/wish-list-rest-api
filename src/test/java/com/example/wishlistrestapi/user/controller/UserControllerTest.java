package com.example.wishlistrestapi.user.controller;

import com.example.wishlistrestapi.user.model.User;
import com.example.wishlistrestapi.user.model.UserList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class UserControllerTest {

    @InjectMocks
    UserController userController;

    @Test
    void shouldGetCorrectString() {
        UserList userList = getTestUserList();
        String expectedResult = "johnsmith,angelinasmith,adamivanov";

        String actualResult = userController.getUserNames(userList);

        Assertions.assertEquals(expectedResult, actualResult);
    }

    private UserList getTestUserList() {
        User user1 = new User("user", 150709L, "johnsmith", "jsmith@example.com");
        User user2 = new User("user", 150710L, "angelinasmith", "asmith@example.com");
        User user3 = new User("user", 150910L, "adamivanov", "aivanov@another.org");

        User[] userArray = {user1, user2, user3};
        return new UserList(userArray);
    }
}
