package programmers.level0;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TheNumberThatComesNext {

//	다음에 올 숫자

//	문제 설명
//	등차수열 혹은 등비수열 common이 매개변수로 주어질 때, 마지막 원소 다음으로 올 숫자를 return 하도록 solution 함수를 완성해 보세요.

//	제한사항
//	2 < common의 길이 < 1,000
//	-1,000 < common의 원소 < 2,000
//	common의 원소는 모두 정수입니다.
//	등차수열 혹은 등비수열이 아닌 경우는 없습니다.
//	등비수열인 경우 공비는 0이 아닌 정수입니다.

//	입출력 예
//	입출력 예 #1
//	Input : [1, 2, 3, 4] / Output : 5
//	[1, 2, 3, 4]는 공차가 1인 등차수열이므로 다음에 올 수는 5이다.

//	입출력 예 #2
//	Input : [2, 4, 8] / Output : 16
//	[2, 4, 8]은 공비가 2인 등비수열이므로 다음에 올 수는 16이다.

//	입출력 예 #3
//	Input : [-1, 2, -4] / Output : 8
//	[-1, 2, -4]은 공비가 -2인 등비수열이므로 다음에 올 수는 8이다.

	public int solution(int[] common) {
		int first = common[0];
		int second = common[1];
		int third = common[2];

		int diff1 = second - first;
		int diff2 = third - second;
		if (diff1 == diff2) {
			return common[common.length - 1] + diff1;
		} else {
			return common[common.length - 1] * second / first;
		}
	}

	@Test
	public void test() {
		int result1 = solution(new int[] { 1, 2, 3, 4 });
		int result2 = solution(new int[] { 2, 4, 8 });
		int result3 = solution(new int[] { -1, 2, -4 });

		assertThat(result1).isEqualTo(5);
		assertThat(result2).isEqualTo(16);
		assertThat(result3).isEqualTo(8);
	}

}
