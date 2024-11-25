package programmers.level0;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ChickenCoupon {

//	치킨 쿠폰

//	문제 설명
//	프로그래머스 치킨은 치킨을 시켜먹으면 한 마리당 쿠폰을 한 장 발급합니다.
//	쿠폰을 열 장 모으면 치킨을 한 마리 서비스로 받을 수 있고, 서비스 치킨에도 쿠폰이 발급됩니다.
//	시켜먹은 치킨의 수 chicken이 매개변수로 주어질 때 받을 수 있는 최대 서비스 치킨의 수를 return하도록 solution 함수를 완성해주세요.

//	제한사항
//	chicken은 정수입니다.
//	0 ≤ chicken ≤ 1,000,000

//	입출력 예
//	입출력 예 #1
//	Input : 100 / Output : 11
//	입출력 예 #2
//	Input : 1,081 / Output : 120

	public int solution(int chicken) {
		int service = 0;
		while (chicken >= 10) {
			service += chicken / 10;
			chicken = (chicken / 10) + (chicken % 10);
		}
		return service;
	}

	@Test
	public void test() {
		int result1 = solution(100);
		int result2 = solution(1081);
		int result3 = solution(997281);

		assertThat(result1).isEqualTo(11);
		assertThat(result2).isEqualTo(120);
		assertThat(result3).isEqualTo(110808);
	}

}
