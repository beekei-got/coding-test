package programmers.level0;

import org.junit.jupiter.api.Test;


import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class FindTheMode {

	public int solution(int[] array) {
		Map<Integer, Integer> map = Arrays.stream(array)
			.boxed()
			.collect(Collectors.toMap(Function.identity(), i -> 1, Integer::sum));
		return map.keySet().stream()
			.max(Comparator.comparingInt(map::get))
			.filter(key -> map.values().stream()
				.filter(value -> value == map.get(key))
				.count() <= 1)
			.orElse(-1);
	}

	@Test
	public void test() {
		int result1 = solution(new int[]{ 1, 2, 3, 3, 3, 4 });
		int result2 = solution(new int[]{ 1, 1, 2, 2 });
		int result3 = solution(new int[]{ 1 });
		int result4 = solution(new int[]{ 1, 1, 2, 2, 3 });

		assertThat(result1).isEqualTo(3);
		assertThat(result2).isEqualTo(-1);
		assertThat(result3).isEqualTo(1);
		assertThat(result4).isEqualTo(-1);
	}


}
