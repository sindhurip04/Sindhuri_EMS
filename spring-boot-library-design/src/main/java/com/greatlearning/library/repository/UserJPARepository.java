package com.greatlearning.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.greatlearning.library.model.User;

@Repository
public interface UserJPARepository extends JpaRepository<User, Long> {

}
