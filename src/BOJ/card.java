package Etc;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class card {
	// 가능여부, 최종 카드 수, 최종 종류 수 출력
	public static void main(String[] args) {
		int n = 5;
		String arr[] = { "a", "b", "c", "b", "a" };
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < arr.length; i++) {
			if (map.containsKey(arr[i])) {
				int cnt = map.get(arr[i]);
				map.put(arr[i], ++cnt);
			}
			else map.put(arr[i], 1);
		}
		List<Map.Entry<String, Integer>> list = new LinkedList<>(map.entrySet());

		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() { 
			@Override
			public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
				if (o1.getValue() > o2.getValue()) return 1; //오름차순  
				else if( o1.getValue() < o2.getValue()) return -1;
				return 0;
			}
		});
		
		if(list.get(0).getValue() == list.get(list.size()-1).getValue()) {
			System.out.println("Y"); //추가할 필요없이 같은경우 
			System.out.println(arr.length);
		}
		else {
			if(list.get(0).getValue()+1 == list.get(list.size()-1).getValue()) {
				System.out.println("Y");
				System.out.println(arr.length+1);
			}
			else {
				System.out.println("N");
				System.out.println(arr.length);
			}
		}
		
		System.out.println(map.size());
	}
}
