package programmers.level0;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginSuccessful {

	public String solution(String[] id_pw, String[][] db) {
		return Arrays.stream(db)
			.filter(info -> info[0].equals(id_pw[0]))
			.findFirst()
			.map(info -> info[1].equals(id_pw[1]) ? "login" : "wrong pw")
			.orElse("fail");
	}

	@Test
	public void test() {
		String result1 = solution(
			new String[] { "meosseugi", "1234" },
			new String[][] { {"rardss", "123"}, {"yyoom", "1234"}, {"meosseugi", "1234"} } );
		String result2 = solution(
			new String[] { "programmer01", "15789" },
			new String[][] { {"programmer02", "111111"}, {"programmer00", "134"}, {"programmer01", "1145"} } );
		String result3 = solution(
			new String[] { "rabbit04", "98761" },
			new String[][] { {"jaja11", "98761"}, {"krong0313", "29440"}, {"rabbit00", "111333"} } );

		assertThat(result1).isEqualTo("login");
		assertThat(result2).isEqualTo("wrong pw");
		assertThat(result3).isEqualTo("fail");
	}

}
