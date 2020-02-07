package BOJ;

public class pal {
	static boolean chk(String s) {
		int half = s.length()/2;
		for(int i=0;i<=half;i++) {
			if(s.charAt(i) == s.charAt(s.length()-i-1)) continue;
			else return false;
		}
		return true;
	}
	public static void main(String args[]) {
		//String s = "tacocat";
		String s = "abaa";
		System.out.println(chk(s));
	}
}
