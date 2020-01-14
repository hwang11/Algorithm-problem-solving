package el;

import java.util.LinkedList;

import java.util.Scanner;

public class q {

	public static void main(String[] args) {

		

		for (int i = 2; i <10; i++) {

			System.out.println(change(14, i));

		}

	}

	public static String change(int num, int su) {

		LinkedList stack = new LinkedList();// 스택으로 사용

		String result = "";

		while (num > 0) {

			if (num % su > 9) {// 나머지가 10 이상일때(즉 11진수 이상일때) 문자열 배당

				stack.add((char) (num % su + 55));

			} else {// 그외는 나머지 숫자값 넣기

				stack.add(num % su);

			}

			num = num / su;

		}

		// 스택에서 값 추출

		while (!stack.isEmpty()) {

			result += stack.pollLast();

		}

		if (result.equals(""))
			result = "0";// 입력수가 0일때는 결과값 0 배당

		result = +num + "의 " + su + "진수의  값은--->  " + result;

		return result;

	}

}