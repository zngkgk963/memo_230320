package com.memo.user.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.memo.user.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {

	public UserEntity findByLoginId(String loginId);
<<<<<<< HEAD
}
=======
	public UserEntity findByLoginIdAndPassword(String loginId, String password);
}
>>>>>>> 96461a2b3ee0acc2323c412fc23e483d3ae666c4
