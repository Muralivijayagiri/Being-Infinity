package com.being_infinity.springboot_beginner_cohort_3.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.being_infinity.springboot_beginner_cohort_3.models.User;

class UserServiceTest {

    private UserService userService;

    @BeforeEach
    void setUp() {
        userService = new UserService();
    }

    @Test
    void startsWithTwoSeededUsers() {
        assertEquals(2, userService.getAllUsers().size());
        assertEquals("John Doe", userService.getUserById(1).getName());
        assertEquals("Jane Doe", userService.getUserById(2).getName());
    }

    @Test
    void addUserAssignsTheNextId() {
        User created = userService.addUser(new User(0, "Alex Doe", "Other", "/images/alex.png"));

        assertEquals(3, created.getId());
        assertEquals(3, userService.getAllUsers().size());
        assertSame(created, userService.getUserById(3));
    }

    @Test
    void updateUserChangesTheStoredFields() {
        User updated = userService.updateUser(1, new User(0, "Johnny Doe", "Male", "/images/johnny.png"));

        assertNotNull(updated);
        assertEquals("Johnny Doe", updated.getName());
        assertEquals("/images/johnny.png", userService.getUserById(1).getImage());
    }

    @Test
    void updateAndDeleteReportUnknownIds() {
        assertNull(userService.updateUser(99, new User()));
        assertFalse(userService.deleteUser(99));
        assertTrue(userService.deleteUser(1));
        assertNull(userService.getUserById(1));
    }

    @Test
    void randomUserIsNullOnlyWhenNoUsersRemain() {
        assertNotNull(userService.myRandomUser());

        assertTrue(userService.deleteUser(1));
        assertTrue(userService.deleteUser(2));

        assertNull(userService.myRandomUser());
    }
}
