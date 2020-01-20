package BOJ;

import java.util.ArrayList;

public class level22 {
	static boolean chk(String s,String skill) {
		int cnt = 0;
		int ent = 0;
		ArrayList<Character> al = new ArrayList<Character>();
		for(int i=0;i<skill.length();i++) {
			al.add(skill.charAt(i));
		}
		for(int i=s.length()-1;i>=0;i--) {
			if(al.contains(s.charAt(i))) {
				cnt++;
				if(al.get(al.size()-cnt) == s.charAt(i)) ent++;
			}
		}
		if(cnt == ent) {
			return true;
		}
		else return false;
	}
	public static int solution(String skill, String[] skill_trees) {
        int answer = 0;
        for(int i=0;i<skill_trees.length;i++) {
        	if(chk(skill_trees[i],skill)) answer++;
        }
        System.out.println(answer);
        return answer;
    }
	public static void main(String args[]) {
		String arr[] = {"BACDE", "CBADF", "AECB", "BDA"};
		solution("CBD",arr);
	}
}
