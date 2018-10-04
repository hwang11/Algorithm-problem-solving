package permu;
//조합 구하기.
import java.util.ArrayList;
import java.util.Scanner;

public class BOJ15650 {
	static int n,m;
	static ArrayList a;
	public static void print() {
		System.out.print("list: ");
		for(int i=0;i<a.size();i++) {
			System.out.print(a.get(i)+" ");
		}
		System.out.println();
	}
	public static void dfs(int d) {
		if(a.size() == m) { //d가 기준이 아니라 a.size()가 기준.
			System.out.println("===========");
			for(int i=0;i<m;i++) {//list a에 담겨있는 값 출력.
				System.out.print(((int)a.get(i))+" ");
			}
			System.out.println();
			System.out.println("===========");
			
		}
		for(int i=d;i<=n;i++) { //시작 위치가 0부터가 아니라 d.
			if(a.size()<m) { //m보다 크면 굳이 할필요X.
				System.out.println("dfs시작--------- d는:"+d+" i는:"+i );
				a.add(i);
				print();
				dfs(i+1);
				a.remove(a.size()-1);
				print();
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
