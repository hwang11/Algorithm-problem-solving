package aaa;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
/*
 * 이 문제 어려웠떤 거는 맨 처음 100이상을 달성한 기능을 기준으로 앞에를 살펴보려했는데 
 * 그게 아니라 맨처음 기능을 기준으로 그게 100이상을 달성하는 동안 완성된 기능들의 개수를 세서 저장해야한다. 
 * */
public class Stack3 {
	public static int[] solution(int[] pro, int[] speeds) {   
		Queue<Integer> q = new LinkedList<Integer>();
		for(int i=0;i<pro.length;i++) {
			if((100-pro[i])%speeds[i] == 0) {
				q.add((100-pro[i])/speeds[i]);
			}else {
				q.add((100-pro[i])/speeds[i]+1);
			}
		}
		LinkedList<Integer> li = new LinkedList<Integer>();
		int st = q.poll();
		int cnt = 1;
		int num;
		while(!q.isEmpty()) {
			num = q.poll();
			if(st >= num) {
				cnt++;
			}else { //그러다가 100못넘는게 나오면 이제 그걸 st로 잡고 그게100 넘을때까지 몇개의 기능이 완료되는지 봐야한다 
				li.add(cnt);
				cnt = 1;
				st = num;
			}
		}
		li.add(cnt);
		
		int answer[] = new int[li.size()];
		for(int i=0;i<li.size();i++) {
			answer[i] = li.get(i);
			System.out.println(answer[i]);
		}
		return answer;
    }
	public static void main(String[] args) {
//		[93, 30, 55, 60, 40, 65], [1, 30, 5, 10, 60, 7]
//				기댓값 〉	[2, 4]
//				실행 결과 〉	배열의 인덱스 0의 값이 다릅니다. 실행한 결괏값: 5, 기댓값: 2
		
//				테스트 3
//				입력값 〉	[40, 93, 30, 55, 60, 65], [60, 1, 30, 5, 10, 7]
//				기댓값 〉	[1, 2, 3]
		int p1[] = {93, 30, 55, 60, 40, 65};
		int s1[] = {1, 30, 5, 10, 60, 7};
		int p2[] = {40, 93, 30, 55, 60, 65};
		int s2[] = {60, 1, 30, 5, 10, 7};
		int p[] = {93,30,55};
		int s[] = {1,30,5};
		
		solution(p1,s1);
		//solution(p,s);
				
	}
}
