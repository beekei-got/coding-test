package programmers.level0;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SumOfEvenNumbers {

//	짝수의 합

//	문제 설명
//	정수 n이 주어질 때, n이하의 짝수를 모두 더한 값을 return 하도록 solution 함수를 작성해주세요.

//	제한사항
//	0 < n ≤ 1000

//	입출력 예 설명
//	입출력 예 #1
//	n이 10이므로 2 + 4 + 6 + 8 + 10 = 30을 return 합니다.
//	입출력 예 #2
//	n이 4이므로 2 + 4 = 6을 return 합니다.

	public int solution(int n) {
		int answer = 0;
		if (0 < n && n <= 1000) {
			while(n > 0) {
				if (n % 2 == 0) {
					answer += n;
				}
				n -= 1;
			}
		}
		return answer;
	}

	@Test
	public void test() {
		int result1 = solution(10);
		int result2 = solution(4);

		assertThat(result1).isEqualTo(30);
		assertThat(result2).isEqualTo(6);
	}


}
