package BOJ;

import java.util.Scanner;

public class B7568 {
	static int n;
	static People a[];
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		a = new People[n];
		for(int i=0;i<n;i++) {
			int w = sc.nextInt();
			int h = sc.nextInt();
			a[i] = new People(w,h,1);
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(i==j) continue;
				if(a[i].w < a[j].w) {
					if(a[i].h < a[j].h) {
						a[i].l++;
					}
				} 
			}
		}
		for(int i=0;i<n;i++) {
			System.out.println(a[i].l);
		}
	}
	public static class People{
		int w;
		int h;
		int l;
		public People(int w,int h,int l) {
			this.w = w;
			this.h = h;
			this.l = l;
		}
	}
}
