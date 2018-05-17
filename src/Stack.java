import java.util.*;
public class Stack {
	public void push(int j,ArrayList<Integer> stack) {
		stack.add(stack.size(), j);
	}
	
	public void pop(ArrayList<Integer> stack) {
		int top;
		if(stack.isEmpty()) System.out.println("-"+1);
		else{
			top = stack.get(stack.size()-1);
			stack.remove(stack.size()-1);
			System.out.println(top);
			}
	}
	
	public void empty(ArrayList<Integer> stack) {
		if(stack.isEmpty()) System.out.println(1);
		else System.out.println(0);
	}
	
	public void top(ArrayList<Integer> stack) {
		if(stack.isEmpty()) System.out.println("-"+1);
		else System.out.println(stack.get(stack.size()-1));
	}
	public void size(ArrayList<Integer> stack) {
		if(stack.isEmpty()) System.out.println(0);
		else System.out.println(stack.size());
	}
	
	public static void main(String args[]) {
		Stack ob = new Stack();
		Scanner scan = new Scanner(System.in);
		ArrayList<Integer> stack = new ArrayList<Integer>();
		int n = scan.nextInt();//명령
		for(int i=0;i<n;i++) {
			switch(scan.next()) {
				case "push":ob.push(scan.nextInt(),stack);
							break;
				case "top":ob.top(stack);
							break;
				case "size":System.out.println(stack.size());
							break;
				case "empty":ob.empty(stack);
							break;
				case "pop":ob.pop(stack);
							break;
				
			}
			
		}
		
	}
}
