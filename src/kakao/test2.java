package kakao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class test2 {
	public static int[] solution(int N, int[] stages) {
		int v[] = new int[N+2];
		for(int i=0;i<stages.length;i++) {
			v[stages[i]]++;
		}
		double cnt = 0;
		double value = 0;
		List<ST> list = new ArrayList<ST>();
		for(int i=1;i<=N;i++) {
			cnt = 0;
			for(int j=0;j<stages.length;j++) {
				if(stages[j]>=i) cnt++;
			}
			value=v[i]/cnt;
			list.add(new ST(i,value));
		}
		Collections.sort(list);
		int answer[] = new int[N];
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				if(list.get(i-1).value == list.get(j-1).value) {
					if(list.get(i-1).num>list.get(j-1).num) {
						ST y = list.get(i-1);
						list.set(i-1, list.get(j-1));
						list.set(j-1, y);
					}
				}
			}
			
		}
		for(int i=N;i>0;i--) {
			
			
			answer[N-i]=list.get(i-1).num;
		}
		
		for(int i=0;i<answer.length;i++) {
			System.out.println(answer[i]);
		}
		
		
        return answer;
    }
	
	public static void main(String args[]) {
		int [] arr = {2, 1, 2, 6, 2, 4, 3, 3};
		int [] r;
		r = solution(5,arr);
		
	}
	
	static class ST implements Comparable<ST> {
	    double value;
	    int num;
	    
	    public ST(int num,double v) {
	        this.num = num;
	        this.value = v;
	    }
	    
	    public int getNum() {
	        return this.num;
	    }
	    
	    public double getValue() {
	        return this.value;
	    }
	    
	    @Override
	    public int compareTo(ST s) {
	        if (this.value < s.getValue()) {
	            return -1;
	        } else if (this.value > s.getValue()) {
	            return 1;
	        }
	        return 0;
	    }
	}


	
}
