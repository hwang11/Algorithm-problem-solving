package BOJ;

public class rrenum {
	public static void main(String args[]) {
		String scaleStr[] = { "", "십", "백", "천" }; // 단위
		String unitStr[] = { "", "만", "억", "조" };
		String numStr[] = { "", "일", "이", "삼", "사", "오", "육", "칠", "팔", "구" };
		int n = 100010000;
		String s = Integer.toString(n);
		int len = s.length();
		char back[] = new char[21];
		for (int i = 0; i < len; i++) {
			back[i] = s.charAt(len - i - 1);
		}

		for (int i = len - 1; i >= 0; i--) {
			if (back[i] == '0') {

				if (i % 4 == 0) {
					if (back[i + 1] == '0' && back[i + 2] == '0' && back[i + 3] == '0') {

					} else {
						System.out.println(unitStr[i / 4]);
					}
				}
			} else {
				System.out.println(numStr[back[i] - '0']);
				System.out.println(scaleStr[i % 4]);
				if (i % 4 == 0) {
					System.out.println(unitStr[i / 4]);
				}

			}
		}
	}
}
