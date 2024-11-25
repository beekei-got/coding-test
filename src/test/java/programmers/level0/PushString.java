package programmers.level0;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PushString {

//	문자열 밀기

	public int solution(String A, String B) {
		int pushCount = 0;
		while (!A.equals(B) && pushCount < A.length()) {
			A = A.substring(A.length() - 1) + A.substring(0, A.length() - 1);
			pushCount++;
		}
		return A.equals(B) ? pushCount : -1;
	}

	@Test
	public void test() {
		int result1 = solution("hello", "ohell");
		int result2 = solution("apple", "elppa");
		int result3 = solution("atat", "tata");
		int result4 = solution("abc", "abc");

		assertThat(result1).isEqualTo(1);
		assertThat(result2).isEqualTo(-1);
		assertThat(result3).isEqualTo(1);
		assertThat(result4).isEqualTo(0);
	}

}
