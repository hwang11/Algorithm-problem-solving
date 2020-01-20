package BOJ;
//package Algo7;
//
//import java.util.Scanner;
//
//public class B1022 {
//	public static void main(String args[]) {
//		Scanner sc = new Scanner(System.in);
//		int r1, c1, r2, c2;
//		r1 = sc.nextInt()+25;
//		c1 = sc.nextInt()+25;
//		r2 = sc.nextInt()+25;
//		c2 = sc.nextInt()+25;
//		int map[][] = new int[50][50];
//		int sw,p,i,j,k;
//		sw = 1;
//		j = i = 3;
//		k = 2;
//		p = 1;
//		map[3][3] = 1;
//		while(true) {
//			for(int l=0;l<p;l++) {
//				j = j+sw;
//				if(j<0 || i<0 || j>=50 || i>=50) break;
//				map[i][j] = k++;
//			}
//			sw *= -1;
//			for(int m=0;m<p;m++) {
//				i = i+sw;
//				if(j<0 || i<0 || j>=50 || i>=50) break;
//				map[i][j] = k++;
//			}
//			p++;
//			if(p > 50) break;
//		}
//		for(int o=r1;o<=r2;o++) {
//			for(int y=c1;y<=c2;y++) {
//				System.out.print(map[o][y]+" ");
//			}
//			System.out.println();
//		}
//
//		
//	}
//}
