package com.VillageSafeVisitors.Repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import com.VillageSafeVisitors.Models.SignUp;

public interface SignUpRepo extends JpaRepository<SignUp, Integer>{
	SignUp findByEmail(String email);

}
