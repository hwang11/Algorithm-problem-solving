import java.util.*;
public class Ma {
	static boolean v[] = new boolean[10];
	static int tmp[] = new int[10];
	public void dfs(int num,int d,int n) {
		tmp[d] = num;
		if(d==n) {
			for(int i=1;i<=n;i++) {
				System.out.print(tmp[i]+" ");
			}
			System.out.println();
		}
		
		for(int i=1;i<=n;i++) {
			if(v[i]) continue;
			v[i] = true;
			dfs(i,d+1,n);
			v[i] = false;
		}
		
	}
	
	public static void main(String args[]) {
		Ma m = new Ma();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i=1;i<=n;i++) {
			v[i] = true;
			m.dfs(i,1,n);
			v[i] = false;
		}
		
	}
}
