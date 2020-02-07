package BOJ;

public class binary {
	public static void main(String args[]) {
		int n = 10;
		int aa = n;
		String s1 = "";
		while(aa>0) {
			s1 +=aa%2;
			aa/=2;
		}//이렇게 해서 거꾸로 출력 
		for(int i=s1.length()-1;i>=0;i--) System.out.print(s1.charAt(i));
		//System.out.println(s1);
//		String s = Integer.toBinaryString(n);
//		int cnt = 0;
//		for(int i=0;i<s.length();i++) if(s.charAt(i)=='1') cnt++; 
//		System.out.println(cnt);
	}
}
