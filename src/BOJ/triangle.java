package han;

public class triangle {
	public static void main(String args[]) {
		int t[] = { 100, 80, 0};
		int cnt = 0;
		int sum = 0;
		int cnt2 = 0;
		for (int i = 0; i < t.length; i++) {
			sum += t[i];
			if(t[i] > 0) cnt2++;
		}
			
		if (sum != 180 || cnt2 != 3)
			System.out.println("삼각형이 아님");
		else {
			for (int i = 0; i < t.length; i++) {
				if (t[i] == 90) {
					System.out.println("직각삼각형");
					break;
				}
				if (t[i] > 90) {
					System.out.println("둔각삼각형 ");
					break;
				}
				if (t[i] < 90)
					cnt++;
			}
			if (cnt == t.length)
				System.out.println("예각삼각형");
		}
	}
}
