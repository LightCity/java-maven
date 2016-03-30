package fuckjava;

public class Common {

    public static void main(String[] args) {
        System.out.println( ((Integer)null) instanceof Integer);
        
        Integer a = (Integer)null;
        System.out.println(a instanceof Integer);
    }

}
