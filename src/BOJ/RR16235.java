package Asamsung;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RR16235 {
	static int n,m,k;
    static int[][] arr,copy;
    static List<ArrayList<ArrayList<Pair>>> list = new ArrayList<>();
    static int[][] dr =  { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 0, 1 }, { 1, -1 }, { 1, 0 }, { 1, 1 } };
   
    static void spring() {
    	for(int i=0;i<n;i++) {
    		for(int j=0;j<n;j++) {
    			for(int k=0;k<list.get(i).get(j).size();k++) {
    				if(arr[i][j]>= list.get(i).get(j).get(k).age) {
    					arr[i][j] -= list.get(i).get(j).get(k).age;
    					list.get(i).get(j).get(k).age++;
    				}else {
    					list.get(i).get(j).get(k).v = 0;
    				}
    			}
    		}
    	}
    }
    static void summer() {
    	for(int i=0;i<n;i++) {
    		for(int j=0;j<n;j++) {
    			for(int k=0;k<list.get(i).get(j).size();k++) {
    				if(list.get(i).get(j).get(k).v == 0) {
    					arr[i][j] += list.get(i).get(j).get(k).age/2;
    					list.get(i).get(j).remove(k);
    					k--;
    				}
    			}
    		}
    	}
    }
    static void fall() {
    	for(int i=0;i<n;i++) {
    		for(int j=0;j<n;j++) {
    			for(int k=0;k<list.get(i).get(j).size();k++) {
    				if(list.get(i).get(j).get(k).age%5==0) {
    					for(int p=0;p<8;p++) {
    						int nx = i + dr[p][0];
    						int ny = j + dr[p][1];
    						if(nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
    						list.get(nx).get(ny).add(0, new Pair(i,j,1,1));
    					}
    				}
    			}
    		}
    	}
    }
    static void winter() {
    	for(int i=0;i<n;i++) {
    		for(int j=0;j<n;j++) {
    			arr[i][j] += copy[i][j];
    		}
    	}
    }
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		k = sc.nextInt();
		arr = new int[n][n];
		copy = new int[n][n];
		for(int i=0;i<n;i++) {
			 list.add(new ArrayList<>());;
			for(int j=0;j<n;j++) {
				list.get(i).add(new ArrayList<>());
				copy[i][j] = sc.nextInt();
				arr[i][j] = 5;
			}
		}
		for(int i=0;i<m;i++) {
			int x = sc.nextInt()-1;
			int y = sc.nextInt()-1;
			int age = sc.nextInt();
			list.get(x).get(y).add(new Pair(x,y,1,age));
		}
		for(int i=0;i<k;i++) {
			spring();
			summer();
			fall();
			winter();
		}
		int ans = 0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				ans += list.get(i).get(j).size();
			}
		}
		System.out.println(ans);
	}
	static class Pair{
        int x,y; // 위치
        int v; // 상태 (1살음,0죽음)
        int age; // 나이
        Pair(int x,int y,int v,int age){
            this.x = x;
            this.y = y;
            this.v = v;
            this.age = age;
        }
    }
}
