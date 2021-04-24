//package ict;
//
//import java.util.ArrayList;
//import java.util.LinkedList;
//import java.util.List;
//import java.util.Queue;
//
//public class q5 {
//	static int N;
//	static int arr[][];
//	static boolean v[][];
//
//	
//	public static int connectedSum(int n,List<String> edges) {
//		li = new LinkedList<Integer>();
//		arr = new int[n+1][n+1];
//		v = new boolean[n+1][n+1];
//        N = n;
//        for(String word : edges) {
//            String[] s = word.split(" ");
//            arr[Integer.parseInt(s[0])][Integer.parseInt(s[1])] = 1;
//        }
//        
//        int sum = 0;
//        for(int i=0;i<li.size();i++) {
//        	System.out.println("-- "+li.get(i));
//            double target = Math.sqrt(li.get(i));
//            sum += Math.ceil(target);
//        }
//        return sum;
//	}
//	public static void main(String[] args) {
//		List<String> a = new ArrayList<String>();
//		a.add("1 2");
//		a.add("1 3");
//		a.add("2 4");
//		a.add("3 5");
//		a.add("7 8");
//		System.out.println(connectedSum(10, a));
//
//	}
//}
