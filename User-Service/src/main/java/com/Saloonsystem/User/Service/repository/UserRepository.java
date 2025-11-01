package com.Saloonsystem.User.Service.repository;

import com.Saloonsystem.User.Service.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
