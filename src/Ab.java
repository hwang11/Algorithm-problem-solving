import java.util.*;
class Ab{
    public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        if(a>=1&&a<=9&&b>=1&&b<=9) {
        	System.out.println(Math.abs(a+b));
            System.out.println(Math.abs(a-b));
            System.out.println(Math.abs(a*b));
            if(a>b) System.out.println(Math.abs(a/b));
            else System.out.println(Math.abs(b/a));
            
        }

    }
}