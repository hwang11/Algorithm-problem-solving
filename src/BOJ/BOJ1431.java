package BOJ;
import java.util.*;
import java.util.Comparator;

public class BOJ1431 {
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String[] s = new String[n+1];
		for(int i=0;i<=n;i++) {
			s[i]=sc.nextLine();
		}
		
		Arrays.sort(s, new Comparator<String>() {
			@Override
			public int compare(String o1,String o2) {
				if(o1.length() < o2.length()) return -1;
				else if(o1.length() > o2.length()) return 1;
				else {
					int sum = 0;
					for(int i=0;i<o1.length();i++) {
						if((int)o1.charAt(i) > 47 && (int)o1.charAt(i) < 58)  sum += (int)(o1.charAt(i));
					}
					
					int sum2 = 0;
					for(int i=0;i<o2.length();i++) {
						if((int)o2.charAt(i) > 47 && (int)o2.charAt(i) < 58)  sum2 += (int)(o2.charAt(i));
					}
					
					if ( sum > sum2 ){
                        return 1;
                    }
                    else if ( sum < sum2){ 
                        return -1;
                    }
                    else {
                        return o1.compareTo(o2);
                    }
				}
			}
		});

			
		
		
	}
}
