package programmers.level0;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class LengthOfOverlappingLine {

//	겹치는 선분의 길이

//	문제 설명
//	선분 3개가 평행하게 놓여 있습니다.
//	세 선분의 시작과 끝 좌표가 [[start, end], [start, end], [start, end]] 형태로 들어있는 2차원 배열 lines가 매개변수로 주어질 때,
//	두 개 이상의 선분이 겹치는 부분의 길이를 return 하도록 solution 함수를 완성해보세요.

//	제한사항
//	lines의 길이 = 3
//	lines의 원소의 길이 = 2
//	모든 선분은 길이가 1 이상입니다.
//	lines의 원소는 [a, b] 형태이며, a, b는 각각 선분의 양 끝점 입니다.
//	-100 ≤ a < b ≤ 100

//	입출력 예 설명
//	입출력 예 #1
//	두 번째, 세 번째 선분 [2, 5], [3, 9]가 [3, 5] 구간에 겹쳐있으므로 2를 return 합니다.
//	입출력 예 #2
//	겹친 선분이 없으므로 0을 return 합니다.
//	입출력 예 #3
//	첫 번째와 두 번째 선분이 [3, 5] 구간에서 겹칩니다.
//	첫 번째와 세 번째 선분 [1, 5] 구간에서 겹칩니다.
//	두 번째와 세 번째 선분 [3, 9] 구간에서 겹칩니다.
//	따라서 [1, 9] 구간에 두 개 이상의 선분이 겹쳐있으므로, 8을 return 합니다.

	public int solution(int[][] lines) {
		Map<Integer, Integer> lineMap = new HashMap<>();
		Arrays.stream(lines)
			.forEach(line -> IntStream.range(line[0], line[1])
				.forEach(i -> lineMap.put(i, lineMap.getOrDefault(i, 0) + 1)));
		return (int) lineMap.values().stream().filter(i -> i > 1).count();
	}

	@Test
	public void test() {
		int result1 = solution(new int[][]{ {0, 2}, {-3, -1}, {-2, 1} });
		int result2 = solution(new int[][]{ {0, 1}, {2, 5}, {3, 9} });
		int result3 = solution(new int[][]{ {-1, 1}, {1, 3}, {3, 9} });
		int result4 = solution(new int[][]{ {0, 5}, {3, 9}, {1, 10} });

		assertThat(result1).isEqualTo(2);
		assertThat(result2).isEqualTo(2);
		assertThat(result3).isEqualTo(0);
		assertThat(result4).isEqualTo(8);
	}

}
