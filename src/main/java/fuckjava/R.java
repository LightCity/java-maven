package fuckjava;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.logging.Level;

public class R implements RI{
	
	public String foo(String fuckName) {return "";}

	public static void main(String[] args) {
		R r = new R();
		Class<? extends R> cz = r.getClass();
		Method[] declaredMethods = cz.getDeclaredMethods();
		for (Method md : declaredMethods) {
			Parameter[] parameters = md.getParameters();
			for (Parameter pm : parameters) {
				Annotation[] annotations = md.getAnnotations();
				java.util.logging.Logger.getGlobal().log(Level.WARNING, md.getName() + "  " + pm.getName());
			}
		}
	}

}
interface RI {
	public String foo(String fuckName);
}