package fuckjava;

public class ThrowTest {

    public static void main(String[] args) {
       int value = foo();
       System.out.println(value);
    }

    static int foo() {
        try {
            int n = 0;
            int m = 1 / n;
            System.out.println(m);
            return m;
        } catch (Throwable e) {
            System.out.println(e);
            throw e;
        } finally {
            System.out.println("finally");
            return 1;
        }
    }
}
