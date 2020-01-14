package aaa;

public class b2 {
	public static int solution(String[] bishops) {
        int answer = 0;
        int d[][] = {{1,-1},{1,1},{-1,-1},{-1,1}};
        int arr[][] = new int[9][9];
        int cnt =0;
        cnt += bishops.length;
        for(int i=0;i<bishops.length;i++) {
        	int x = bishops[i].charAt(1)-48;
        	int y = bishops[i].charAt(0)-64;
        	arr[x][y] = 2;
        	for(int j=1;j<=8;j++) {
        		for(int k=0;k<4;k++) {
            		int nx = x + d[k][0]*j;
            		int ny = y + d[k][1]*j;
            		if(nx > 8 || ny > 8 || nx < 1 || ny <1) continue;
            		if(arr[nx][ny]==1 || arr[nx][ny]==2) continue;
            		cnt++;
            		arr[nx][ny] = 1;
        		}
        	}
        }
//        for(int i=0;i<9;i++) {
//        	for(int j=0;j<9;j++) {
//        		System.out.print(arr[i][j]+" ");
//        	}
//        	System.out.println();
//        }
        int total = 0;
        for(int i=1;i<9;i++) {
        	for(int j=1;j<9;j++) {
        		if(arr[i][j]>=1) total++;
        	}
        }
//        System.out.println("t"+total);
//        System.out.println(cnt);
        answer = 64 - total;
        //System.out.println(answer);
        return answer;
    }
	public static void main(String[] args) {
		String a[] = {"D5"};
		String b[] = {"D5", "E8", "G2"};
		solution(a);
		solution(b);
	}
}
