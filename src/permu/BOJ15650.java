package permu;
//조합 구하기.
import java.util.ArrayList;
import java.util.Scanner;

public class BOJ15650 {
	static int n,m;
	static ArrayList a;
	public static void dfs(int d) {
		if(a.size() == m) { //d가 기준이 아니라 a.size()가 기준.
			for(int i=0;i<a.size();i++) {
				System.out.print(((int)a.get(i))+" ");
			}
			System.out.println();
		}
		for(int i=d;i<=n;i++) { //시작 위치가 0부터가 아니라 d.
			if(a.size()<m) {
				a.add(i);
				dfs(i+1);
				a.remove(a.size()-1);
			}
		}
		
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		a = new ArrayList<Integer>();
		dfs(1);
	}
}
