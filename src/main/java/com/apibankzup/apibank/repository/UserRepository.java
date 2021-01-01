package com.apibankzup.apibank.repository;

import com.apibankzup.apibank.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<UserModel, Long>{
    public List<UserModel> findAllByNameContainingIgnoreCase (String name);
}
