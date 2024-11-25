package programmers.level1;

import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.function.Function;

import static org.assertj.core.api.Assertions.assertThat;

public class VideoPlayer { // 동영상 재생기
//	문제 설명
//	당신은 동영상 재생기를 만들고 있습니다.
//	당신의 동영상 재생기는 10초 전으로 이동, 10초 후로 이동, 오프닝 건너뛰기 3가지 기능을 지원합니다. 각 기능이 수행하는 작업은 다음과 같습니다.

//	10초 전으로 이동:
//	사용자가 "prev" 명령을 입력할 경우 동영상의 재생 위치를 현재 위치에서 10초 전으로 이동합니다.
//	현재 위치가 10초 미만인 경우 영상의 처음 위치로 이동합니다. 영상의 처음 위치는 0분 0초입니다.

//	10초 후로 이동:
//	사용자가 "next" 명령을 입력할 경우 동영상의 재생 위치를 현재 위치에서 10초 후로 이동합니다.
//	동영상의 남은 시간이 10초 미만일 경우 영상의 마지막 위치로 이동합니다. 영상의 마지막 위치는 동영상의 길이와 같습니다.

//	오프닝 건너뛰기:
//	현재 재생 위치가 오프닝 구간(op_start ≤ 현재 재생 위치 ≤ op_end)인 경우 자동으로 오프닝이 끝나는 위치로 이동합니다.

//	동영상의 길이를 나타내는 문자열 video_len, 기능이 수행되기 직전의 재생위치를 나타내는 문자열 pos, 오프닝 시작 시각을 나타내는 문자열 op_start,
//	오프닝이 끝나는 시각을 나타내는 문자열 op_end, 사용자의 입력을 나타내는 1차원 문자열 배열 commands가 매개변수로 주어집니다.
//	이때 사용자의 입력이 모두 끝난 후 동영상의 위치를 "mm:ss" 형식으로 return 하도록 solution 함수를 완성해 주세요.

	public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
		LocalTime videoStart = LocalTime.parse("00:00:00");
		LocalTime videoEnd = LocalTime.parse("00:" + video_len);
		LocalTime opStart = LocalTime.parse("00:" + op_start);
		LocalTime opEnd = LocalTime.parse("00:" + op_end);
		LocalTime posTime = LocalTime.parse("00:" + pos);

		Map<String, Function<LocalTime, LocalTime>> map = Map.ofEntries(
			Map.entry("skip", (time) -> !time.isBefore(opStart) && !time.isAfter(opEnd) ? opEnd : time),
			Map.entry("next", (time) -> {
				LocalTime nextTime = time.plusSeconds(10);
				return nextTime.isAfter(videoEnd) ? videoEnd : nextTime;
			}),
			Map.entry("prev", (time) -> {
				LocalTime prevTime = time.minusSeconds(10);
				return prevTime.isBefore(videoStart) || prevTime.isAfter(videoEnd) ? videoStart : prevTime;
			}));

		posTime = map.get("skip").apply(posTime);
		for (String command : commands) {
			posTime = map.get(command).apply(posTime);
			posTime = map.get("skip").apply(posTime);
		}

		return posTime.format(DateTimeFormatter.ofPattern("mm:ss"));
	}

	@Test
	public void test() {
		String result1 = solution("34:33", "13:00", "00:55", "02:55", new String[]{ "next", "prev" });
		String result2 = solution("10:55", "00:05", "00:15", "06:55", new String[]{ "prev", "next", "next" });
		String result3 = solution("07:22", "04:05", "00:15", "04:07", new String[]{ "next" });
		String result4 = solution("10:00", "00:03", "00:00", "00:05", new String[]{ "prev", "next" });

		assertThat(result1).isEqualTo("13:00");
		assertThat(result2).isEqualTo("06:55");
		assertThat(result3).isEqualTo("04:17");
		assertThat(result4).isEqualTo("00:15");
	}

}
