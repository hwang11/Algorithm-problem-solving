import java.util.Scanner;

public class sdo {
	public static boolean solve(int arr[][],int n) {
		boolean flag = true;

		for(int i=(n-1)*3;i<((n-1)*3)+3;i++) {
			for(int j=0;j<3;j++) {
				flag = boxcheck(arr,n,i*3,j*3);
				if(!flag) 
				{
					return false;
				}
			}
		}
		flag = rowcheck(arr,n);
		if(!flag) {
			return false;
		}
		flag = colcheck(arr,n);
		if(!flag) {
			return false;
		}
		return true;
	}
	public static boolean rowcheck(int r[][],int n) { //하나의 행 체크 
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				int ss = r[i][j];
				for(int k=0;k<9;k++) {
					if(ss==r[i][k]) {
						if(j!=k) {
//							System.out.println("행.i:"+i+"j:"+j+"k:"+k);
//							System.out.println(ss+"와"+r[i][k]);
							return false;
						}
					} 
				}
			}
		}
		return true;
	}
	public static boolean colcheck(int c[][],int n) {
		for(int i=0;i<9;i++) {
			for(int j=9*(n-1);j<9*(n-1)+9;j++) {
				int ss = c[j][i];
				for(int k=9*(n-1);k<9*(n-1)+9;k++) {
					if(ss==c[k][i]) {
						if(j!=k) {
//							System.out.println("열.i:"+i+"j:"+j+"k:"+k);
//							System.out.println(ss+"와"+c[k][i]);
							return false;
						}
					} 
				}
			}
		}
		return true;
	}
	public static boolean boxcheck(int b[][],int n,int r,int c) {
		for(int i=r;i<r+3;i++) {
			for(int j=c;j<c+3;j++) {
				//System.out.println(i+","+j);
				int s = b[i][j];
			    for (int k = r; k < r+3; k++) {
			        for (int t = c; t < c+3; t++) {
//			        	System.out.println(k+","+t);
//			        	System.out.println("박스."+s+","+b[k][t]);
			        	if(s == b[k][t]) {
			        		if(k!=i&&t!=j) {
			        			System.out.println("false반환 ");
			        			return false;
			        		}
			        	}
			        }
			    }
			}
		}
	    return true;
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int a[][] = new int[n*9][9];
		for(int i=0;i<n*9;i++) {
			for(int j=0;j<9;j++) {
				a[i][j] = sc.nextInt();
			}
		}
		for(int i=1;i<=n;i++) {
			if(solve(a,i)) {
				System.out.println("YES");
			}
			else System.out.println("NO");
		}
	}
}
