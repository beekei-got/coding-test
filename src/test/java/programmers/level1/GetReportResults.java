package programmers.level1;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class GetReportResults { // 신고 결과 받기

	public int[] solution(String[] id_list, String[] report, int k) {
		AtomicInteger index = new AtomicInteger(0);
		Map<String, Integer> idMap = Arrays.stream(id_list).collect(Collectors.toMap(Function.identity(), id -> index.getAndIncrement()));

		int[] reportCount = new int[id_list.length];
		int[][] reportLog = new int[id_list.length][id_list.length];
		report = Arrays.stream(report).distinct().toArray(String[]::new);
		for (String r : report) {
			String[] split = r.split(" ");
			int idIndex = idMap.get(split[0]);
			int reportIdIndex = idMap.get(split[1]);
			reportLog[idIndex][reportIdIndex]++;
			reportCount[reportIdIndex]++;
		}

		int[] alarmCount = new int[id_list.length];
		for (int i = 0; i < id_list.length; i++) {
			for (int j = 0; j < id_list.length; j++) {
				if (i == j) continue;
				if (reportLog[i][j] > 0 && reportCount[j] >= k) {
					alarmCount[i]++;
				}
			}
		}

		return alarmCount;
	}

	@Test
	public void test() {
		int[] result1 = solution(
			new String[]{ "muzi", "frodo", "apeach", "neo" },
			new String[]{ "muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi" },
			2);
		int[] result2 = solution(
			new String[]{ "con", "ryan" },
			new String[]{ "ryan con", "ryan con", "ryan con", "ryan con" },
			3);

		assertThat(result1).isEqualTo(new int[]{ 2, 1, 1, 0 });
		assertThat(result2).isEqualTo(new int[]{ 0, 0 });
	}

}
