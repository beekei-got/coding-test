package programmers.level0;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class UnusualArrangement {

//	특이한 정렬

//	문제 설명
//	정수 n을 기준으로 n과 가까운 수부터 정렬하려고 합니다.
//	이때 n으로부터의 거리가 같다면 더 큰 수를 앞에 오도록 배치합니다.
//	정수가 담긴 배열 numlist와 정수 n이 주어질 때 numlist의 원소를 n으로부터 가까운 순서대로 정렬한 배열을 return 하도록 solution 함수를 완성해 주세요.

//	제한사항
//	1 ≤ n ≤ 10,000
//	1 ≤ numlist의 원소 ≤ 10,000
//	1 ≤ numlist의 길이 ≤ 100
//	numlist는 중복된 원소를 갖지 않습니다.

//	입출력 예
//	입출력 예 #1
//	Input : [1, 2, 3, 4, 5, 6](numList), 4(n) / Output : [4, 5, 3, 6, 2, 1]
//	입출력 예 #2
//	Input : [10000, 20, 36, 47, 40, 6, 10, 7000](numList), 30(n) / Output : [36, 40, 20, 47, 10, 6, 7000, 10000]
//	입출력 예 #3
//	Input : [10, 2](numList), 6(n) / Output : [10, 2]

	public int[] solution(int[] numlist, int n) {
		return Arrays.stream(numlist).boxed()
			.sorted((a, b) ->
				Math.abs(a - n) == Math.abs(b - n) ?
					b.compareTo(a) :
					Integer.compare(Math.abs(a - n), Math.abs(b - n)))
			.mapToInt(a -> a)
			.toArray();
	}

	@Test
	public void test() {
		int[] result1 = solution(new int[]{ 1, 2, 3, 4, 5, 6 }, 4);
		int[] result2 = solution(new int[]{ 10000, 20, 36, 47, 40, 6, 10, 7000 }, 30);
		int[] result3 = solution(new int[]{ 10, 2 }, 6);

		assertThat(result1).isEqualTo(new int[]{ 4, 5, 3, 6, 2, 1 });
		assertThat(result2).isEqualTo(new int[]{ 36, 40, 20, 47, 10, 6, 7000, 10000 });
		assertThat(result3).isEqualTo(new int[]{ 10, 2 });
	}

}
