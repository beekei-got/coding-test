package programmers.level1;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class RunningRace { // 달리기 경주

	public String[] solution(String[] players, String[] callings) {
		Map<String, Integer> map = new HashMap<>();
		for (int i = 0; i < players.length; i++) {
			map.put(players[i], i);
		}

		for (String calling : callings) {
			int index = map.get(calling);
			map.put(players[index - 1], index);
			map.put(calling, index - 1);
			players[index] = players[index - 1];
			players[index - 1] = calling;
		}

		return players;
	}

	@Test
	public void test() {
		String[] result1 = solution(new String[]{ "mumu", "soe", "poe", "kai", "mine" }, new String[]{ "kai", "kai", "mine", "mine" });

		assertThat(result1).isEqualTo(new String[]{ "mumu", "kai", "mine", "soe", "poe" });
	}


}
