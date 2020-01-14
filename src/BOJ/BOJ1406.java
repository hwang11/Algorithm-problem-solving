import java.util.*;
public class BOJ1406 {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		String a = scan.next();
		int n = scan.nextInt();
		String s[] = new String[n*2];
		int j=0;
		while(scan.hasNext()) {
			s[j]= scan.next();
			j++;
		}
		for(int i=0;i<n;i++) {
				System.out.println("s["+i+"]:"+s[i]);
		}
		StringBuffer sb = new StringBuffer(a);
		int cur = n-1;
		/*for(int i=0;i<n;i++) {
				 /*switch (s[i][0]) {
		            case "L":
		            		if(cur!=0) cur--;
		                    
		            case "D":
		            		if(cur!=(n-1)) cur++;
		                     
		            case "B":
		            		if(cur!=0) sb.delete(cur, 1);
		                     
		            case "P":
		            		sb.insert(cur,s[i][1]);
                    		 
                    		 
				 }
			if(s[i][0]=="L") { if(cur!=0) cur--; System.out.println("L");}
			else if(s[i][0]=="D") if(cur!=(n-1)) cur++;
			else if(s[i][0]=="B") if(cur!=0) sb.delete(cur, 1);
			else if(s[i][0]=="P") sb.insert(cur,s[i][1]);	
				
		}
		//System.out.println(a);
		
		*/
	}
}
