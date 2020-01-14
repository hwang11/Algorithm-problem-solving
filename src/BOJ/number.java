package han;

public class number {
	public static void main(String args[]) {
		int num = 1000;
		int ten,cnt,k,p,p1;
		cnt = 0;k=0;p=num;p1=num;
		String d[] = {"십","백","천","만"}; //자리수 
		String arr[] = {"영","일","이","삼","사","오","육","칠","팔","구"}; //숫자 
		while(num > 0) { //자리수 구하기 
			num/=10;
			cnt++;
		}
		num = p1;
		String ans = "";
		for(int i=cnt-1;i>0;i--) { //자리수만큼 돌기 i가 즉 자리수 
			ten = (int) Math.pow(10,i);
			k = num/ten; //몫. 즉 숫자 
			if(num < ten) { //1004같은 경우 백의자리와십의자리는 생략해야하므로 
				continue;
			}
			num -= k*ten; //한자리씩 검사하도록 나머지를 갱신한다.
			if(k == 1) ans+= d[(i-1)%4]; //첫번째자리수가 1이면 일 생략 
			else ans += arr[k]+d[(i-1)%4]; //만 단위로 짤라야해서 %4연산 
		}
		if(num != 0) ans += arr[num]; //일의자리 
		System.out.println(ans);
	}
	/*
	 생각할 조건 
	 1. 맨첫자리가 1인 경우 ex) 1000
	 2. 1004처럼 중간에 자리수 생략하는 경우
	 3. 
	 */
}
