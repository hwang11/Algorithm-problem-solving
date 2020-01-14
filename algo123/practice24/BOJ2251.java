package practice24;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ2251 {
	static boolean[][][] visited = new boolean[201][201][201];
	static boolean[] ans = new boolean[201];
	static int a,b,c;
	static int maxA,maxB,maxC;


	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		a = sc.nextInt();
		b = sc.nextInt();
		c = sc.nextInt();
	
		Queue<Mul> q = new LinkedList<Mul>();
		
		Mul m = new Mul(0,0,10);
		q.add(m);
		while(!q.isEmpty()) {
			int nowA,nowB,nowC;
			Mul mm = q.poll();
			nowA = mm.a;
			nowB = mm.b;
			nowC = mm.c;
			
			if(visited[nowA][nowB][nowC])
				continue;
			visited[nowA][nowB][nowC] = true;
			if(nowA == 0)
				ans[nowC] = true;
			//c->a
			if(nowC != 0 && nowA < maxA) {
				int leftA = maxA-nowA;
				
				if(nowC >leftA) {
					q.add(new Mul(maxA,maxB,nowC-leftA));
				}
				else q.add(new Mul(nowA+nowC,nowB,0));
			}
			
			//c->b
			if(nowC!=0 && nowB < maxB) {
				int leftB = maxB - nowB;//남은공간.
				
				if(nowC > leftB) {
					q.add(new Mul(nowA,maxB,nowC-leftB));
				}
				else q.add(new Mul(nowA,nowB+nowC,0));
			}
			
			//b->a
			if(nowB!=0 && nowA < maxA) {
				int leftA = maxA - nowA;//남은공간.
				
				if(nowB > leftA) {
					q.add(new Mul(maxA,nowB-leftA,nowC));
				}
				else q.add(new Mul(nowA+nowB,0,nowC));
			}
			//b->c
			if(nowB!=0 && nowC < maxC) {
				int leftC = maxC - nowC;//남은공간.
				
				if(nowB > leftC) {
					q.add(new Mul(nowA,nowB-leftC,maxC));
				}
				else q.add(new Mul(nowA,0,nowC+nowB));
			}
			//a->b
			if(nowA!=0 && nowB < maxB) {
				int leftB = maxB - nowB;//남은공간.
				
				if(nowA > leftB) {
					q.add(new Mul(nowA-leftB,maxB,nowC));
				}
				else q.add(new Mul(0,nowB+nowA,nowC));
			}
			//a->c
			if(nowA!=0 && nowC < maxC) {
				int leftC = maxC - nowC;//남은공간.
				
				if(nowA > leftC) {
					q.add(new Mul(nowA-leftC,nowB,maxC));
				}
				else q.add(new Mul(0,nowB,nowC+nowA));
			}
		}
		for(int i=0;i<=maxC;i++) {
			if(ans[i]==true) {
				System.out.println(i);
			}
		}
	}
	static class Mul{
		int a;
		int b;
		int c;
		Mul(int a,int b,int c){
			this.a = a;
			this.b = b;
			this.c = c;
		}
	}
}
