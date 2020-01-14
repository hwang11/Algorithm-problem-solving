package Expert;
//4중포문으로 모든경우를 다 확인할것.
import java.util.ArrayList;
import java.util.Scanner;

public class E2115 {
	
	static int n,m,c;
	static int map[][];
	static boolean v[][];
	
	public static void calc() {
		int sum=0;
		int max=0;
		int k;
		int pow = 0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(v[i][j]) continue;
				sum = 0;
				pow = 0;
				k = m;
				
				while(sum < c && k>0) {
					--k;
					sum += map[i][j]; //c의 범위체크.
					System.out.println("i,j"+i+","+j);
				}
				System.out.println("k:"+k);
				for(int u=j;u<(j+(m-k));u++) {
					System.out.println("i,u"+i+","+u);
					System.out.println();
					pow+= Math.pow(map[i][u], 2); //값을 비교.
				}
				if(max < pow) { 
					max = pow;
					//init();
					for(int u=j;u<(j+(m-k));u++) {
						v[i][u] = true;
					}
				}
			}
		}
	}
	public static void init() {
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				v[i][j] = false;
			}
		}
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		//int test = sc.nextInt();
		
		//for(int t=1;t<=10;t++) {
			n = sc.nextInt();
			m = sc.nextInt();
			c = sc.nextInt();
			v = new boolean[n][n];
			map = new int[n][n];
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			calc();
			calc();
			
			int ans = 0;
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					if(v[i][j]) {
						System.out.println("i,j"+i+","+j);
						ans += Math.pow(map[i][j], 2);
					}
				}
			}
			System.out.println(ans);
			//System.out.println("#"+t+" "+ans);
			
			
		}
	//}

}
