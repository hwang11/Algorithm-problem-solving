package practice25;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Grade {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		for(int i=0;i<t;i++) {
			int n = sc.nextInt();
			int k = sc.nextInt();//특정학생.
			String g[] = {"A+","A0","A-","B+","B0","B-","C+","C0","C-","D0"};
			int v = 0;
			Stu arr[] = new Stu[n];
			int sum = 0;
			for(int j=0;j<n;j++) {
				sum = 0;
				for(int h=0;h<3;h++) {
					v = sc.nextInt();
					if(h==0) sum+=v*0.35;
					else if(h==1) sum+=v*0.45;
					else sum+=v*0.2;
				}
				arr[j] = new Stu(j,sum);
			}
			Arrays.sort(arr);
			for(int u=0;u<n;u++) {
				if(arr[u].index == (k-1)) System.out.println(g[n-u-1]);
			}
		}

	}
	//index에러남 ㅠ 두번째 테케에서.
	static class Stu implements Comparable<Stu>{
		int index;
		int sum;
		public Stu(int index,int sum) {
			this.index = index;
			this.sum = sum;
		}
		@Override
		public int compareTo(Stu o) {
			// TODO Auto-generated method stub
			if(o == null) System.out.println("g");
			else if(this.sum > o.sum) {
				return 1;
			}else if(this.sum < o.sum) {
				return -1;
			}
			return 0;
		}
	}
}
