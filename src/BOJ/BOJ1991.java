package practice22;
import java.util.*;
public class BOJ1991 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine(); // 엔터제거
		int a[][] = new int[26][2];
		for(int i=0;i<n;i++) {
			String l = sc.nextLine();
			int x = l.charAt(0) - 'A'; //부모 알파벳 인덱
			char y = l.charAt(2);
			char z  = l.charAt(4);
			if(y == '.') {
				a[x][0] = -1;//자식이 없는경우 -1
			}
			else {
				a[x][0] = y-'A';
			}
			
			if(z == '.') {
				a[x][1] = -1;
			}
			else {
				a[x][1] = z -'A';
			}
		}
	 	preorder(a,0); //2번째 인자는 시작할 루트
        System.out.println();
        inorder(a,0);
        System.out.println();
        postorder(a,0);
        System.out.println();
	}		
		private static void preorder(int a[][], int x) {
			if(x == -1) return;
			System.out.print((char)(x+'A'));
			preorder(a, a[x][0]);
			preorder(a, a[x][1]);
		}
		private static void inorder(int a[][], int x) {
			if(x == -1) return;
			inorder(a, a[x][0]);
			System.out.print((char)(x+'A'));
			inorder(a, a[x][1]);
		}
		private static void postorder(int a[][], int x) {
			if(x == -1) return;
			postorder(a, a[x][0]);
			postorder(a, a[x][1]);
			System.out.print((char)(x+'A'));
		}
		
		
		

}
