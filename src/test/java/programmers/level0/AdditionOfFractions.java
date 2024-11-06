package programmers.level0;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AdditionOfFractions {

//	배열 두배 만들기

//	문제 설명
//	첫 번째 분수의 분자와 분모를 뜻하는 numer1, denom1, 두 번째 분수의 분자와 분모를 뜻하는 numer2, denom2가 매개변수로 주어집니다.
//	두 분수를 더한 값을 기약 분수로 나타냈을 때 분자와 분모를 순서대로 담은 배열을 return 하도록 solution 함수를 완성해보세요.

//	제한사항
//	- 0 <numer1, denom1, numer2, denom2 < 1,000

//	입출력 예 설명
//	입출력 예 #1
//	1 / 2 + 3 / 4 = 5 / 4입니다. 따라서 [5, 4]를 return 합니다.
//	입출력 예 #2
//	9 / 2 + 1 / 3 = 29 / 6입니다. 따라서 [29, 6]을 return 합니다.

	public boolean valid(int number) {
		return 0 < number && number < 1000;
	}

	public int gcd(int numer, int denom) {
		while (denom != 0) {
			int remainder = numer % denom;
			numer = denom;
			denom = remainder;
		}
		return numer;
	}

	public int[] solution(int numer1, int denom1, int numer2, int denom2) {
		int[] answer = {};
		if (valid(numer1) && valid(denom1) && valid(numer2) && valid(denom2)) {
			int numer = (numer1 * denom2) + (numer2 * denom1);
			int denom = denom1 * denom2;

			int max = gcd(numer, denom);
			numer /= max;
			denom /= max;

			answer = new int[] { numer, denom };
		}
		return answer;
	}

	@Test
	public void test() {
		int[] result1 = solution(1, 2, 3, 4);
		int[] result2 = solution(9, 2, 1, 3);

		assertThat(result1).isEqualTo(new int[] { 5, 4 });
		assertThat(result2).isEqualTo(new int[] { 29, 6 });
	}

}
