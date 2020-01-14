package han;

public class target {
	static int target,cnt;
	static int number[] = {1,1,1,1,1};
	static void dfs(int goal,int d) {
		if(d == number.length) {
			if(goal == target) cnt++;
			return;
		}
		dfs(goal+number[d],d+1);
		dfs(goal-number[d],d+1);
	}
	public static void main(String args[]) {
		target = 3;
		dfs(0,0);
		System.out.println(cnt);
	}
}
