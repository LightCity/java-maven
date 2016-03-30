package java8;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

public class StreamTest2 {
	static Random rand = new Random();

	public static void main(String[] args) {
		final int size = 5;
		List<List<Integer>> ll = new ArrayList<List<Integer>>(size);
		for (int n=0; n<size; ++n) {
			List<Integer> l = new ArrayList<Integer>();
			for (int m=0; m<size; ++m) {
				l.add(rand.nextInt(100));
			}
			ll.add(l);
		}
		
		LinkedList<Integer> linkedList = ll.stream().flatMap(l->l.stream())
				.parallel()
//				.collect(
//						/*java.util.LinkedList::new,*/
//						/*StreamTest2::newListC,*/
//						new StreamTest2()::newListO,
//						
//						List::add,
//						
//						//List::addAll
//						StreamTest2::joinList
//						)
				.collect(Collectors.toCollection(LinkedList::new))
				;
		System.out.println(linkedList);
		
		Map<Integer, List<Integer>> grouping = linkedList.stream().collect(Collectors.groupingBy(n->n%7));
		System.out.println(grouping);
		
		String joining = linkedList.stream().map(Object::toString).collect(Collectors.joining("-", "[", "]"));
		System.out.println(joining);
	}

	static java.util.LinkedList<Integer> newListC() {
		return new java.util.LinkedList<Integer>();
	}
	java.util.LinkedList<Integer> newListO() {
		return new java.util.LinkedList<Integer>();
	}
	//======================================
	static void joinList(java.util.LinkedList<Integer> l1, java.util.LinkedList<Integer> l2) {
		l1.addAll(l2);
	}
}
