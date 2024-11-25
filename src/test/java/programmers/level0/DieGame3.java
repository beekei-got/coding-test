package programmers.level0;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class DieGame3 {

	public int solution(int a, int b, int c, int d) {
		Map<Integer, Integer> map = IntStream.of(a, b, c, d)
			.boxed()
			.collect(Collectors.toMap(Function.identity(), i -> 1, Integer::sum));
		Iterator<Integer> iterator = map.keySet().stream().sorted(Comparator.comparingInt(map::get).reversed()).iterator();
		if (map.size() == 1) {
			int p = iterator.next();
			return 1111 * p;
		} else if (map.size() == 2) {
			int p = iterator.next();
			int q = iterator.next();
			return map.containsValue(2) ?
				(p + q) * Math.abs(p - q) : (10 * p + q) * (10 * p + q);
		} else if (map.size() == 3) {
			int p = iterator.next();
			int q = iterator.next();
			int r = iterator.next();
			return q * r;
		} else {
			return map.keySet().stream().min(Comparator.naturalOrder()).orElse(0);
		}
	}

	@Test
	public void test() {
		int result1 = solution(2, 2, 2, 2);
		int result2 = solution(4, 1, 4, 4);
		int result3 = solution(6, 3, 3, 6);
		int result4 = solution(2, 5, 2, 6);
		int result5 = solution(6, 4, 2, 5);

		assertThat(result1).isEqualTo(2222);
		assertThat(result2).isEqualTo(1681);
		assertThat(result3).isEqualTo(27);
		assertThat(result4).isEqualTo(30);
		assertThat(result5).isEqualTo(2);
	}


}
