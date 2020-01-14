package Algo12;

import java.util.Scanner;

public class B5373 {
	static int k,n;
	static char map[][][];
	static char copy[][][];
	static void print() {
		for(int o=0;o<6;o++) {
			System.out.println(o);
			for(int y=0;y<3;y++) {
				for(int x=0;x<3;x++) {
					System.out.print(map[o][y][x]);
				}
				System.out.println();
			}
			System.out.println();
		}
		System.out.println("===========");
	}
	static void copy(){
		for(int o=0;o<6;o++) {
			for(int y=0;y<3;y++) {
				for(int x=0;x<3;x++) {
					copy[o][y][x] = map[o][y][x];
				}
			}
		}
	}
	static void rotate(char f,char d) {
		copy(); //clone했더니 주소값이 복사된듯? 
		if(d == '+') {//시계방향 
			switch(f) {
			case 'U':for(int i=0;i<3;i++) {
					map[5][0][i] = copy[0][0][i];
					map[2][0][i] = copy[5][0][i];
					map[0][0][i] = copy[4][0][i];
					map[4][0][i] = copy[2][0][i];
					map[1][2][2-i] = copy[1][i][2];
					map[1][i][2] = copy[1][0][i];
					map[1][i][0] = copy[1][2][i];
					map[1][0][2-i] = copy[1][i][0];
					}
					break;
			case 'D':for(int i=0;i<3;i++) {
				map[2][2][i] = copy[4][2][i];
				map[4][2][i] = copy[0][2][i];
				map[0][2][i] = copy[5][2][i];
				map[5][2][i] = copy[2][2][i];
				map[3][2][2-i] = copy[3][i][2];
				map[3][i][2] = copy[3][0][i];
				map[3][i][0] = copy[3][2][i];
				map[3][0][2-i] = copy[3][i][0];
				}
				break;	
			case 'F':for(int i=0;i<3;i++) {
				map[1][2][i] = copy[4][2-i][2];
				map[5][i][0] = copy[1][2][i];
				map[4][i][2] = copy[3][0][i];
				map[3][0][2-i] = copy[5][i][0];
				map[2][2][2-i] = copy[2][i][2];
				map[2][i][2] = copy[2][0][i];
				map[2][i][0] = copy[2][2][i];
				map[2][0][2-i] = copy[2][i][0];
				}
				break;
			case 'B':for(int i=0;i<3;i++) {
				map[4][2-i][0] = copy[1][0][i];
				map[1][0][i] = copy[5][i][2];
				map[5][i][2] = copy[3][0][i];
				map[3][0][2-i] = copy[4][i][0]; //dlrjaks
				map[0][2][2-i] = copy[0][i][2];
				map[0][i][2] = copy[0][0][i];
				map[0][i][0] = copy[0][2][i];
				map[0][0][2-i] = copy[0][i][0];
				}
				break;
			case 'L':for(int i=0;i<3;i++) {
				map[2][i][0] = copy[1][i][0];
				map[3][i][0] = copy[2][i][0];
				map[0][2-i][2] = copy[3][i][0];
				map[1][2-i][0] = copy[0][i][2];
				map[4][2][2-i] = copy[4][i][2];
				map[4][i][2] = copy[4][0][i];
				map[4][i][0] = copy[4][2][i];
				map[4][0][2-i] = copy[4][i][0];
				}
				break;
			case 'R':for(int i=0;i<3;i++) {
				map[1][i][2] = copy[2][i][2];
				map[0][2-i][0] = copy[1][i][2];
				map[3][i][2] = copy[0][i][0];
				map[2][i][2] = copy[3][i][2];
				map[5][2][2-i] = copy[5][i][2];
				map[5][i][2] = copy[5][0][i];
				map[5][i][0] = copy[5][2][i];
				map[5][0][2-i] = copy[5][i][0];
				}
				break;		
			}
		}
		else if(d == '-') {
			switch(f) {
			case 'U':for(int i=0;i<3;i++) {
					map[0][0][i] = copy[5][0][i];
					map[5][0][i] = copy[2][0][i];
					map[4][0][i] = copy[0][0][i];
					map[2][0][i] = copy[4][0][i];
					map[1][i][2] = copy[1][2][2-i];
					map[1][0][i] = copy[1][i][2];
					map[1][2][i] = copy[1][i][0];
					map[1][i][0] = copy[1][0][2-i];
					}
					break;
			case 'D':for(int i=0;i<3;i++) {
				map[4][2][i] = copy[2][2][i];
				map[0][2][i] = copy[4][2][i];
				map[5][2][i] = copy[0][2][i];
				map[2][2][i] = copy[5][2][i];
				map[3][i][2] = copy[3][2][2-i];
				map[3][0][i] = copy[3][i][2];
				map[3][2][i] = copy[3][i][0];
				map[3][i][0] = copy[3][0][2-i];
				}
				break;	
			case 'F':for(int i=0;i<3;i++) {
				map[4][2-i][2] = copy[1][2][i];
				map[1][2][i] = copy[5][i][0];
				map[3][0][i] = copy[4][i][2];
				map[5][i][0] = copy[3][0][2-i];
				map[2][i][2] = copy[2][2][2-i];
				map[2][0][i] = copy[2][i][2];
				map[2][2][i] = copy[2][i][0];
				map[2][i][0] = copy[2][0][2-i];
				}
				break;
			case 'B':for(int i=0;i<3;i++) {
				map[1][0][i] = copy[4][2-i][0];
				map[5][i][2] = copy[1][0][i];
				map[3][0][i] = copy[5][i][2];
				map[4][i][0] = copy[3][0][2-i];
				map[0][i][2] = copy[0][2][2-i];
				map[0][0][i] = copy[0][i][2];
				map[0][2][i] = copy[0][i][0];
				map[0][i][0] = copy[0][0][2-i];
				}
				break;
			case 'L':for(int i=0;i<3;i++) {
				map[1][i][0] = copy[2][i][0];
				map[2][i][0] = copy[3][i][0];
				map[3][i][0] = copy[0][2-i][2];
				map[0][2-i][2] = copy[1][i][0];
				map[4][i][2] = copy[4][2][2-i];
				map[4][0][i] = copy[4][i][2];
				map[4][2][i] = copy[4][i][0];
				map[4][i][0] = copy[4][0][2-i];
				}
				break;
			case 'R':for(int i=0;i<3;i++) {
				map[2][i][2]= copy[1][i][2];
				map[1][i][2] = copy[0][2-i][0];
				map[0][i][0] = copy[3][i][2];
				map[3][i][2] = copy[2][i][2];
				map[5][i][2] = copy[5][2][2-i];
				map[5][0][i] = copy[5][i][2];
				map[5][2][i] = copy[5][i][0];
				map[5][i][0] = copy[5][0][2-i];
				}
				break;		
			}
		}
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		k = sc.nextInt(); //전체 명령의 수 
		for(int i=0;i<k;i++) {
			n = sc.nextInt();
			char c[] = {'o','w','r','y','g','b'};
			map = new char[6][3][3];
			copy = new char[6][3][3];
			for(int o=0;o<6;o++) {
				for(int y=0;y<3;y++) {
					for(int x=0;x<3;x++) {
						map[o][y][x] = c[o];
					}
				}
			}
			for(int j=0;j<n;j++) {
				String s = sc.next();
				char f = s.charAt(0);
				char d = s.charAt(1);
				rotate(f,d);
				print();
			}
			for(int y=0;y<3;y++) {
				for(int x=0;x<3;x++) {
					System.out.print(map[1][y][x]);
				}
				System.out.println();
			}
		}
	}
}
