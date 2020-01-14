package aa;

public class a1 {
	static int d[][] = {{0,1},{1,0},{0,-1},{-1,0}}; // 오, 아, 좌, 위 
	static boolean move(String s) {
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i)=='R') sb.append("0");
			else if(s.charAt(i)=='D') sb.append("1");
			else if(s.charAt(i)=='L') sb.append("2");
			else if(s.charAt(i)=='U') sb.append("3");
		}
		int x=0,y=0;
		for(int i=0;i<sb.length();i++) {
			x += d[sb.charAt(i)-48][0];
			y += d[sb.charAt(i)-48][1];
		}
		if(x == 0 && y == 0) return true;
		return false;
		
	}
	static int chk(int s,int e,String st1,String st2) {
		if(st1.length()<=e) return 0;
		int j = 0;
		for(int i=s;i<=e;i++) {
			if(st1.charAt(i)!=st2.charAt(j)) return 0;
			j++;
		}
		return 1;
	}
	public static int solution(String s) {

		int answer = 0;
		
		if(move(s)) answer++;
		System.out.println("ans"+answer);

		answer += chk(1,2,s,"RL");
		System.out.println("ans"+answer);

		answer +=chk(5,6,s,"RL");
		System.out.println("ans"+answer);

		answer +=chk(6,7,s,"LR");
		System.out.println("ans"+answer);

		answer +=chk(0,5,s,"URLLDR");
		System.out.println("ans"+answer);

		answer +=chk(0,7,s,"URLLDRLR");
		
		System.out.println("최종 ans"+answer);
		return answer;
	}

	public static void main(String[] args) {
		solution("URLLDRLR");
		solution("RLDU");
		solution("URDLDRULDLRUDLU");
	}
}
