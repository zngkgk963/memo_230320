//package com.memo.test;
//
//import java.util.Arrays;
//import java.util.List;
//
//import lombok.Getter;
//
//@Getter
//public class PayType {
//	// 열거형 정의
//	CASH("현금", List.of("REMIITANCE", "ACCOUNT_TRANSFER"))
//	, CARD("카드", List.of("CREDIT", "KAKAO", "NAVER"))
//	, EMPTY("없음", Collections.emptyList());
//	
//	// 필드
//	private String title;
//	private List<String> payList;
//	
//	// 생성자
//	PayType(String title, List<String> payList) {
//		this.title = title;
//		this.payList = payList;
//	}
//	
//	// 결제 수단(예:계좌이체)이 enum에 존재하는지 확인
//	boolean hasPayMethod(String payMethod) {
//		return payList
//		.stream()
//		.anyMatch(pay -> pay.equals(payMethod));
//	}
//	
//	// String(결제수단)으로 enum 상수(부모 그룹)를 찾기
//	public static PayType findByPayMethod(String payMethod) {
//		return Arrays
//				.stream(PayType.values()) // PayType의 열거형 변수들을 stream으로 변환
//				.filter(payType -> payType.hasPayMethod(payMethod))
//				.findAny()	// 찾은 요소 반환
//				.orElse(EMPTY);	// 없으면 PayType.EMPTY
//	}
//}
