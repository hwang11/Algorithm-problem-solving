package Algo2;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;


public class B1966 {
	public static void main(String args[]) throws Exception{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(reader.readLine());
		LinkedList<Integer> q = new LinkedList<>();
		
		for(int n=0;n<T;n++) {
			String[]input = reader.readLine().split(" ");
			String[]priority = reader.readLine().split(" ");
			
			int N = Integer.parseInt(input[0]);
			int M = Integer.parseInt(input[1]);
			int count = 0;
			q.clear();
			
			for(int i=0;i<N;i++) q.add(Integer.parseInt(priority[i]));
			while(!q.isEmpty()) {
				boolean isPriority = true;
				for(int i=1;i<q.size();i++) {
					if(q.peek()<q.get(i)) {
						isPriority = false;
						break;
					}
				}
				if(isPriority) { //첫번째원소가 우선순위가 가장 높은 경우.
					count++;
					q.poll();//ㅂ첫번째원소제거.
					
					if(M == 0) break; //M번째 있던 원소면 끝내고.
					else M-=1;//아니면 M감소.
				}
				else { //없앴다가 뒤에 다시추가.
					int tmp = q.poll();
					q.add(tmp);
					M = (M==0) ? q.size()-1 : --M;
				}
			}
			System.out.println(count);
			
		}
	}
}
