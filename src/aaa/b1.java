package aaa;

import java.util.Arrays;
import java.util.LinkedList;

import com.sun.org.apache.xpath.internal.operations.Lt;
//시간초과 
public class b1 {
	public static int solution(int[] goods, int[] boxes){
        int answer = 0;
        for(int i=0;i<goods.length;i++) {
        	for(int j=0;j<boxes.length;j++) {
        		if(boxes[j]==-1) continue;
        		if(goods[i]==boxes[j]) {
        			goods[i]= -1;
        			boxes[j] = -1;
        			answer++;
        		}
        	}
        }
//        Arrays.sort(goods);
//        Arrays.sort(boxes);
        LinkedList<Integer> li[] = new LinkedList[goods.length];
        for(int i=0;i<goods.length;i++) {
        	li[i] = new LinkedList<Integer>();
        }
        for(int i=0;i<goods.length;i++) {
        	if(goods[i] == -1) continue;
        	boolean flag = false;
        	for(int j=0;j<boxes.length;j++) {
        		if(boxes[j] == -1) continue;
        		if(goods[i]<boxes[j]) {
        			li[i].add(j);
        			flag = true;
        		}
        	}
        	if(flag) {
        		int min = Integer.MAX_VALUE;
            	int d,idx,minidx;
            	minidx = 0;
            	for(int k=0;k<li[i].size();k++) {
            		idx = li[i].get(k);
            		d = boxes[idx]-goods[i];
            		if(d < 0) continue;
            		if(min>d) {
            			min = d;
            			minidx = idx;
            		}
            	}
            	goods[i] = - 1;
    			boxes[minidx] = -1;
    			answer++;
        	}        	
        }
        System.out.println(answer);
        return answer;
    }
	public static void main(String[] args) {
		int a[] = {5,3,7};
		int b[] = {3,7,6};
		int c[] = {1,2};
		int d[] = {2,3,1};
		int e[] = {3,8,6};
		int f[] = {5,6,4};
				
		solution(a,b);
		solution(c,d);
		solution(e,f);

		
	}
}
