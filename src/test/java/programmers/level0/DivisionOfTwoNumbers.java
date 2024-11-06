package programmers.level0;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DivisionOfTwoNumbers {

//	두 수의 나눗셈

//	문제 설명
//	정수 num1과 num2가 매개변수로 주어질 때, num1을 num2로 나눈 값에 1,000을 곱한 후 정수 부분을 return 하도록 soltuion 함수를 완성해주세요.

//	입출력 예 설명
//	입출력 예 #1
//	num1이 3, num2가 2이므로 3 / 2 = 1.5에 1,000을 곱하면 1500이 됩니다.
//	입출력 예 #2
//	num1이 7, num2가 3이므로 7 / 3 = 2.33333...에 1,000을 곱하면 2333.3333.... 이 되며, 정수 부분은 2333입니다.
//	입출력 예 #3
//	num1이 1, num2가 16이므로 1 / 16 = 0.0625에 1,000을 곱하면 62.5가 되며, 정수 부분은 62입니다.

	public int solution(int num1, int num2) {
		int answer = 0;
		if (0 < num1 && num1 <= 100 && 0 < num2 && num2 <= 100) {
			double num3 = (double) num1 / num2;
			answer = (int) (num3 * 1000);
		}
		return answer;
	}

	@Test
	public void test() {
		int result1 = solution(3, 2);
		int result2 = solution(7, 3);
		int result3 = solution(1, 16);

		assertThat(result1).isEqualTo(1500);
		assertThat(result2).isEqualTo(2333);
		assertThat(result3).isEqualTo(62);
	}

}
