package practice32;
import java.util.ArrayList;
//치킨배달. 백트래킹 + 브루트포스.
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ15686 {
	static int n,m;
	static int sum = 0;
	static int result;
	static int map[][];
	static boolean v[];
	static int output[];
	
	static ArrayList<Dot> home;
	static ArrayList<Dot> chicken;
	
	public static int calc(Dot d1,Dot d2) {
		return Math.abs(d1.x-d2.x)+Math.abs(d1.y-d2.y);
	}
	public static void select(int start,int depth) {
		output[depth] = start + 1;
		for(int i = start;i<chicken.size();i++) {
			if(v[i]) continue;
			v[i] = true;
			select(i,depth+1);
			v[i] = false;
		}
		
		if(depth == m-1) {
			int sum = 0;
			int current = 0;
			for(int i=0;i<home.size();i++) {
				int min = Integer.MAX_VALUE;
				for(int j=0;j<m;j++) {
					current = calc(home.get(i),chicken.get(output[j]-1));
					min = Math.min(current, min);
				}
				sum += min;
			}
			result = Math.min(result, sum);
		}
		
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		map = new int[n][n];
		
		home = new ArrayList<Dot>();
		chicken = new ArrayList<Dot>();
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j] == 1) home.add(new Dot(i,j));
				else if(map[i][j] == 2) chicken.add(new Dot(i,j));
			}
		}
		result = Integer.MAX_VALUE;
		v = new boolean[chicken.size()];
		output = new int[chicken.size()];
		
		for (int i = 0; i < chicken.size(); i++) {
            v[i] = true;
            select(i, 0);
            v[i] = false;
        }
		System.out.println(result);
	
	}
	public static class Dot{
		int x;
		int y;
		public Dot(int x,int y) {
			this.x = x;
			this.y = y;
		}
	}
}
