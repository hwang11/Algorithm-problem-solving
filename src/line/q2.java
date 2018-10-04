package line;
import java.util.Scanner;
import java.util.StringTokenizer;
public class q2 {
		public static int calc(){
			 String input = new Scanner(System.in).nextLine().trim();
		     final StringTokenizer tokenizer = new StringTokenizer(input);
			int sum = 0;//거리합.
	        int ans = 20000;//돈.
	        int ans2 = 20000;
	        while (tokenizer.hasMoreTokens()) {
	            int distance = Integer.parseInt(tokenizer.nextToken());
	            if(distance>40) {
	            	distance-=40;
	            	int r = 0;
	            	if(distance%8 ==0) r = distance/8;
	            	else {
	            		r = distance/8;
	            		r+=1;
	            	}
	            	ans2-=((r*80)+720);
	            	if(ans2 < 720) {
	            		return ans;
	            	}
	            	else ans-=((r*80)+720);
	            }
	            else {
	            	ans2-=720;
	            	if(ans2<720) {
	            		return ans;
	            	}
	            	else ans-=720;
	            }
	        }

	        return ans;
		}
	 public static void main(String... args) {
	       System.out.println(calc());
	    }
}
