package programmers.level0;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class CursedNumber3 {

//	저주의 숫자 3

//	문제 설명
//	3x 마을 사람들은 3을 저주의 숫자라고 생각하기 때문에 3의 배수와 숫자 3을 사용하지 않습니다.
//	3x 마을 사람들의 숫자는 다음과 같습니다.
//	정수 n이 매개변수로 주어질 때, n을 3x 마을에서 사용하는 숫자로 바꿔 return 하도록 solution 함수를 완성해 주세요.

//	제한사항
//	1 ≤ n ≤ 100

//	입출력 예
//	입출력 예 #1
//	Input : 15 / Output : 25
//	입출력 예 #2
//	Input : 40 / Output : 76

	public int solution(int n) {
		return IntStream.rangeClosed(1, n)
			.reduce(0, (a , b) -> {
				do {
					a++;
				} while (a % 3 == 0 || String.valueOf(a).contains("3"));
				return a;
			});
	}

	@Test
	public void test() {
		int result1 = solution(1);
		int result2 = solution(2);
		int result3 = solution(3);
		int result4 = solution(4);
		int result5 = solution(5);
		int result6 = solution(6);
		int result7 = solution(7);
		int result8 = solution(8);
		int result9 = solution(9);
		int result10 = solution(10);
		int result11 = solution(15);
		int result12 = solution(40);

		assertThat(result1).isEqualTo(1);
		assertThat(result2).isEqualTo(2);
		assertThat(result3).isEqualTo(4);
		assertThat(result4).isEqualTo(5);
		assertThat(result5).isEqualTo(7);
		assertThat(result6).isEqualTo(8);
		assertThat(result7).isEqualTo(10);
		assertThat(result8).isEqualTo(11);
		assertThat(result9).isEqualTo(14);
		assertThat(result10).isEqualTo(16);
		assertThat(result11).isEqualTo(25);
		assertThat(result12).isEqualTo(76);
	}

}
