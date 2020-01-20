package BOJ;

public class sosu {
	static boolean v[];
	static String s;
	public static void dfs(int n,int tar,String num) {
		if(n == tar) {
			System.out.println(n+","+tar);
			s = "";
			for(int i=1;i<v.length;i++) {
				if(v[i]) s+= num.substring(i-1, i); 
			}
			return;
		}
		v[n] = true;
		dfs(n+1,tar,num);
		v[n] = false;
	}
	public static int solution(String numbers) {
        int answer = 0;
        for(int i=1;i<=numbers.length();i++) {
            v = new boolean[numbers.length()];
            for(int j=0;j<numbers.length();i++) {
            	dfs(j,i,numbers);
            }
        	System.out.println(s);
        }
       // Integer.parseInt(s);
        return answer;
    }
	public static void main(String args[]) {
		solution("17");
	}
}
