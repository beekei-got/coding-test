package programmers.level0;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class NationalCompetitionSelectionTest {

	public int solution(int[] rank, boolean[] attendance) {
		int[] sortedRank = IntStream.range(0, rank.length)
			.filter(i -> attendance[i])
			.boxed()
			.sorted(Comparator.comparingInt(i -> rank[i]))
			.limit(3)
			.mapToInt(i -> i)
			.toArray();
		return (10000 * sortedRank[0]) + (100 * sortedRank[1]) + sortedRank[2];
	}

	@Test
	public void test() {
		int result1 = solution(new int[]{ 3, 7, 2, 5, 4, 6, 1 }, new boolean[]{ false, true, true, true, true, false, false });
		int result2 = solution(new int[]{ 1, 2, 3 }, new boolean[]{ true, true, true });
		int result3 = solution(new int[]{ 6, 1, 5, 2, 3, 4 }, new boolean[]{ true, false, true, false, false, true });

		assertThat(result1).isEqualTo(20403);
		assertThat(result2).isEqualTo(102);
		assertThat(result3).isEqualTo(50200);
	}

}
