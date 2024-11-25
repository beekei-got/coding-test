package programmers.level1;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class WalkInThePark { // 공원 산책

	public int[] solution(String[] park, String[] routes) {
		int height = park.length;
		int width = park[0].length();

		int[] dog = new int[2];
		String[][] map = new String[height][width];
		for (int y = 0; y < height; y++) {
			String[] parkSplit = park[y].split("");
			for (int x = 0; x < width; x++) {
				if (parkSplit[x].equals("S")) {
					dog[0] = y;
					dog[1] = x;
				}
				map[y][x] = parkSplit[x];
			}
		}

		Map<String, int[]> routeMap = Map.ofEntries(
			Map.entry("N", new int[]{ -1, 0 }),
			Map.entry("S", new int[]{ 1, 0 }),
			Map.entry("W", new int[]{ 0, -1 }),
			Map.entry("E", new int[]{ 0, 1 }));

		for (String route : routes) {
			String[] split = route.split(" ");

			boolean go = true;
			int y = dog[0];
			int x = dog[1];
			for (int i = 0; i < Integer.parseInt(split[1]); i++) {
				y += routeMap.get(split[0])[0];
				x += routeMap.get(split[0])[1];
				if (y < 0 || y >= height || x < 0 || x >= width || map[y][x].equals("X")) {
					go = false;
					break;
				}
			}

			if (go) {
				dog[0] = y;
				dog[1] = x;
			}
		}

		return dog;
	}
	
	@Test
	public void test() {
		int[] result1 = solution(new String[]{ "SOO","OOO","OOO" }, new String[]{ "E 2","S 2","W 1" });
		int[] result2 = solution(new String[]{ "SOO","OXX","OOO" }, new String[]{ "E 2","S 2","W 1" });
		int[] result3 = solution(new String[]{ "OSO","OOO","OXO","OOO" }, new String[]{ "E 2","S 3","W 1" });

		assertThat(result1).isEqualTo(new int[]{ 2, 1 });
		assertThat(result2).isEqualTo(new int[]{ 0, 1 });
		assertThat(result3).isEqualTo(new int[]{ 0, 0 });
	}


}
