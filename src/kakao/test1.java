package kakao;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class test1 {
	public static String[] solution(String[] record) {
		Queue<Name> q = new LinkedList<Name>();
		HashMap<String,String> map = new HashMap<String,String>();
	
		for(int i=0;i<record.length;i++) {
			String[] array = record[i].split(" ");
			String m = array[0];
			String id = array[1];
			String nic = "";
			if(m.equals("Leave")){
				map.put(id,nic);
				q.add(new Name(m,id));
			}
			else{
				nic = array[2];
				map.put(id,nic);
				q.add(new Name(m,id));
			}
		}
		
		String[] answer = new String[4];
		for(int i=0;i<q.size()+2;i++) {
			String temp = "";
			Name n = q.poll();
			temp += map.get(n.id);
			if(n.m.equals("Enter")) {
				temp += "님이 들어왔습니다.";
			}
			else if(n.m.equals("Change")) continue;
			else if(n.m.equals("Leave")) temp += "님이 나갔습니다.";
			answer[i] = temp;
		}
        
        return answer;
    }
	public static void main(String args[]) {
		String [] ss = {"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"};
		String [] a;
		a = solution(ss);
		for(int i=0;i<a.length;i++) {
			System.out.println(a[i]);
		}
	}
	public static class Name{
		String id;
		String m;
		public Name(String m,String id) {
			this.m = m;
			this.id = id;
		}
	}
}
