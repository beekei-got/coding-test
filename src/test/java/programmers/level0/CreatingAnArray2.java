package programmers.level0;

import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class CreatingAnArray2 {

	public int[] solution(int l, int r) {
		int min = Integer.parseInt("1" + ("0".repeat(String.valueOf(l).length() - 1)), 2);
		int max = Integer.parseInt("1".repeat(String.valueOf(r).length()), 2);
		int[] answer = IntStream.rangeClosed(min, max)
			.map(num -> Integer.parseInt(Integer.toBinaryString(num)) * 5)
			.filter(num -> l <= num && r >= num)
			.toArray();
		return answer.length == 0 ? new int[] { -1 } : answer;
	}

	@Test
	public void test() {
		int[] result1 = solution(5, 555);
		int[] result2 = solution(10, 20);

		assertThat(result1).isEqualTo(new int[]{ 5, 50, 55, 500, 505, 550, 555 });
		assertThat(result2).isEqualTo(new int[]{ -1 });
	}

}
