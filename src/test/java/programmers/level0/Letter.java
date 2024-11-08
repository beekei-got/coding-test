package programmers.level0;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Letter {

//	편지

//	문제 설명
//	머쓱이는 할머니께 생신 축하 편지를 쓰려고 합니다. 할머니가 보시기 편하도록 글자 한 자 한 자를 가로 2cm 크기로 적으려고 하며, 편지를 가로로만 적을 때, 축하 문구 message를 적기 위해 필요한 편지지의 최소 가로길이를 return 하도록 solution 함수를 완성해주세요.

//	제한사항
//	공백도 하나의 문자로 취급합니다.
//	1 ≤ message의 길이 ≤ 50
//	편지지의 여백은 생각하지 않습니다.
//	message는 영문 알파벳 대소문자, ‘!’, ‘~’ 또는 공백으로만 이루어져 있습니다.

//	입출력 예 설명
//	입출력 예 #1
//	message의 글자 수가 15개로 최소 가로 30cm의 편지지가 필요합니다.
//	입출력 예 #2
//	message의 글자 수가 11개로 최소 가로 22cm의 편지지가 필요합니다.

	private int solution(String message) {
		int answer = 0;
		String regex = "^[a-zA-Z~! ]*$";
		if (!message.isEmpty() && message.length() <= 50 && message.matches(regex)) {
			answer = message.length() * 2;
		}
		return answer;
	}

	@Test
	public void test() {
		int result1 = solution("happy birthday!");
		int result2 = solution("I love you~");

		assertThat(result1).isEqualTo(30);
		assertThat(result2).isEqualTo(22);
	}

}
