package com.memo.user.bo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.memo.test.PayType;

public class EnumTest {
	
	@Test
	void pay테스트1() {
		// given
		String payMethod = "KAKAO";
		
		// when
		// 결제 수단(예:카카오페이)에 대한 결제 종류(예:현금 또는 카드)가 무엇인가?
		PayType payType = PayType.findByPayMethod(payMethod);
		
		
		// then
		assertEquals(PayType.CARD, payType);
	}
}
