package java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.IntConsumer;
import java.util.function.ToIntFunction;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.lang.System.out;

public class StreamTest {

	public static void main(String[] args) {
		IntStream.range(1, 100)
				.filter(n -> n % 3 == 0)
				//.collect(supplier, accumulator, combiner)
				//.mapToObj(n -> n + ":")
				//.reduce((a, b) -> a > b ? a : b);
		;
		
		List<Integer> list = IntStream.generate(()->1).limit(10).boxed().collect(Collectors.toList());
		System.out.println(list);
		
		List<String> strList = new ArrayList<String>();
		strList.add("1");
		strList.add("2");
		strList.add("3");
		ToIntFunction<String> toIntF = Integer::parseInt;
		
		java.util.function.Function<char[], String> charsToStr = String::new;
		System.out.println(charsToStr.getClass().getName());
		
//		IntStream.iterate(1, pre->pre*2).limit(10).boxed().collect(new Collector<String, List<String>>(){});
		
//		System.out.println(Arrays.stream(toIntF.getClass().getDeclaredMethods()).map(m->m.getName()).collect(Collectors.toList()));
		
//		new IntConsumer() {@Override public void accept(int value) {System.out.println("1.value=" + value);}}.andThen(new IntConsumer() {@Override public void accept(int value) {System.out.println("2.value=" + value);}}).accept(1000);
//		((IntConsumer) (int t) -> {out.println("a.value=" + t);}).andThen((int t) -> {out.println("b.value=" + t);}).accept(899);
	}

}
