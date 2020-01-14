package han;

public class phone {
	static boolean chk(String a,String b) { // solution함수의 2중 포문안에서 또 돌면 복잡하므로 함수로 뺏음.
		if(a.length()<b.length()) {
			for(int i=0;i<a.length();i++) {
				if(a.charAt(i)!=b.charAt(i)) {
					return true;
				}
			}
			return false;
		}else {
			for(int i=0;i<b.length();i++) {
				if(a.charAt(i)!=b.charAt(i)) {
					return true;
				}
			}
			return false;
		}
	}
    public static boolean solution(String[] phone_book) {
        boolean answer = true;
        for(int i=0;i<phone_book.length;i++) {
        	for(int j=0;j<phone_book.length;j++) {
        		if(i==j) continue;
        		if(!chk(phone_book[i],phone_book[j])) return false; //false가 나오면 더 비교할 필요가 X 
        	}
        }
        return true;
    }
	public static void main(String args[]) {
		//[119, 97674223, 1195524421]
		//["12232332", "12", "222222"]
		String a[] = {"12232332", "12", "222222"};
		System.out.println(solution(a));
	}
}
