package fuckjava;

import java.lang.instrument.Instrumentation;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LoadClass {

    public static void main(String[] args) {
        Instrumentation instrumentation = InstrumentHook.getInstrumentation();
        Class<?>[] classes = instrumentation.getAllLoadedClasses();
        List<Class<?>> list = Arrays.asList(classes);
        Collections.sort(list, new Comparator<Class<?>>() {
			public int compare(Class<?> o1, Class<?> o2) {
				return o1.toString().compareTo(o2.toString());
			}
        });
        for (Class<?> cz : classes) {
            System.out.println(cz.getName());
        }
    }

}

