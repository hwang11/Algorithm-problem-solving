package han;

public class changeword {
	static int total;
	static boolean flag;
	static boolean v[];
	static boolean chk(String a,String b) {
		int cnt = 0;
		for(int i=0;i<a.length();i++) {
			if(a.charAt(i) == b.charAt(i)) cnt++;
		}
		if(cnt == a.length()-1) return true;
		else return false;
	}
	
	static void dfs(int d,int cnt,String now,String[] words,String target) {
		if(flag) return; //정답을 이미 찾았다면 
		if(cnt == words.length) { //해당 단어가 없다면 
			if(!flag) total = 0;
			return;
		} 
		if(chk(target,now)) { //단어가 1개만 다르다면 
			for(int i=0;i<words.length;i++) {
				if(!v[i]&&words[i].equals(target)) { //그중에 방문을 안했고 목표와 같은 단어가 있다면
					flag = true; //성공 
					total = cnt+1;
				}
			}
			if(!flag)
			return;
		}
		for(int i=0;i<words.length;i++) {
			if(!v[i]&&chk(words[i],now)) { //1개만 차이난다면 방문해보기 
				v[i] = true;
				dfs(i,cnt+1,words[i],words,target);
			}
		}
	}
    public static int solution(String begin, String target, String[] words) {
    	flag = false;
    	v = new boolean[words.length];
        int answer = 0;
        total = 0;
        dfs(0,0,begin,words,target);
        answer = total;
        System.out.println(answer);
        return answer;
    }
	public static void main(String args[]) {
		String arr[] = {"hot","dot","dog","lot","log","cog"};
		solution("hit","cog",arr);
//		String arr[] = {"hot", "dot", "dog", "lot", "log"};
//		solution("hit","cog",arr);
	}
}
