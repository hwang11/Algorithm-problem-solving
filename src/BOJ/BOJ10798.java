import java.util.*;
public class BOJ10798 {
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		char ch2[][]=new char[5][16];
		for(int i=0;i<5;i++) {
			//ch2[i] = s.next();
		}
		
		
		String nu=" ";
		for(int i=0;i<5;i++) {
			for(int j=0;j<str[0].length();j++) {
				while(j==str[i].length()) {
					str[i]=str[i]+nu;
				}
				ch2[i][j]=str[i].charAt(j);		
			}
		}
		for(int j=0;j<str[0].length();j++) {
			for(int i=0;i<5;i++) {
				if(ch2[i][j]!=' ')
				System.out.print(ch2[i][j]);
			}
		}
		
		
		
		
	}
}
