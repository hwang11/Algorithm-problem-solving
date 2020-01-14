package aa;

public class n1 {
	public static int solution(String s) {
		int answer = 0;
		int k=0;
		for(int i=0;i<s.length();i++) {
			int a = 0;int b=0;
			for(int j=i;j<s.length();j++) {
				if(s.charAt(j)=='R') a++;
				else if(s.charAt(j)=='D') b++;
				else if(s.charAt(j)=='L') a--;
				else if(s.charAt(j)=='U') b--;
				if(a==0 && b == 0) answer++;
			}
		}
		System.out.println(answer);
		return answer;
	}
	public static void main(String[] args) {
		solution("URLLDRLR");
		solution("RLDU");
		solution("URDLDRULDLRUDLU");
	}
}
