package programmers.level0;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SumOfConsecutiveNumbers {

//	연속된 수의 합
//	문제 설명
//	연속된 세 개의 정수를 더해 12가 되는 경우는 3, 4, 5입니다. 두 정수 num과 total이 주어집니다.
//	연속된 수 num개를 더한 값이 total이 될 때, 정수 배열을 오름차순으로 담아 return하도록 solution함수를 완성해보세요.

//	제한사항
//	- 1 ≤ num ≤ 100
//	- 0 ≤ total ≤ 1000
//	- num개의 연속된 수를 더하여 total이 될 수 없는 테스트 케이스는 없습니다.

//	입출력 예
//	입출력 예 #1
//	Input : 3(num), 12(total) / Output : [3, 4, 5]
//	입출력 예 #2
//	Input : 5(num), 15(total) / Output : [1, 2, 3, 4, 5]
//	입출력 예 #3
//	Input : 4(num), 14(total) / Output : [2, 3, 4, 5]
//	입출력 예 #4
//	Input : 5(num), 5(total) / Output : [-1, 0, 1, 2, 3]
//	입출력 예 #5
//	Input : 5(num), 0(total) / Output : [-2, -1, 0, 1, 2]

	public int[] solution(int num, int total) {
		int[] answer = new int[num];
		int start = (total/num) - ((num-1)/2);
		for (int i = 0; i < num; i++){
			answer[i] = start + i;
		}
		return answer;
	}

	@Test
	public void test() {
		int[] result1 = solution(3, 12);
		int[] result2 = solution(5, 15);
		int[] result3 = solution(4, 14);
		int[] result4 = solution(5, 5);
		int[] result5 = solution(5, 0);

		assertThat(result1).isEqualTo(new int[] { 3, 4, 5 });
		assertThat(result2).isEqualTo(new int[] { 1, 2, 3, 4, 5 });
		assertThat(result3).isEqualTo(new int[] { 2, 3, 4, 5 });
		assertThat(result4).isEqualTo(new int[] { -1, 0, 1, 2, 3 });
		assertThat(result5).isEqualTo(new int[] { -2, -1, 0, 1, 2 });
	}

}
