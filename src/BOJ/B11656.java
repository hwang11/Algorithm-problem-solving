package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class B11656 {
	public static void main(String args[])throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); //선언
		String s = bf.readLine(); //String
		String arr[] = new String[s.length()];
		for(int i=0;i<s.length();i++) arr[i] = s.substring(i, s.length());
		Arrays.sort(arr);
		for(String t : arr) System.out.println(t);
	}
}
