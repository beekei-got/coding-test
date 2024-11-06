package programmers.level0;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Protractor {

//	각도기

//	문제 설명
//	각에서 0도 초과 90도 미만은 예각, 90도는 직각, 90도 초과 180도 미만은 둔각 180도는 평각으로 분류합니다.
//	각 angle이 매개변수로 주어질 때 예각일 때 1, 직각일 때 2, 둔각일 때 3, 평각일 때 4를 return하도록 solution 함수를 완성해주세요.
//	예각 : 0 < angle < 90
//	직각 : angle = 90
//	둔각 : 90 < angle < 180
//	평각 : angle = 180

//	입출력 예 설명
//	입출력 예 #1
//	angle이 70이므로 예각입니다. 따라서 1을 return합니다.
//	입출력 예 #2
//	angle이 91이므로 둔각입니다. 따라서 3을 return합니다.
//	입출력 예 #2
//	angle이 180이므로 평각입니다. 따라서 4를 return합니다.

	public int solution(int angle) {
		int answer = 0;
		if (0 < angle && angle <= 180) {
			int[][] angleType = { {1,89}, {90, 90}, {91, 179}, {180, 180} };
			for (int i = 0; i < angleType.length; i++) {
				if (angleType[i][0] <= angle && angle <= angleType[i][1]) {
					return i + 1;
				}
			}

		}
		return answer;
	}

	@Test
	public void test() {
		int result1 = solution(70);
		int result2 = solution(91);
		int result3 = solution(180);

		assertThat(result1).isEqualTo(1);
		assertThat(result2).isEqualTo(3);
		assertThat(result3).isEqualTo(4);
	}

}
