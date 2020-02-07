package BOJ;

public class one {
	public static void main(String args[]) {
		String s = "aaabbbbc";
		char d = s.charAt(0);
		String r = "";
		r += d;
		for(int i=1;i<s.length();i++) {
			if(d != s.charAt(i)) {
				r+=s.charAt(i);
				d = s.charAt(i);
			}
		}
		System.out.println(r);
	}
}
