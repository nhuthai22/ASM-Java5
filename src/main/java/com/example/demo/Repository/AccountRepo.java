package com.example.demo.Repository;

//AccountRepository.java

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.Entity.Account;

public interface AccountRepo extends JpaRepository<Account, Long> {
	@Query("SELECT CASE WHEN COUNT(a) > 0 THEN true ELSE false END FROM Account a WHERE a.username = :username AND a.password = :password")
	boolean findByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

	Account findByUsername(String username);
}
