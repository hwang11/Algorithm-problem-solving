package han;

import java.util.HashMap;
//의상의 종류 수와, 종류에 해당하는 가지수를 이용하여 구하기 
// 모자가 2개라면 모자만으로 가능한 경우는 3가지입니다. 첫 번째를 쓰거나, 두 번째를 쓰거나, 아무것도 쓰지 않거나 이렇게 총 3가지
// 아무것도 입지않는 경우는 빼야하므로 마지막에 -1 
public class sp {
	public static int solution(String[][] clothes) {
        int answer = 0;
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        for(int i=0;i<clothes.length;i++) {
        	if(map.containsKey(clothes[i][1])) {
        		map.put(clothes[i][1],map.get(clothes[i][1])+1);
        	}
        	else map.put(clothes[i][1],1);
        }
        int ans = 1;
        for(int j : map.values()) {
        	ans *= (j+1); //아무것도 쓰지않는 경우가 있으므로 +1 
        }
        return ans-1; //부분집합들을 고려할때 공집합을 제외하기때문
    }

	public static void main(String args[]) {
		// [[yellow_hat, headgear], [blue_sunglasses, eyewear], [green_turban,
		// headgear]]
		String a[][] = { { "mask", "face" }, { "sunglasses", "face" },
				{ "makeup", "face" },{ "makeup", "hair" },{ "makeup", "t" } };
		solution(a);
	}
}
