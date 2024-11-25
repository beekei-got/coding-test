package programmers.level0;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class FindAreaOfRectangle {

//	직사각형 넓이 구하기

//	문제 설명
//	2차원 좌표 평면에 변이 축과 평행한 직사각형이 있습니다.
//	직사각형 네 꼭짓점의 좌표 [[x1, y1], [x2, y2], [x3, y3], [x4, y4]]가 담겨있는 배열 dots가 매개변수로 주어질 때,
//	직사각형의 넓이를 return 하도록 solution 함수를 완성해 보세요.

//	제한사항
//	dots의 길이 = 4
//	dots의 원소의 길이 = 2
//	-256 < dots[i]의 원소 < 256
//	잘못된 입력은 주어지지 않습니다.

//	입출력 예
//	입출력 예 #1
//	Input : [[1, 1], [2, 1], [2, 2], [1, 2]] / Output : 1
//	입출력 예 #2
//	Input : [[-1, -1], [1, 1], [1, -1], [-1, 1]] / Output : 4

	public int solution(int[][] dots) {
		int[] widths = Arrays.stream(dots).mapToInt(dot -> dot[0]).sorted().toArray();
		int[] heights = Arrays.stream(dots).mapToInt(dot -> dot[1]).sorted().toArray();
		return (widths[widths.length - 1] - widths[0]) * (heights[heights.length - 1] - heights[0]);
	}

	@Test
	public void test() {
		int result1 = solution(new int[][]{ {1, 1}, {2, 1}, {2, 2}, {1, 2} });
		int result2 = solution(new int[][]{ {-1, -1}, {1, 1}, {1, -1}, {-1, 1} });

		assertThat(result1).isEqualTo(1);
		assertThat(result2).isEqualTo(4);
	}

}
