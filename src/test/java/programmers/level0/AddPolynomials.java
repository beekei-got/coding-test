package programmers.level0;

import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.LinkedHashMap;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class AddPolynomials {

//	다항식 더하기

//	문제 설명
//	한 개 이상의 항의 합으로 이루어진 식을 다항식이라고 합니다.
//	다항식을 계산할 때는 동류항끼리 계산해 정리합니다.
//	덧셈으로 이루어진 다항식 polynomial이 매개변수로 주어질 때, 동류항끼리 더한 결괏값을 문자열로 return 하도록 solution 함수를 완성해보세요.
//	같은 식이라면 가장 짧은 수식을 return 합니다.
//
//	제한사항
//	0 < polynomial에 있는 수 < 100
//	polynomial에 변수는 'x'만 존재합니다.
//	polynomial은 양의 정수, 공백, ‘x’, ‘+'로 이루어져 있습니다.
//	항과 연산기호 사이에는 항상 공백이 존재합니다.
//	공백은 연속되지 않으며 시작이나 끝에는 공백이 없습니다.
//	하나의 항에서 변수가 숫자 앞에 오는 경우는 없습니다.
//	" + 3xx + + x7 + "와 같은 잘못된 입력은 주어지지 않습니다.
//	0으로 시작하는 수는 없습니다.
//	문자와 숫자 사이의 곱하기는 생략합니다.
//	polynomial에는 일차 항과 상수항만 존재합니다.
//	계수 1은 생략합니다.
//	결괏값에 상수항은 마지막에 둡니다.
//	0 < polynomial의 길이 < 50
//
//	입출력 예
//	입출력 예 #1
//	Input : "3x + 7 + x" / Output : "4x + 7"
//	입출력 예 #2
//	Input : "x + x + x" / Output : "3x"
//	입출력 예 #3
//	Input : "7 + 1" / Output : "8"
//	입출력 예 #4
//	Input : "8 + x + x" / Output : "2x + 8"

	public String solution(String polynomial) {
		Map<String, Integer> map = new LinkedHashMap<>() {{ put("x", 0); put("", 0); }};
		for (String s : polynomial.split(" \\+ ")) {
			String key = s.contains("x") ? "x" : "";
			int value = Optional.of(s.replace("x", ""))
				.filter(num -> !num.isBlank())
				.map(Integer::parseInt)
				.orElse(1);
			map.put(key, map.get(key) + value);
		}
		String[] result = map.keySet().stream()
			.filter(key -> map.get(key) > 0)
			.map(key -> key.equals("x") && map.get(key) == 1 ? "x" : map.get(key) + key)
			.toArray(String[]::new);
		return String.join(" + ", result);
	}

	@Test
	public void test() {
		String result1 = solution("3x + 7 + x");
		String result2 = solution("x + x + x");
		String result3 = solution("x + 5");
		String result4 = solution("7 + 1");
		String result5 = solution("8 + x + x");

		assertThat(result1).isEqualTo("4x + 7");
		assertThat(result2).isEqualTo("3x");
		assertThat(result3).isEqualTo("x + 5");
		assertThat(result4).isEqualTo("8");
		assertThat(result5).isEqualTo("2x + 8");
	}

}
