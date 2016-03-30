package java8;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

public class StreamTest3 {
	
	static List<Ha> list;
	static {
		char[] chars = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
		Random rand = new Random();
		list = new ArrayList<Ha>();
		final int nameSetSize = 5;
		String[] names = new String[nameSetSize];
		for (int n=0; n<nameSetSize; ++n) {
			StringBuilder sb = new StringBuilder();
			int nextLong = rand.nextInt();
			for (int k=0; k<4; ++k) {
				char ch = chars[ (int) (( nextLong >>> (4 * k) ) & 0xF) ];
				sb.append(ch);
			}
			names[n] = sb.toString();
		}
		for (int n=0; n<100/*HaListSize*/; ++n) {
			Ha ha = new Ha();
			ha.setName(names[rand.nextInt(nameSetSize)]);
			ha.setInfo(new Info(rand.nextInt()));
			list.add(ha);
		}
		System.out.println(list);
	}
	public static void main(String[] args) {
		Map<String, List<Integer>> collect = list.stream().collect(Collectors.groupingBy(Ha::getName, Collectors.mapping(ha->ha.getInfo().getId(), Collectors.toList())));
		System.out.println(collect);
	}
}

class Ha {
	private String name;
	private Info info;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Info getInfo() {
		return info;
	}
	public void setInfo(Info info) {
		this.info = info;
	}
	@Override
	public String toString() {
		return "[name="+name + ",info=" + info.getId() + "]";
	}
}

class Info {
	private int id;
	public Info(int id) {
		this.id = id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override public String toString() {return "[info:id="+id+"]";}
}