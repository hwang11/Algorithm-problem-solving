package practice24;
import java.util.*;
public class BOJ3038 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		for(int i=0;i<test;i++) {
			int x = 1;
			int n = sc.nextInt();
			HashMap<String,Integer> map = new HashMap();
			String aa = sc.nextLine();
			for(int j=0;j<n;j++) {
				String s = sc.nextLine();
				String[] words = s.split("\\s");
				String name = words[0];
				String kind = words[1];
				if(map.containsKey(kind)) {
					map.put(kind, map.get(kind)+1);
				}
				else {
					map.put(kind, 1);
				}
			}
			for(int j:map.values()) {
				x*=(j+1);
			}
			System.out.println((x-1));
		}
		
	}
}
