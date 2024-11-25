package programmers.level1;

import org.junit.jupiter.api.Test;


import java.util.List;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class MostReceivedGift { // 가장 많이 받은 선물

//	문제 설명
//	선물을 직접 전하기 힘들 때 카카오톡 선물하기 기능을 이용해 축하 선물을 보낼 수 있습니다.
//	당신의 친구들이 이번 달까지 선물을 주고받은 기록을 바탕으로 다음 달에 누가 선물을 많이 받을지 예측하려고 합니다.

//	두 사람이 선물을 주고받은 기록이 있다면, 이번 달까지 두 사람 사이에 더 많은 선물을 준 사람이 다음 달에 선물을 하나 받습니다.
//	예를 들어 A가 B에게 선물을 5번 줬고, B가 A에게 선물을 3번 줬다면 다음 달엔 A가 B에게 선물을 하나 받습니다.

//	두 사람이 선물을 주고받은 기록이 하나도 없거나 주고받은 수가 같다면, 선물 지수가 더 큰 사람이 선물 지수가 더 작은 사람에게 선물을 하나 받습니다.
//	선물 지수는 이번 달까지 자신이 친구들에게 준 선물의 수에서 받은 선물의 수를 뺀 값입니다.
//	예를 들어 A가 친구들에게 준 선물이 3개고 받은 선물이 10개라면 A의 선물 지수는 -7입니다.
//	B가 친구들에게 준 선물이 3개고 받은 선물이 2개라면 B의 선물 지수는 1입니다.
//	만약 A와 B가 선물을 주고받은 적이 없거나 정확히 같은 수로 선물을 주고받았다면, 다음 달엔 B가 A에게 선물을 하나 받습니다.
//	만약 두 사람의 선물 지수도 같다면 다음 달에 선물을 주고받지 않습니다.
//	위에서 설명한 규칙대로 다음 달에 선물을 주고받을 때, 당신은 선물을 가장 많이 받을 친구가 받을 선물의 수를 알고 싶습니다.
//	친구들의 이름을 담은 1차원 문자열 배열 friends 이번 달까지 친구들이 주고받은 선물 기록을 담은 1차원 문자열 배열 gifts가 매개변수로 주어집니다.
//	이때, 다음달에 가장 많은 선물을 받는 친구가 받을 선물의 수를 return 하도록 solution 함수를 완성해 주세요.

	public int solution(String[] friends, String[] gifts) {
		List<String> friendList = Arrays.asList(friends);

		int[] giftScore = new int[friends.length];
		int[][] giftRelation = new int[friends.length][gifts.length];
		for (String gift : gifts) {
			String[] split = gift.split(" ");
			giftScore[friendList.indexOf(split[0])]++;
			giftScore[friendList.indexOf(split[1])]--;
			giftRelation[friendList.indexOf(split[0])][friendList.indexOf(split[1])]++;
		}

		int max = 0;
		for (int i = 0; i < friends.length; i++) {
			int receivedCount = 0;
			for (int j = 0; j < friends.length; j++) {
				if (i == j) continue;
				if (giftRelation[i][j] > giftRelation[j][i] || (giftRelation[i][j] == giftRelation[j][i] && giftScore[i] > giftScore[j]))
					receivedCount++;
			}
			max = Math.max(max, receivedCount);
		}

		return max;
	}

	@Test
	public void test() {
		int result1 = solution(
			new String[]{ "muzi", "ryan", "frodo", "neo" },
			new String[]{ "muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi", "frodo ryan", "neo muzi" });
		int result2 = solution(
			new String[]{ "joy", "brad", "alessandro", "conan", "david" },
			new String[]{ "alessandro brad", "alessandro joy", "alessandro conan", "david alessandro", "alessandro david" });
		int result3 = solution(
			new String[]{ "a", "b", "c" },
			new String[]{ "a b", "b a", "c a", "a c", "a c", "c a" });

		assertThat(result1).isEqualTo(2);
		assertThat(result2).isEqualTo(4);
		assertThat(result3).isEqualTo(0);
	}

}
