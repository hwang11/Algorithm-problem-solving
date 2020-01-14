package aaa;

import java.util.Scanner;
//조합문제 
//15650과 차이는 이문제는 각원소가 1~5이런식으로 증가하지만
//여기선느 원소가 입력받는것에 따라 달라진다는 정도 
//왜 로또는 여러번 돌리고, 15650은 1번만돌리는지 
public class B6603 {
	static int arr[];
	static int num;
	static boolean v[];

	static void dfs(int n, int k, String s) {
		if (n == 6) {
			System.out.println("s답:"+s);
			for(int i=0;i<num;i++) {
				if(v[i]) System.out.print(arr[i]+" ");
			}
			System.out.println();
			//return;
		}
		for (int i = k; i < num; i++) { //k+1이 아닌 k여야하는 이유는 다시 첫번째자리로 돌아가야하기때문에? 
			//System.out.println("s"+s);
			v[i] = true;
			dfs(n + 1, i+1, s + arr[i]+" ");
			v[i] = false;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			num = sc.nextInt();
			v = new boolean[num];
			if (num == 0)
				break;
			arr = new int[num];
			for (int i = 0; i < num; i++) {
				arr[i] = sc.nextInt();
			}
			//for (int i = 0; i < num; i++) { //깊이/어디서부터시작할지/결과 
				dfs(0, 0,"s"+arr[0]+ " ");
			//}
			System.out.println();
		}
	}
}
