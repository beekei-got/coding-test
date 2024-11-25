package programmers.level0;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class CharactersCoordinates {

	public int[] solution(String[] keyinput, int[] board) {
		int[] coordinate = new int[]{ 0, 0 };

		Map<String, int[]> moves = Map.ofEntries(
			Map.entry("up",     new int[]{ 0, 1 }),
			Map.entry("down",   new int[]{ 0, -1 }),
			Map.entry("left",   new int[]{ -1, 0 }),
			Map.entry("right",  new int[]{ 1, 0 })
		);

		int boardWidth = board[0] / 2;
		int boardHeight = board[1] / 2;
		for (String input : keyinput) {
			coordinate[0] = Math.min(boardWidth, Math.max(-boardWidth, coordinate[0] + moves.get(input)[0]));
			coordinate[1] = Math.min(boardHeight, Math.max(-boardHeight, coordinate[1] + moves.get(input)[1]));
		}

		return coordinate;
	}

	@Test
	public void test() {
		int[] result1 = solution(new String[]{ "left", "right", "up", "right", "right" }, new int[]{ 11, 11 });
		int[] result2 = solution(new String[]{ "down", "down", "down", "down", "down" }, new int[]{ 7, 9 });

		assertThat(result1).isEqualTo(new int[]{ 2, 1 });
		assertThat(result2).isEqualTo(new int[]{ 0, -4 });
	}

}
