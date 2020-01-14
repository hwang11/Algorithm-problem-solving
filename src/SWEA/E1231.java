package Expert;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class E1231 {
	static int N;
	static String tree[];
	static String result;
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int t=1;t<=10;t++) {
			N = Integer.parseInt(br.readLine());
			tree = new String[N+1];
			
			for(int i=0;i<N;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				while(st.hasMoreTokens()) {
					int index = Integer.parseInt(st.nextToken());
					tree[index] = st.nextToken();
					while(st.hasMoreTokens()) {
						st.nextToken();
					}
				}
			}
			result = "";
			inorder(1);
			System.out.println("#"+t+" "+result);
			
			
		}
	}
	public static void inorder(int node) {
		if(node>N) {
			return;
		}
		inorder(2*node);
		result += tree[node];
		inorder(2*node+1);
	}
}
