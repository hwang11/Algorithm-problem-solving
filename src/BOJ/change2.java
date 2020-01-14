package han;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class change2 {
	public static int solution(String begin, String target, String[] words) {

		Queue<String> queue = new LinkedList<String>();
		queue.offer(begin);

		boolean has_target = false;
		for (int i = 0; i < words.length; i++) {
			if (words[i].equals(target)) {
				has_target = true;
			}
		}
		if (!has_target)
			return 0;

		int answer = 0;

		while (true) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				String str = queue.poll();
				if (str.equals(target))
					return answer;

				for (int j = 0; j < words.length; j++) {
					if (diff(str, words[j]) == 1) {
						queue.offer(words[j]);
					}
				}
			}
			answer += 1;

			if (answer > words.length)
				return 0;
		}

	}

	public static int diff(String str1, String str2) {
		int count = 0;
		for (int i = 0; i < str1.length(); i++) {
			if (str1.charAt(i) != str2.charAt(i))
				count++;
		}
		return count;
	}

}
