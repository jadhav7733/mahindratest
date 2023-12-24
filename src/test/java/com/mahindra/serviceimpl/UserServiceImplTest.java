package com.mahindra.serviceimpl;

import com.mahindra.entity.Gender;
import com.mahindra.entity.User;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class UserServiceImplTest {

    @Test
    void saveUser() {
        UserServiceImpl userService = Mockito.mock(UserServiceImpl.class);
        User user = new User();
        user.setLeadId("5678");
        user.setFirstName("Vineet");
        user.setMiddleName("");
        user.setLastName("KV");
        user.setGender(Gender.Male);
        user.setEmail("v@gmail.com");
        user.setMobileNumber("8877887789");

        when(userService.saveUser(user)).thenReturn(user);

        User user1 = userService.saveUser(user);
        assertEquals("5678",user1.getLeadId());
        assertEquals("8877887789",user1.getMobileNumber());
        assertEquals("v@gmail.com",user1.getEmail());
        assertEquals(Gender.Male,user1.getGender());
        assertEquals("KV",user1.getLastName());

    }

    @Test
    void findByMobNo() {

        UserServiceImpl userService = Mockito.mock(UserServiceImpl.class);

        User user = new User();
        user.setLeadId("5678");
        user.setFirstName("Vineet");
        user.setMiddleName("");
        user.setFirstName("KV");
        user.setGender(Gender.Male);
        user.setEmail("v@gmail.com");
        user.setMobileNumber("8877887789");

        when(userService.findByMobNo("887788779")).thenReturn(Collections.singletonList(user));

        assertEquals("8877887789",user.getMobileNumber());


    }
}