package Algo7;

import java.util.Scanner;

public class test {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		String a = sc.next();
		char arr[] = new char[a.length()];
		for(int i=0;i<a.length();i++) {
			arr[i] = a.charAt(i);
			//if(arr[i]=='R') System.out.println("ㅇㅇㅇ");
			if(arr[i]=='0') System.out.println("Dd");
		}
	}
}
