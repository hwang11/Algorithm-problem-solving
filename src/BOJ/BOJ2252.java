package BOJ;
import java.util.*;
public class BOJ2252 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		ArrayList List = new ArrayList<Integer>();
		for(int i=0;i<M*2;i++) {
			List.add(sc.nextInt());
		}
		for(int i=List.size()-1;i>2;i--) {
			for(int j=0;j<List.size()-1;j++) {
				int tmp = (int) List.get(i-1);
				if(List.get(i) == List.get(j)) {
					List.add(j, tmp);
					System.out.println((int)i);
				}
				else continue;
			}
			List.remove(i);
		}
		for(int i=0;i<List.size();i++) {
			System.out.println(i+"번째:"+List.get(i));
		}
		
		
		
			
	}
}
