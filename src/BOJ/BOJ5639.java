package BOJ;
import java.util.*;

import practice22.Tree.Node;
public class BOJ5639 {
	public static class Node{
		int value;
		Node left;
		Node right;
	}
	
	public static void addNode(Node node,int value) {
		Node node1 = new Node();
		node1 = node;
		node1.value = value;
		if(node1.value >= value) {
			if(node1.left == null) {
				Node u = new Node();
				node1.left = u;
				u.value = value;
			}
			else addNode(node1.left, value);		
		}
		else {
			if(node1.right == null) {
				Node u = new Node();
				node1.right = u;
				u.value = value;
			}
			else addNode(node1.left, value);
		}
	}
	
	public static void postorder(Node root) {
		if(root == null) return;
		postorder(root.left);
		postorder(root.right);
		System.out.println(root.value);
	}
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int i = 0;
		Node root = new Node();
		root.value = sc.nextInt();
		//System.out.println("r.value"+root.value);
		while(sc.hasNextLine()) {
			try { int v = sc.nextInt();
			addNode(root, v);} 
			catch (Exception e) { 
				System.out.println("숫자만을 입력해야 합니다. 종료합니다."); 
				break; 
			} 
		}
		postorder(root);
	}
	


}

