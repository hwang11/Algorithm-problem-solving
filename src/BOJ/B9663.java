package BOJ;

import java.util.Scanner;

public class B9663 {
	static int ans, n;
	static int[] col;

	public static void dfs(int row) {
	    if (row == n) {
	    	for(int i=0;i<=n;i++) {
	    		System.out.printf("col[%d]:%d\n",i,col[i]);
	    	}
	        ++ans;
	    } else {
	        for (int i = 1; i <= n; i++) {
	            col[row + 1] = i;// i행 row+1 열 
	            if (isPossible(row + 1)) {
	                dfs(row + 1);
	            } else {
	                col[row + 1] = 0;    
	            }
	        }
	    }
	    col[row] = 0;
	}
	 
	public static boolean isPossible(int c) {
	    // col[1]의 의미는 *행 1열 이다.
	    // col[1] = 2 => 2행 1열, col[2] = 3 => 3행 2열
	 
	    // 이전 열들을 탐색하면서 배치 가능 여부 확인
	    for (int i = 1; i < c; i++) {
	        // 같은 행, 열
	        if (col[i] == col[c]) {
	            return false;
	        }
	        // 대각선
	        if (Math.abs(col[i] - col[c]) == Math.abs(i - c)) {
	            return false;
	        }
	    }
	    return true;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	    n = sc.nextInt();
		 
	    for (int i = 1; i <= n; i++) {
	        col = new int[15];
	        col[1] = i; //행이 바뀌면서 경우의 수 찾기 
	        // 정점은 행을 기준. (i = 1) => 1행(1열), (i = 2) => 2행(1열), (i = 3) => 3행(1열) 
	        System.out.println(i+"행 1열 ================= ");
	        dfs(1); //첫번째 퀸부터 시작한다는 뜻 
	    }
	    System.out.println(ans);
	}
}
