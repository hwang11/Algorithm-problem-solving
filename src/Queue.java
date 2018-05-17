import java.util.*;
public class Queue {
	public void push(int j,ArrayList<Integer> queue) {
		queue.add(queue.size(), j);
	}
	
	public void pop(ArrayList<Integer> queue) {
		int top;
		if(queue.isEmpty()) System.out.println("-"+1);
		else{
			top = queue.get(0);
			queue.remove(0);
			System.out.println(top);
			}
	}
	
	public void empty(ArrayList<Integer> queue) {
		if(queue.isEmpty()) System.out.println(1);
		else System.out.println(0);
	}
	
	public void back(ArrayList<Integer> queue) {
		if(queue.isEmpty()) System.out.println("-"+1);
		else System.out.println(queue.get(queue.size()-1));
	}
	public void front(ArrayList<Integer> queue) {
		if(queue.isEmpty()) System.out.println("-"+1);
		else System.out.println(queue.get(0));
	}

	public static void main(String args[]) {
		Queue ob = new Queue();
		Scanner scan = new Scanner(System.in);
		ArrayList<Integer> queue = new ArrayList<Integer>();
		int n = scan.nextInt();//명령
		for(int i=0;i<n;i++) {
			switch(scan.next()) {
				case "push":ob.push(scan.nextInt(),queue);
							break;
				case "back":ob.back(queue);
							break;
				case "front":ob.front(queue);
							break;			
				case "size":System.out.println(queue.size());
							break;
				case "empty":ob.empty(queue);
							break;
				case "pop":ob.pop(queue);
							break;
				
			}
			
		}
		
	}
}
