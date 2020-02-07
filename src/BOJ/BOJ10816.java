package BOJ;
import java.util.*;
public class BOJ10816 {
	static int n;
	static int m;
	static int a1[];
	static int a2[];
	static int ans[];
	public static void search(int x,int index,int ans[]) {
		int left = 0;
		int right = n - 1;
		int mid = 0;
		while(left<=right) {
			int i = 0;
			ans[index]  = 0;
			mid = (left + right) / 2;
			if(x < a1[mid]) right = mid - 1;
			else if(x > a1[mid]) left = mid + 1;
			else {
				i = mid;
				if(a1[mid-1]==x) {
					while(x==a1[i] && i>=left) {
						ans[index]++;
						if(i==left) break;
						i--;
					}
					return;
				}
				else if(a1[mid+1]==x) {
					while(x==a1[i] && i<=right) {
						ans[index]++;
						if(i==right) break;
						i++;
					}
					return;
				}
				else {
					ans[index]++;
					return;
				}
			}
		}
		return;
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		a1 = new int[n];
		
		for(int i=0;i<n;i++) {
			a1[i] = sc.nextInt();
		}
		Arrays.sort(a1);
		
		m = sc.nextInt();
		a2 = new int[m];
		int ans[] = new int[m];
		Arrays.fill(ans,0);
		
		for(int j=0;j<m;j++) {
			a2[j] = sc.nextInt();
			search(a2[j],j,ans);
		}
		for(int i=0;i<m;i++) {
			System.out.print(ans[i]+" ");
		}
		
		
		
		
	}
}
