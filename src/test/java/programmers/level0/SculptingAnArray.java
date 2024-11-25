package programmers.level0;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class SculptingAnArray {

	public int[] solution(int[] arr, int[] query) {
		for (int i = 0; i < query.length; i++) {
			if (i % 2 == 0) {
				arr = Arrays.copyOfRange(arr, 0, query[i] + 1);
			} else {
				arr = Arrays.copyOfRange(arr, query[i], arr.length);
			}
		}
		return arr;
	}

	@Test
	public void test() {
		int[] result1 = solution(new int[]{ 0, 1, 2, 3, 4, 5 }, new int[]{ 4, 1, 2 });

		assertThat(result1).isEqualTo(new int[]{ 1, 2, 3 });
	}

}
