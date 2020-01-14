import java.util.Scanner;

public class aaa1 {
    static int a, b;
    
 
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner scan = new Scanner(System.in);
        a = scan.nextInt();
        b = scan.nextInt();
//        if (b > a) {
//            int temp = b;
//            b = a;
//            a = temp;
//        }
//        int result = gcd(a, b);
//        System.out.println(result); //공약수 
//        System.out.println(a * b / result); //공배수 
        System.out.println(gcd(a,b));
        System.out.println(lcm(a,b));
    }
 
//    public static int gcd(int a, int b) {
//        if (a % b == 0)
//            return b;
//        return gcd(b, a % b);
//    }
    public static int gcd(int a, int b){
    	while(b!=0){
    		int r = a%b;
    		a= b;
    		b= r;
    	}
    	return a;
    }

    public static int lcm(int a, int b){
        return a * b / gcd(a,b); // a*b / 최대공약수 => 최소공배수 
    }
}


