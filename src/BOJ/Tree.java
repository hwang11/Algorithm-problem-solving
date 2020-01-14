package practice22;
import java.util.*;
public class Tree {
	public Node root;
	public void addNode(String value) {
		if(root == null) {
			Node node = new Node();
			node.setValue(value);
			root = node;
		}else {
			addNode(value,root);
		}
	}
	
	public void addNode(String value,Node root) {
		if(root.getValue().compareTo(value) < 0) { //a가 b보다 앞이면 음수. 뒤면 양
			if(root.getLeft() == null) {
				Node node = new Node();
				root.left.value = value;
				root.left = node;
			}else {
				addNode(value,root.left);
			}
			
		}
		else {
			if(root.getRight() == null) {
				Node node = new Node();
				root.right.value = value;
				root.right = node;
			}
			else {
				addNode(value,root.right);
			}
		}
	}
	
	
	public class Node{
		public String value;
		public Node right;
		public Node left;
		
		public void setValue(String value){
			this.value = value;
		}
		public String  getValue() {
			return this.value;
		}
		
		public Node getLeft() {
			return this.left;
		}
		public Node getRight() {
			return this.right;
		}
	}

}
