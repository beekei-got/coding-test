package programmers.level0;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class RockPaperScissors {

	public String solution(String rsp) {
		Map<String, String> win = Map.ofEntries(
			Map.entry("2", "0"),
			Map.entry("0", "5"),
			Map.entry("5", "2"));
		return Arrays.stream(rsp.split(""))
			.map(win::get)
			.reduce("", (a, b) -> a + b);
	}

	@Test
	public void test() {
		String result1 = solution("2");
		String result2 = solution("205");

		assertThat(result1).isEqualTo("0");
		assertThat(result2).isEqualTo("052");
	}

}
