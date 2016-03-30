package fuckjava;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.*;

public class Reg {
    
    private static final Pattern CGLIB_RENAMED_METHOD_PATTERN = Pattern.compile("CGLIB\\$(.+)\\$\\d+");

    public static void main(String[] args) {
    	Pattern pattern = Pattern.compile("\\B(\\p{Upper})");
    	Matcher matcher = pattern.matcher("longAndLongCCityL");
    	String replaceAll = matcher.replaceAll("_$1");
    	System.out.println(replaceAll.toLowerCase());
        
//        String pattern = "\\b(\\w+)\\b[\\w\\W]*\\b\\1\\b";
//        Pattern p = Pattern.compile(pattern, Pattern.CASE_INSENSITIVE);
//        String phrase = "unique is not duplicate but unique, Duplicate is duplicate.";
//        Matcher m = p.matcher(phrase);
//        while (m.find()) {
//            String val = m.group();
//            System.out.println("Matching subsequence is \"" + val + "\"");
//            System.out.println("Duplicate word: " + m.group(1) + "\n");
//            System.out.println("groupCount: " + m.groupCount() + "\n");
//        }
        
//        String str = "123123123123";
//        Pattern p = Pattern.compile("(\\d\\d\\d)\\1");
//        Matcher m = p.matcher(str);
//        System.out.println(m.groupCount());
//        while (m.find()) {
//            String word = m.group();
//            System.out.println(word + " " + m.start() + " " + m.end());
//        }
        

//        Pattern pattern = Pattern.compile("(?<a>\\d+)\\.(?<b>\\d+)\\.(?<c>\\d+)");
//        Matcher matcher = pattern.matcher("123.456.789");
//
//        boolean matches = matcher.matches();
//        System.out.println(matches);
//        
//        String ss = matcher.replaceAll("xxx$1xxx$2xxx$3");
//        System.out.println(ss);
//
//        String sx = matcher.replaceAll("xxx${c}xxx${a}xxx$2");
//        System.out.println(sx);
//        
//        //System.out.println(matcher.groupCount());
//        
//        System.out.println( matcher.start() );
//        System.out.println(matcher.group("a"));
//        System.out.println(matcher.group("b"));
//        System.out.println(matcher.group("c"));
//        System.out.println(matcher.group(1));
//        System.out.println(matcher.group(2));
//        System.out.println(matcher.group(3));
        
        
//        Matcher matcher = CGLIB_RENAMED_METHOD_PATTERN.matcher(
//                "1 CGLIB$xxx$123 iii CGLIB$000$3456");
//        
//        
//        while (matcher.find()) {
//            System.out.println("===============================");
//            
//            int start = matcher.start();
//            System.out.println("start = " + start);
//            
//            int groupCount = matcher.groupCount();
//            System.out.println("groupCount = " + groupCount);
//            
//            
//            
//            String g = matcher.group(1);
//            System.out.println("g = " + g);
//            
//            String group = matcher.group();
//            
//            System.out.println("group = " + group);
//        }
    }

}
