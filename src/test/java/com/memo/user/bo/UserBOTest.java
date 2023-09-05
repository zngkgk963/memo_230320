package com.memo.user.bo;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.memo.user.entity.UserEntity;

@SpringBootTest
class UserBOTest {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	UserBO userBO;
	//@Test
	void test() {
		fail("Not yet implemented");
	}
	
	@Test
	void 회원조회() {
		UserEntity user = userBO.getUserEntityByLoginId("aaaa");
		logger.info("##### user: {}", user);
		assertNotNull(user);
	}
	
	@Transactional // rollback
	//@Test
	void 회원추가테스트() {
		userBO.addUser("junit2222", "test", "name", "email@test.com");
	}

}
