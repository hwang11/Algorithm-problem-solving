package aaa;

public class Greedy2 {
	public static int solution(String name) {
		int answer = 0;
		int sidx = 0;
		int eidx = 1;
		//System.out.println(name.charAt(4));
		while(true) {
			if(sidx==name.length()) break;
			int a = 'A' - 64;
			int snum = name.charAt(sidx) - 64;
			int c1 = Math.abs(a - snum); // 위아래이동
			int c2 = Math.abs(26 - snum) + Math.abs(1 - a) + 1;
			if (c1 < c2) answer += c1;
			else answer += c2;			
			if(sidx>=name.length()-1 ) {
				break;
			}
			if (snum != 'A' - 64) {
				int d1 = Math.abs(sidx-eidx);
				int d2 = Math.abs(name.length()-eidx) + Math.abs(0-sidx);
				if(d1<d2) answer+=d1;
				else answer+=d2;
			}
			sidx = eidx;
			eidx++; // 다음꺼
		}
		System.out.println(answer);
		return answer;
	}

	public static void main(String[] args) {
		solution("ABAAAAAAABA");
	}
}
