package com.example._team.repository;

import com.example._team.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Test_UsersRepository extends JpaRepository<Users, Integer> {
	Users findByUserIdx(Integer userIdx);
}
