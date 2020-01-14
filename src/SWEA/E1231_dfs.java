package Expert;

import java.util.Scanner;
//완성.X
public class E1231_dfs {
	public static void dfs(Node node) {
		if(node.left == null) return;
		System.out.print(node.s);
		dfs(node.left);
		dfs(node.root);
		dfs(node.right);
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		Node node[] = new Node[n+1];
		for(int i=1;i<n;i++) {
			int root_v =  sc.nextInt();
			String s1 = sc.next();
			node[i] = new Node(s1,root_v);
			
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			node[i].left.value = v1;
			node[i].right.value = v2;
			
		}
		
	}
	
	public static class Node{
		String s;
		int value; //번호.
		
		Node right; //이어진 노드.
		Node left;
		Node root;
		
		public Node(String s,int v) {
			this.s = s;
			this.value = v;
		}
	}
}
