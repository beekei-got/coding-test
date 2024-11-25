package programmers.level0;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ArrangeIntegersInASpiral {

	public int[][] solution(int n) {
		int[][] answer = new int[n][n];

		int number = 1;
		int minRow = 0;
		int maxRow = n - 1;
		int minCol = 0;
		int maxCol = n - 1;

		while (number <= (n * n)) {
			for (int i = minCol; i <= maxCol; i++) {
				answer[minRow][i] = number++;
			}
			minRow++;
			for (int i = minRow; i <= maxRow; i++) {
				answer[i][maxCol] = number++;
			}
			maxCol--;
			for (int i = maxCol; i >= minCol; i--) {
				answer[maxRow][i] = number++;
			}
			maxRow--;
			for (int i = maxRow; i >= minRow; i--) {
				answer[i][minCol] = number++;
			}
			minCol++;
		}
		return answer;
	}

	@Test
	public void test() {
		int[][] result1 = solution(4);
		int[][] result2 = solution(5);

		assertThat(result1).isEqualTo(new int[][]{{1, 2, 3, 4}, {12, 13, 14, 5}, {11, 16, 15, 6}, {10, 9, 8, 7}});
		assertThat(result2).isEqualTo(new int[][]{{1, 2, 3, 4, 5}, {16, 17, 18, 19, 6}, {15, 24, 25, 20, 7}, {14, 23, 22, 21, 8}, {13, 12, 11, 10, 9}});
	}

}
