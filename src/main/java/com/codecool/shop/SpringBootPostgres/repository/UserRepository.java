package com.codecool.shop.SpringBootPostgres.repository;
import com.codecool.shop.SpringBootPostgres.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}