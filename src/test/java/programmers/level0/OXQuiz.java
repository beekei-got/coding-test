package programmers.level0;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class OXQuiz {

//	OX퀴즈

//	문제 설명
//	덧셈, 뺄셈 수식들이 'X [연산자] Y = Z' 형태로 들어있는 문자열 배열 quiz가 매개변수로 주어집니다.
//	수식이 옳다면 "O"를 틀리다면 "X"를 순서대로 담은 배열을 return하도록 solution 함수를 완성해주세요.
//
//	제한사항
//	연산 기호와 숫자 사이는 항상 하나의 공백이 존재합니다. 단 음수를 표시하는 마이너스 기호와 숫자 사이에는 공백이 존재하지 않습니다.
//	1 ≤ quiz의 길이 ≤ 10
//	X, Y, Z는 각각 0부터 9까지 숫자로 이루어진 정수를 의미하며, 각 숫자의 맨 앞에 마이너스 기호가 하나 있을 수 있고 이는 음수를 의미합니다.
//	X, Y, Z는 0을 제외하고는 0으로 시작하지 않습니다.
//	-10,000 ≤ X, Y ≤ 10,000
//	-20,000 ≤ Z ≤ 20,000
//	[연산자]는 + 와 - 중 하나입니다.

//	입출력 예
//	입출력 예 #1
//	Input : ["3 - 4 = -3", "5 + 6 = 11"] / Output : ["X", "O"]
//	입출력 예 #2
//	Input : ["19 - 6 = 13", "5 + 66 = 71", "5 - 15 = 63", "3 - 1 = 2"] / Output : ["O", "O", "X", "O"]

	public String[] solution(String[] quiz) {
		return Arrays.stream(quiz)
			.map(q -> {
				String[] qa = q.split(" ");
				int num1 = Integer.parseInt(qa[0]);
				String operator = qa[1];
				int num2 = Integer.parseInt(qa[2]);
				int resultNum = Integer.parseInt(qa[4]);
				boolean result = operator.equals("+") ?
					(num1 + num2) == resultNum :
					(num1 - num2) == resultNum;
				return result ? "O" : "X";
			}).toArray(String[]::new);
	}

	@Test
	public void test() {
		String[] result1 = solution(new String[] { "3 - 4 = -3", "5 + 6 = 11" });
		String[] result2 = solution(new String[] { "19 - 6 = 13", "5 + 66 = 71", "5 - 15 = 63", "3 - 1 = 2" });
		String[] result3 = solution(new String[] { "-3 - 3 = -6" });

		assertThat(result1).isEqualTo(new String[] { "X", "O" });
		assertThat(result2).isEqualTo(new String[] { "O", "O", "X", "O" });
		assertThat(result3).isEqualTo(new String[] { "O" });
	}


}
