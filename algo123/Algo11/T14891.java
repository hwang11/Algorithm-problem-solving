package Algo11;

import java.util.LinkedList;
import java.util.Scanner;

public class T14891 {
	static LinkedList<Integer>[] list = (LinkedList<Integer>[]) new LinkedList[5];
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
        for (int i = 1; i <= 4; i++) {
        list[i] = new LinkedList<Integer>();
        String input = sc.next();
        for (String s : input.split("")) {
            int n = Integer.parseInt(s);
            list[i].add(n);
            }
        }
 
    int k = sc.nextInt();
    while (k-- > 0) {
        int n = sc.nextInt();
        int d = sc.nextInt();
 
        left(n - 1, -d);
        right(n + 1, -d);
        rotate(n, d);
    }
 
    int ans = 0;
    for (int i = 0; i < 4; i++) {
        if (list[i + 1].get(0) == 1) {
            ans += (int) Math.pow(2, i);
        }
    }
    System.out.println(ans);
    }
	public static boolean check(int a, int b) {
    if (a > b) {
        // left
        if (list[a].get(6) == list[b].get(2)) {
            return false;
        } else {
            return true;
        }
    } else {
        if (list[a].get(2) == list[b].get(6)) {
            return false;
        } else {
            return true;
        }
    }
}
 
public static void rotate(int n, int direction) {
	System.out.printf("rotate %d\n",n);
    if (direction == 1) {
        list[n].addFirst(list[n].pollLast());
    } else {
        list[n].addLast(list[n].pollFirst());
    }
}
 
public static void left(int n, int direction) {
    if (!(1 <= n && n <= 4))
        return;
 
    if (check(n, n + 1)) {
        left(n - 1, -direction);
        rotate(n, direction);
    }
}
 
public static void right(int n, int direction) {
    if (!(1 <= n && n <= 4))
        return;
 
    if (check(n, n - 1)) {
        right(n + 1, -direction);
        rotate(n, direction);
    }
	
}
}
 



