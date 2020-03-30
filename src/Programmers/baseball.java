package Programmers;

public class baseball {
	//조건에 맞는 숫자를 바로 찾는게 아니라, 전체 범위 중에서 조건에 맞지 않는 숫자를 걸러내는 게 중요 
	public static int solution(int[][] baseball) {
		int answer = 0;
		for(int i=123;i<=987;i++) {
			String s = Integer.toString(i);
			char num[] = s.toCharArray();
			if(num[0]==num[1] || num[1] == num[2] || num[0] == num[2]) continue;
			if(num[0] == '0' || num[1] == '0' || num[2] =='0') continue;
			boolean flag = true;
			for(int j=0;j<baseball.length;j++) {
				String b = Integer.toString(baseball[j][0]);
				char bnum[] = b.toCharArray();
				int st = 0;
				int ball = 0;
				for(int k=0;k<3;k++) { //숫자, 스트라이크, 볼 
					for(int p=0;p<3;p++) {
						if(num[k] == bnum[p] && k!=p) ball++;
						if(num[k] == bnum[p] && k==p) st++;
					}
				}
				if(baseball[j][1] != st || baseball[j][2] != ball) { //한개의 조건이라도 맞지 않으면 더 볼 필요X 
					flag = false;
					break;
				}
			}
			if(flag) answer++;
		}
		return answer;
	}

	public static void main(String[] args) {
		//{{123, 1, 1}, {356, 1, 0}, {327, 2, 0}, {489, 0, 1}};
		int a[][] = {{123, 1, 1}, {356, 1, 0}, {327, 2, 0}, {489, 0, 1}};
		System.out.println(solution(a));
	}
}
