package ict;

import java.util.Arrays;
import java.util.List;

public class q1 {
	public static int countStudents(List<Integer> height) {
		int cnt = 0;
		int a[] = new int[height.size()];
		for(int i=0;i<height.size();i++) {
			a[i] = height.get(i);
		}
		Arrays.sort(a);
		for(int i=0;i<height.size();i++) {
			if(a[i] != height.get(i)) cnt++;
		}
		return cnt;
	}

	public static void main(String[] args) {
		List<Integer> values2 = Arrays.asList(1, 1, 3, 3, 4, 1);
		List<Integer> values3 = Arrays.asList(1, 1, 3, 4, 1);
		List<Integer> values4 = Arrays.asList(1, 1, 3, 4);
		List<Integer> values5 = Arrays.asList(4, 3, 2, 1);
		System.out.println(countStudents(values2));
		System.out.println(countStudents(values3));
		System.out.println(countStudents(values4));
		System.out.println(countStudents(values5));
	}
}
