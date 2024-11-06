package programmers.level0;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Parallel {

//	문제 설명
//	점 네 개의 좌표를 담은 이차원 배열  dots가 다음과 같이 매개변수로 주어집니다.
//	[[x1, y1], [x2, y2], [x3, y3], [x4, y4]]
//	주어진 네 개의 점을 두 개씩 이었을 때, 두 직선이 평행이 되는 경우가 있으면 1을 없으면 0을 return 하도록 solution 함수를 완성해보세요.

//	제한사항
//	dots의 길이 = 4dots의 원소는 [x, y] 형태이며 x, y는 정수입니다.
//	0 ≤ x, y ≤ 100
//	서로 다른 두개 이상의 점이 겹치는 경우는 없습니다.
//	두 직선이 겹치는 경우(일치하는 경우)에도 1을 return 해주세요.
//	임의의 두 점을 이은 직선이 x축 또는 y축과 평행한 경우는 주어지지 않습니다.

//	입출력 예 설명
//	입출력 예 #1
//	점 [1, 4], [3, 8]을 잇고 [9, 2], [11, 6]를 이으면 두 선분은 평행합니다.
//	입출력 예 #2
//	점을 어떻게 연결해도 평행하지 않습니다.

	private double calculateLean(int[] dotA, int[] dotB) {
		return (double) (dotA[1] - dotB[1]) / (dotA[0] - dotB[0]);
	}

	private int solution(int[][] dots) {
		int[] dot1 = dots[0];
		int[] dot2 = dots[1];
		int[] dot3 = dots[2];
		int[] dot4 = dots[3];

		if (calculateLean(dot1, dot2) == calculateLean(dot3, dot4)) return 1;
		if (calculateLean(dot1, dot3) == calculateLean(dot2, dot4)) return 1;
		if (calculateLean(dot1, dot4) == calculateLean(dot2, dot3)) return 1;

		return 0;
	}

	@Test
	public void test() {
		int result1 = solution(new int[][]{ {1, 4}, {9, 2}, {3, 8}, {11, 6} });
		int result2 = solution(new int[][]{ {3, 5}, {4, 1}, {2, 4}, {5, 10} });
		int result3 = solution(new int[][]{ {1, 2}, {5, 1}, {3, 6}, {6, 3} });
		int result4 = solution(new int[][]{ {1, 2}, {2, 1}, {3, 4}, {4, 5} });

		assertThat(result1).isEqualTo(1);
		assertThat(result2).isEqualTo(0);
		assertThat(result3).isEqualTo(1);
		assertThat(result4).isEqualTo(0);
	}

}
