package Algo12;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class E2383 {
	static int n,t,ans,end;
	static LinkedList<Dot> li,step,s1,s2,s1_now,s2_now;
	static int map[][];
	static int v[];
	static void arrange() {
		for(int i=0;i<li.size();i++) {
			if(v[i] == 1) {
				li.get(i).t = (dis(li.get(i),step.get(0))); //계단 까지 걸리는 시간 넣기 
				li.get(i).st = 0;
			}
			else {
				li.get(i).t = (dis(li.get(i),step.get(1)));
				li.get(i).st = 1;
			} 
		}
	}
	static void dfs(int cnt) {
		if(cnt == li.size()) {
			arrange();
			solve();
			return;
		}
		for(int i=1;i<=2;i++) { //이걸 몰랐다 
			v[cnt] = i;
			dfs(cnt+1);
			v[cnt] = 0;
		}
	}
	static int dis(Dot step,Dot per) {
		int d = Math.abs(step.x - per.x) + Math.abs(step.y - per.y) + 1;//계단입구에서 기다려야하므로 +1
		return d;
	}
	static void solve() {
		end = 0;
		t = 0;
		s1 = new LinkedList<Dot>();
		s2 = new LinkedList<Dot>();
		s1_now = new LinkedList<Dot>();
		s2_now = new LinkedList<Dot>();
		while(true) {
			for(int i=0;i<3;i++) {
				if(s1_now.isEmpty()) break;
				if(s1_now.peek().at == t) {
					end++;
					s1_now.poll();
				}
			}
			for(int i=0;i<3;i++) {
				if(s2_now.isEmpty()) break;
				if(s2_now.peek().at == t) {
					end++;
					s2_now.poll();
				}
			}
			for(int i=0;i<li.size();i++) {
				if(t == 0) break; 
				if(li.get(i).t == t) { //계단 입도착하는 시간 
					if(li.get(i).st == 0) s1.add(li.get(i));
					else s2.add(li.get(i));
				} 
			}
			 
			for(int i=0;i<3;i++) {
				if(s1_now.size() >= 3) break;
				if(s1.isEmpty()) break;
				Dot pe = s1.poll();
				pe.at = t + map[step.get(0).y][step.get(0).x];
				s1_now.add(pe);
			}
			for(int i=0;i<3;i++) {
				if(s2_now.size() >= 3) break;
				if(s2.isEmpty()) break;
				Dot pe = s2.poll();
				pe.at = t + map[step.get(1).y][step.get(1).x];
				s2_now.add(pe);
			}
			
			if(end == li.size()) { //이동을 모두 완료하면 
				ans = Math.min(ans,t);
				return;
			}
			t++;
		}
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int tc=1;tc<=t;tc++) {
			n = sc.nextInt();
			map = new int[n][n];
			li = new LinkedList<Dot>();
			step = new LinkedList<Dot>();
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					map[i][j] = sc.nextInt();
					if(map[i][j] == 1) li.add(new Dot(i,j));
					else if(map[i][j] > 1) step.add(new Dot(i,j));
				}
			}
			v = new int[li.size()];
			ans = Integer.MAX_VALUE;
			dfs(0);
			System.out.printf("#%d %d\n",tc,ans);
		}
	}
	static class Dot{
		int y;
		int x;
		int t;
		int st;
		int at;
		public Dot(int y,int x) {
			this.y = y;
			this.x = x;
		}
	}
}
