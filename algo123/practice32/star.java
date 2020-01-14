package practice32;

public class star {
	public static void main(String args[]) {
		int n = 5;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n-1-i;j++) {
				System.out.print(" ");
			}
			for(int j=0;j<2*i+1;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
