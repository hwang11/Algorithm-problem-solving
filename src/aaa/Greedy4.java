package aaa;

import java.util.Arrays;
/*
 * 정렬 
 * 최대 + 최소가 짝이되어야하므로 뒤에서부터 시작을 하는데 배에 같이 탈 수 있게 되는경우만 앞의 포인터를 증가시킨다. 
 * 작은 수가 같이 탈 사람이 없는 경우도 생각해줘야해서 i == j 일때 갯수증가. 짝이없으면 결국 비교 대상이 자신까지 되므로?
 * 양끝값을 비교해야하기때문에 for문을 저렇게 구현 
 * */
public class Greedy4 {
    public static int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int i = 0,j;
        //최대 + 최소가 짝이되어야한다. 짝이 됐는데 리밋초과면 혼자타야함! 
        for (j = people.length-1; j > i; j--) {
            System.out.println(i+","+j);
    		if (people[j] + people[i] <= limit) { 
    			System.out.println("dd");
    			i++; // 짝 찾았으면 2번째 최소값의 짝을 찾아야하므로! 
    		}
    		answer++; //혼자타던 둘이타던 배는 한개가 필요함! 
    	}
        //혼자남지 않앗다면 i가 j보다 커짐! 
       System.out.println("마지막 "+i+","+j);
    	if (i == j) //혼자남아서 짝이없음 
    		answer++;
        System.out.println(answer);
        return answer;
    }
	public static void main(String[] args) {
		int a[] = {70, 50, 80, 50};
		int l = 100;
		int a2[] = {70, 80, 50};
		int l2 = 100;
		int i=0;
		//solution(a,l);
		solution(a2,l2);
	}
}
