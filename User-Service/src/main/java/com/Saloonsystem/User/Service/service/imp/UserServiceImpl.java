package com.Saloonsystem.User.Service.service.imp;

import com.Saloonsystem.User.Service.model.User;
import com.Saloonsystem.User.Service.repository.UserRepository;
import com.Saloonsystem.User.Service.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;


    @Override
    public User createuser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserByTd(Long id) throws Exception {
        Optional<User> opt = userRepository.findById(id);
        if(opt.isPresent()){
            return opt.get();
        }
        throw new Exception("User not found");
    }

    @Override
    public List<User> getAllusers() {
        return userRepository.findAll();
    }


    @Override
    public String deleteuser(Long id) throws Exception {
        Optional<User> opt = userRepository.findById(id);
        if(opt.isEmpty()){
            throw new Exception("User not exist with this Id"+ id);
        }
        userRepository.getById(opt.get().getId());
        return "User deleted Successfully";

    }

    @Override
    public User updateUser(Long id, User user) throws Exception {
        Optional<User> opt = userRepository.findById(id);
        if (opt.isEmpty()) {
            throw new Exception("User not found with this Id" + id);
        }
        User existingUsr = opt.get();

        existingUsr.setFullname(user.getFullname());
        existingUsr.setEmail(user.getEmail());
        existingUsr.setRole(user.getRole());
        existingUsr.setPhone(user.getPhone());

        return userRepository.save(existingUsr);
    }
}
