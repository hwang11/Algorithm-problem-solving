package aaa;

import java.util.LinkedList;

public class Q1 {
	static LinkedList<String> mo = new LinkedList<String>();
	static LinkedList<String> ever = new LinkedList<String>();

	public static String[] solution(String[] record) {
		for(int i=0;i<record.length;i++) {
			String[] idx = record[i].split(" ");
			if(idx[0].equals("RECEIVE")) {
				mo.add(idx[1]);
				//System.out.println(idx[0]+","+idx[1]);

			}else if(idx[0].equals("SAVE")) {
				for(int j=0;j<mo.size();j++) {
					ever.add(mo.get(j));
				}
				if(mo.isEmpty()) continue;
				mo.removeAll(mo);
			}
			else if(idx[0].equals("DELETE")) {
				if(mo.isEmpty()) continue;
				mo.removeLast();
			}
		}
		String[] answer = new String[ever.size()];
		//System.out.println(ever.get(0));
		for(int i=0;i<ever.size();i++){
			answer[i] = ever.get(i);
		}
		for(int i=0;i<answer.length;i++) {
			System.out.println(answer[i]);
		}
		return answer;
	}
	public static void main(String[] args) {
		//String a[] = {"RECEIVE abcd@naver.com", "RECEIVE zzkn@naver.com", "DELETE", "RECEIVE qwerty@naver.com", "SAVE", "RECEIVE QwerTY@naver.com"};
		String a[] = {"RECEIVE abcd@naver.com", "RECEIVE zzkn@naver.com", "DELETE",
		              "RECEIVE qwerty@naver.com", "SAVE", "SAVE", "DELETE", "RECEIVE QwerTY@naver.com", "SAVE"};
		//solution(a);
		LinkedList l = new LinkedList<Integer>();
		l.add(1);
		l.add(2);
		l.removeAll(l);
		System.out.println(l.size());
	}	
}
