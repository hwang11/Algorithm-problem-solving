package BOJ;

import java.io.*;
import java.util.Scanner;

public class BOJ1748 {
	public static void main (String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		int ans = 0;
		int base = 10, cnt=1;

		for (int i=1; i<=n; i++){
		    if (i==base){ 
		       base*=10;
		       cnt++;
		    }
		    ans+=cnt;
		}

		System.out.println(ans);
	}
}
