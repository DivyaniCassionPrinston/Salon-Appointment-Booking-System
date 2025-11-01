package com.Saloonsystem.User.Service.service;

import com.Saloonsystem.User.Service.model.User;

import java.util.List;

public interface UserService {
        User createuser(User user);
        User getUserByTd(Long id) throws Exception;
        List<User> getAllusers();
        String deleteuser(Long id) throws Exception;
        User updateUser(Long id, User user) throws Exception;


}
