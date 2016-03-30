package java8;

import java.util.*;
import java.util.function.Function;
import java.util.stream.IntStream;

import util.RandomUtil;

public class StreamTest4 {

	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (int n=0; n<100; ++n) {
			map.put(RandomUtil.nextString(2), RandomUtil.nextInt(10));
		}
		map.forEach((key, value)->System.out.println("key="+key + ", value="+value));
		
		Function<Integer, String> f1 = (Function<Integer, String>) ((Integer n)->n.toString());
		Function<Integer, String> f2 = (Function<Integer, String>) ((Integer n)->n.toString());
		System.out.println( f1.getClass().getName() );
		System.out.println( f2.getClass().getName() );
		
		int[] array = IntStream.range(0, 100).toArray();
		System.out.println(array[array.length - 1]);
		
		OptionalInt max = Arrays.stream(array).max();
		System.out.println(max.orElseGet(()->-1));
		System.out.println(max.getAsInt());
		
		OptionalInt max2 = Arrays.stream(array).reduce((a, b)->a>b ? a : b);
		System.out.println(max2.getAsInt());
		
		int[] array2 = new int[100];
		IntStream.range(0, array2.length).forEach(n->array2[n]=n);
	}

}
