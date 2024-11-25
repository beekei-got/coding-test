package programmers.level0;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DiscriminateFiniteDecimal {

//	유한소수 판별하기

	public int gcd(int a, int b) {
		while (b != 0) {
			int r = a % b;
			a = b;
			b = r;
		}
		return a;
	}

	public int solution(int a, int b) {
		int max = gcd(a, b);
		a /= max;
		b /= max;

		while (b % 5 == 0) b /= 5;
		while (b % 2 == 0) b /= 2;

		return a % b == 0 || b == 1 ? 1 : 2;
	}

	@Test
	public void test() {
		int result1 = solution(7, 20);
		int result2 = solution(11, 22);
		int result3 = solution(12, 21);
		int result4 = solution(9, 18);
		int result5 = solution(16, 24);
		int result6 = solution(1, 12);

		assertThat(result1).isEqualTo(1);
		assertThat(result2).isEqualTo(1);
		assertThat(result3).isEqualTo(2);
		assertThat(result4).isEqualTo(1);
		assertThat(result5).isEqualTo(2);
		assertThat(result6).isEqualTo(2);
	}

}
