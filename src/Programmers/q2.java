package Programmers;

public class q2 {
	public static int solution(String answer_sheet, String[] sheets) {
		int answer = -1;
		int max2 = 0;
		int sum = 0;
		char ans[] = answer_sheet.toCharArray();
		for(int i=0;i<sheets.length;i++) {
			char t1[] = sheets[i].toCharArray();
			for(int j=0;j<sheets.length;j++) {
				if(i==j) continue;
				char t2[] = sheets[j].toCharArray();
				int cnt = 0;
				int total = 0;
				int max1 = 0;
				boolean flag = false;
				for(int k=0;k<ans.length;k++) {
					if(t1[k] == t2[k] && t1[k] != ans[k]) { //오답 
						cnt++;
						total++;
					}
					else {
						cnt = 0; //연속 끊김 
					}
					max1 = Math.max(cnt, max1);
				}
				sum = (int) (total + Math.pow(max1, 2));
				max2 = Math.max(sum, max2);
			}
		}
		answer = max2;
		return answer;
	}

	public static void main(String[] args) {
		String ans1 = "4132315142";
		String sh1[] = { "3241523133", "4121314445", "3243523133", "4433325251", "2412313253" };// 17
		String ans2 = "53241";
		String sh2[] = { "53241", "42133", "53241", "14354" };
		String ans3 = "24551";
		String sh3[] = { "24553", "24553", "24553", "24553" };// 2*/
		System.out.println(solution(ans1,sh1));
		System.out.println(solution(ans2,sh2));
		System.out.println(solution(ans3,sh3));
	}
}
