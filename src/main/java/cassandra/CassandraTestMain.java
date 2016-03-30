package cassandra;

public class CassandraTestMain {

	public static void main(String[] args) {
		SimpleClient client = new SimpleClient();
		client.connect("127.0.0.1");
		client.close();
	}

}
