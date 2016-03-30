package fuckjava;

public class HashCodeTest {

	public static void main(String[] args) {
		People p = new People();
		p.name = "fuck";
		p.sex = 0;
		p.age = 100;
		System.out.println(p.hashCode());
		
		p.name = "you";
		p.sex = 1;
		p.age = 20;
		System.out.println(p.hashCode());
	}
	static class People {
		String name;
		int sex;
		int age;
	}
}
