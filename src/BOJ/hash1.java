package han;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

public class hash1 {
    public static String solution(String[] participant, String[] completion) {
        String answer = "";
        Arrays.sort(participant);
        Arrays.sort(completion);
        int i;
        for(i=0;i<completion.length;i++) {
        	if(!participant[i].equals(completion[i])) return participant[i];
        }
        return participant[i];
    }
	public static void main(String args[]) {
		//mislav, stanko, mislav, ana]	[stanko, ana, mislav]
		String a[] = {"mislav", "stanko", "mislav", "ana","ana"};
		String b[] = {"stanko", "ana", "mislav","mislav"};
		solution(a,b);
	}
}
