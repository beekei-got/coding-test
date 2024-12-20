package programmers.level0;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class IDontLikeEvenNumbers {

//	짝수는 싫어요

//	문제 설명
//	정수 n이 매개변수로 주어질 때, n 이하의 홀수가 오름차순으로 담긴 배열을 return하도록 solution 함수를 완성해주세요.

//	제한사항
//	1 ≤ n ≤ 100

//	입출력 예 설명
//	입출력 #1
//	10 이하의 홀수가 담긴 배열 [1, 3, 5, 7, 9]를 return합니다.
//	입출력 #2
//	15 이하의 홀수가 담긴 배열 [1, 3, 5, 7, 9, 11, 13, 15]를 return합니다.

	public int[] solution(int n) {
		return IntStream.rangeClosed(0, n)
			.filter(num -> num % 2 == 1)
			.toArray();
	}

	@Test
	public void test() {
		int[] result1 = solution(10);
		int[] result2 = solution(15);

		assertThat(result1).isEqualTo(new int[]{ 1, 3, 5, 7, 9 });
		assertThat(result2).isEqualTo(new int[]{ 1, 3, 5, 7, 9, 11, 13, 15 });
	}

}
