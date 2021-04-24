package Programmers;

import java.util.Collections;
import java.util.LinkedList;

public class q6 {
	public static String[] solution(String[] directory, String[] command) {
		String[] answer = {};
		LinkedList<String> li = new LinkedList<String>();
		for (int i = 0; i < directory.length; i++) {
			li.add(directory[i]);
		}
		Collections.sort(li);

		for (int i = 0; i < command.length; i++) {
			String str = command[i];
			String[] arr = str.split(" ");
			if (arr[0].equals("mkdir")) {
				li.add(arr[1]);
			} else if (arr[0].equals("cp")) {
//				for (int j = 0; j < li.size(); j++) {
//					StringBuffer sb = new StringBuffer(arr[2]);
//					if (li.get(j).contains(arr[1])) {
//						String s = sb.append(li.get(j)).toString();
//						li.add(s);
//					}
//
//				}

			} else if (arr[0].equals("rm")) {
				for (int j = 0; j < li.size(); j++) {
					if (li.get(j).contains(arr[1]))
						li.remove(j);
				}
			}
		}
		Collections.sort(li);
		answer = new String[li.size()];
		for (int i = 0; i < li.size(); i++) {
			answer[i] = li.get(i);
		}
		return answer;
	}

	public static void main(String[] args) {
		String a[] = { "/", "/hello", "/hello/tmp", "/root", "/root/abcd", "/root/abcd/etc", "/root/abcd/hello" };
		String command[] = { "mkdir /root/tmp", "cp /hello /root/tmp", "rm /hello" };
		// result
		// [
		// "/",
		// "/root",
		// "/root/abcd",
		// "/root/abcd/etc",
		// "/root/abcd/hello",
		// "/root/tmp",
		// "/root/tmp/hello",
		// "/root/tmp/hello/tmp"
		// ]
		solution(a, command);
	}
}
