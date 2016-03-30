package fuckjava;

import java.util.*;

public class HalfSearch {

	
	public static void main(String[] args) {
		final int size = 2 * 10000 * 10000;
		final int[] ary = new int[size];
		Random random = new Random();
		for (int n=0; n<size; ++n) {
			ary[n] = random.nextInt(Integer.MAX_VALUE);
		}
		Arrays.sort(ary);
		
		final int targetPos = random.nextInt(size);
		final int targetValue = ary[targetPos];
		System.out.println("targetPos=" + targetPos);
		
		final long begin = System.currentTimeMillis();
		int minPos = 0;
		int maxPos = size - 1;
		int pos = maxPos;
		if (ary[pos] == targetValue) {
			System.out.println("pos=" + pos);
		}
		while (maxPos > minPos) {
			pos = (minPos + maxPos) / 2;
			if (ary[pos] == targetValue) {
				System.out.println("pos=" + pos);
				break;
			} else if (ary[pos] > targetValue) {
				maxPos = pos;
			} else {
				minPos = pos;
			}
		}
		final long end = System.currentTimeMillis();
		System.out.println("time cose = " + (end - begin));
		System.out.println("fuck");
	}

}
