package BOJ;

//정점이 아닌 경로를 모두 방문해야하는 문제 
//방문할 정점의 우선순위는 알파벳순 
public class trip {
	static boolean v[];
	static String ans[];
	static String rs;
	static int idx, minidx;
	static String minString;
	static boolean chk() {
		for(int i=0;i<v.length;i++) {
			if(!v[i]) return false;
		}
		return true;
	}
	static void dfs(int d, String[][] arr) {
		if(chk()) return;
		v[d] = true;
		minString ="ZZZ";
		rs += arr[d][1]+",";
		for (int i = 0; i < arr.length; i++) {
			if (v[i]) continue;
			if (arr[i][0] == arr[d][1]) { //지금의도착점과 앞으로 갈 출발점이 동일하다면 
				//System.out.printf("같음 %s,%s" + "\n", arr[i][0], arr[d][1]);
				if(minString.compareTo(arr[i][0]) > 0) {
					minString = arr[i][0];
					minidx = i;
				}
			}
		}
		dfs(minidx, arr);
	}

	public static String[] solution(String[][] tickets) {
		String[] answer = new String[tickets.length+1];
		v = new boolean[tickets.length];
		minidx = 0;
		String ms = "ZZZ";
		int mi = 0;
		rs = "";
		rs += "ICN,"; //처음은 ICN에서 시작 
		idx = 1;
		for (int i = 0; i < tickets.length; i++) {
			if(tickets[i][0].equals("ICN")) {
				if(ms.compareTo(tickets[i][1]) > 0) {
					ms = tickets[i][1];
					mi = i;
				}
			}
		}
		dfs(mi,tickets);
		for(int i=0;i<answer.length;i++) {
			answer[i] = rs.split(",")[i];
		}
		return answer;
	}

	public static void main(String args[]) {
		// [[ICN, JFK], [HND, IAD], [JFK, HND]]
		// String a[][] = {{"ICN", "JFK"},{"HND", "IAD"},{"JFK", "HND"}};
		 String cc[];
		// [[ICN, SFO], [ICN, ATL], [SFO, ATL], [ATL, ICN], [ATL,SFO]]
		String a[][] = { { "ICN", "SFO" }, { "ICN", "ATL" }, { "SFO", "ATL" }, { "ATL", "ICN" }, { "ATL", "SFO" } };
		cc=solution(a);
		for(int i=0;i<cc.length;i++) {
			System.out.println(cc[i]);
		}
//		String a1 = "ZZZ";//이게 더 큰 값 
//		String s2 = "ICN";
//		System.out.println(a1.compareTo(s2));
	}
}
