package java_practice;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

import java.util.*;

public class test {
	public static void main(String args[]) {
		/*ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		list.add(7);
		list.add(8);
		list.add(9);
		list.add(10);
		Iterator it = list.iterator();
		
		
		while(it.hasNext()) {
			System.out.println(it.next());
		}*/
		
		/* LinkedList
		LinkedList<Integer> li = new LinkedList<Integer>();
		li.add(1);
		li.add(2);
		li.add(3);
		li.add(4);
		li.add(5);
		li.add(6);
		li.add(7);
		li.add(8);
		li.add(9);
		li.add(10);
		
		Iterator it = li.iterator();
		System.out.println("처음입력.");
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		li.remove(5);
		li.remove(6);
		
		Iterator it2 = li.iterator();
		System.out.println("삭제...");
		while(it2.hasNext()) {
			System.out.println(it2.next());
		}
		*/
		
		/* PriorityQueue
		Queue<Integer> q = new PriorityQueue<Integer>();
		q.add(10);
		q.add(9);
		q.add(8);
		q.add(7);
		q.add(6);
		q.add(5);
		q.add(4);
		q.add(3);
		q.add(2);
		q.add(1);
		Iterator it = q.iterator();
		
		while(it.hasNext()) {
			System.out.println("iterator:"+it.next()); //이건heap상태가 배열로 만들어져서 나오는것.
		}
		
		for(int i=0;i<10;i++) {
			System.out.println(q.poll()); //poll을써야 작은 값 부터 순서대로 하나씩 나오는것.
		}
		*/
		
		
		/*listIterator
		LinkedList<Integer> li = new LinkedList<Integer>();
		li.add(1);
		li.add(2);
		li.add(3);
		li.add(4);
		li.add(5);
		li.add(6);
		li.add(7);
		li.add(8);
		li.add(9);
		li.add(10);
		
		ListIterator<Integer> it = li.listIterator();
		while(it.hasNext()) {
			System.out.println("순방향:"+it.next());
		}
		//커서의 위치를 옮기려면 next를 먼저해줘야댐댐댐!
		System.out.println();
		while(it.hasPrevious()) {
			System.out.println("역방향:"+it.previous());
		}
		*/
		
		/* Iterator remove
		ArrayList<Integer> ar = new ArrayList<Integer>();
		ar.add(1);
		ar.add(2);
		ar.add(3);
		ar.add(4);
		ar.add(5);
		
		Iterator it = ar.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		Iterator it2 = ar.iterator();
		it2.next();
		it2.remove();
		it2.next();
		it2.remove();
		
		System.out.println();
		
		while(it2.hasNext()) {
			System.out.println(it2.next());
		}
		*/
		
		
		ArrayList<Integer> li = new ArrayList<Integer>();
		li.add(1);
		li.add(2);
		li.add(3);
		li.add(4);
		li.add(5);
		System.out.println(li.hashCode());
		
		ArrayList<Integer> li2 = (ArrayList<Integer>) li.clone();
		li2.add(6);
		System.out.println(li.get(4));
		System.out.println(li2.get(5));
		
		System.out.println(li2.hashCode());
		
		
		
		
		
		
	}
}
