package practice22;
import java.util.*;
public class BOJ1620 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		Map<Integer,String> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        for(int i=1;i<=n;i++)
        {
            String str = sc.next();
            map1.put(i, str);
            map2.put(str, i);
        }
        for(int i=1;i<=m;i++)
        {
            String s = sc.next();
            if(s.charAt(0)-'0'>=0 && s.charAt(0)-'0'<=9){
            	System.out.println(map1.get(Integer.parseInt(s)));
            }
            else{
            	System.out.println(map2.get(s));
            }
        }        
	}
}
