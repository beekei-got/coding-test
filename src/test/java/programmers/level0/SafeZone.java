package programmers.level0;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class SafeZone {

//	안전지대

//	문제 설명
//	다음 그림과 같이 지뢰가 있는 지역과 지뢰에 인접한 위, 아래, 좌, 우 대각선 칸을 모두 위험지역으로 분류합니다.
//	지뢰는 2차원 배열 board에 1로 표시되어 있고 board에는 지뢰가 매설 된 지역 1과, 지뢰가 없는 지역 0만 존재합니다.
//	지뢰가 매설된 지역의 지도 board가 매개변수로 주어질 때, 안전한 지역의 칸 수를 return하도록 solution 함수를 완성해주세요.

//	제한사항
//	board는 n * n 배열입니다.
//	1 ≤ n ≤ 100
//	지뢰는 1로 표시되어 있습니다.
//	board에는 지뢰가 있는 지역 1과 지뢰가 없는 지역 0만 존재합니다.

//	입출력 예
//	Input : [[0, 0, 0, 0, 0], [0, 0, 0, 0, 0], [0, 0, 0, 0, 0], [0, 0, 1, 0, 0], [0, 0, 0, 0, 0]] / Output : 16
//	Input : [[0, 0, 0, 0, 0], [0, 0, 0, 0, 0], [0, 0, 0, 0, 0], [0, 0, 1, 1, 0], [0, 0, 0, 0, 0]] / Output : 13
//	Input : [[1, 1, 1, 1, 1, 1], [1, 1, 1, 1, 1, 1], [1, 1, 1, 1, 1, 1], [1, 1, 1, 1, 1, 1], [1, 1, 1, 1, 1, 1]] / Output : 0

//	입출력 예 설명
//	입출력 예 #1
//	(3, 2)에 지뢰가 있으므로 지뢰가 있는 지역과 지뢰와 인접한 위, 아래, 좌, 우, 대각선 총 8칸은 위험지역입니다. 따라서 16을 return합니다.
//	입출력 예 #2
//	(3, 2), (3, 3)에 지뢰가 있으므로 지뢰가 있는 지역과 지뢰와 인접한 위, 아래, 좌, 우, 대각선은 위험지역입니다. 따라서 위험지역을 제외한 칸 수 13을 return합니다.
//	입출력 예 #3
//	모든 지역에 지뢰가 있으므로 안전지역은 없습니다. 따라서 0을 return합니다.

	public int solution(int[][] board) {
		int[][] checkPoints = new int[][] {
			{1, -1}, {1, 0}, {1, 1},
			{0, -1},          {0, 1},
			{-1, -1}, {-1, 0}, {-1, 1}
		};
		int boardLengthY = board.length;
		for (int y = 0; y < board.length; y++) {
			int boardLengthX = board[y].length;
			for (int x = 0; x < boardLengthX; x++) {
				int isBomb = board[x][y];
				if (isBomb == 1) {
					for (int[] checkPoint : checkPoints) {
						int checkPointY = (y  + checkPoint[0]);
						int checkPointX = (x + checkPoint[1]);
						if (checkPointY >= 0 && checkPointY < boardLengthY &&
							checkPointX >= 0 && checkPointX < boardLengthX) {
							if (board[checkPointX][checkPointY] == 0) {
								board[checkPointX][checkPointY] = 2;
							}
						}
					}
				}
			}
		}
		return Arrays.stream(board)
			.map(x -> (int) Arrays.stream(x).filter(y -> y == 0).count())
			.reduce(0, Integer::sum);
	}

	@Test
	public void test() {
		int result1 = solution(new int[][]{ {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 1, 0, 0}, {0, 0, 0, 0, 0} });
		int result2 = solution(new int[][]{ {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 1, 1, 0}, {0, 0, 0, 0, 0} });
		int result3 = solution(new int[][]{ {1, 1, 1, 1, 1}, {1, 1, 1, 1, 1}, {1, 1, 1, 1, 1}, {1, 1, 1, 1, 1}, {1, 1, 1, 1, 1} });

		assertThat(result1).isEqualTo(16);
		assertThat(result2).isEqualTo(13);
		assertThat(result3).isEqualTo(0);
	}

}
