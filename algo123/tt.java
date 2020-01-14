import java.util.Scanner;

public class tt {
	static int chk(int a,int b) {
		String s = "";
		s = Integer.toString(a);
		int cnt = 0;
		char c = Integer.toString(b).charAt(0);
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i)==(c)) {
				cnt++;
			}
		}
		return cnt;
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int cnt = 0;
		for(int i=1;i<=n;i++) {
			cnt += chk(i,m);
		}
		System.out.println(cnt);
	}
}
