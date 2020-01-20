package BOJ;

import java.util.Scanner;

public class renumber {
	public static void main(String args[]) {
		int n = 100010000;
		String dan[] = {"","십","백","천"}; //단위 
		String man[] = {"만","억","조"};
		String number[] = {"","일","이","삼","사","오","육","칠","팔","구"};
		String s = Integer.toString(n);
		int cnt = s.length();
		String ans ="";
		boolean flag = false;
		int idx = 0;
		for(int i=0;i<cnt;i++) {
			flag = false;
			idx = cnt-i-1;
			int h = (cnt-1)/4;//억, 만 경구분 
			if(idx>=4) {
				if(idx%4==0 && idx/4 == h) {
					flag = true;
					idx = (idx/4)-1;
				}
				else idx = idx%4;
			}
			int k = s.charAt(i)-48; //k는 숫자를 나타내기 위한 인덱스 
			if(!flag && k == 0 && idx%4 != 0) continue;
			if(i<cnt-1 && k == 1) ans += ""; //k==1인 경우 단위만 표기하면 되므로.
			else ans += number[k]; //숫자표기 
			if(flag) {
				ans+= man[idx];
			}
			else ans += dan[idx];//단위 표기 
		}
		System.out.println(ans);
//		for(int i=cnt-1;i>=0;i--) {
//		idx = i;
//		if(i>=4) {
//			if(i%4==0) idx = (i/4)-1;
//			else idx = i%4;
//		}
//		int k = (int) (n/(Math.pow(10, i))); //k는 숫자를 나타내기 위한 인덱스 
//		if(n < (Math.pow(10, i)) && idx%4 != 0) continue;
//		n %= (Math.pow(10, i)); //나머지로 숫자 갱신 
//		if(k == 1) ans += ""; //k==1인 경우 단위만 표기하면 되므로.
//		else ans += number[k]; //숫자표기 
//		if(i>=4 && i%4==0) {
//			ans+= man[idx];
//		}
//		else ans += dan[idx];//단위 표기 
//	}
	}
}
