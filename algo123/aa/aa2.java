package aa;

public class aa2 {
	static int cnt;
	static int chk(String s,int st,int e) {
		//System.out.println(st+","+e);
		if(s.length()<e) return 0;
		int a=0;int b=0;	
		cnt++;
		for(int i=st;i<e;i++) {
			if(s.charAt(i)=='R') a++;
			else if(s.charAt(i)=='D') b++;
			else if(s.charAt(i)=='L') a--;
			else if(s.charAt(i)=='U') b--;
			if(Math.abs(a)>s.length()/2 || Math.abs(b)>s.length()/2) return 0;
		}
		if(a==0 && b == 0) { //다합해서 0일때만 원점으로 돌아온것이기때문에 
			return 1;
		}
		return 0;
	}
	public static int solution(String s) {
		int answer = 0;
		int k=0;
		cnt = 0;
		while(true) {
			k+=2; //짝수단위로 해야 0이되는 조건이 나오기때문에 
			if(k>s.length()) break;
			for(int i=0;i<s.length();i++) { //시작점 + k 만큼 확인하기 
				if(i+k<=s.length()) 
				answer += chk(s,i,i+k);
			}
		}
		System.out.println("cnt"+cnt);
		System.out.println(answer);
		return answer;
	}
	public static void main(String[] args) {
		solution("URLLDRLR");
		solution("RLDU");
		solution("URDLDRULDLRUDLU");
	}
}
