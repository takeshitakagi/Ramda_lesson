import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RamudaTest {

	public static void main(String[] args) {

		User user1 = new User(1, "佐藤A男");
		User user2 = new User(2, "鈴木B子");
		User user3 = new User(3, "高橋C助");

		List<User> users = new ArrayList<>();

		users.add(user1);
		users.add(user2);
		users.add(user3);

		for(User user : users) {
			System.out.print(user.getId() + "：");
			System.out.println(user.getName());
		}

		testMethod(User users);

	}

	public void testMethod(List<User> users) {
		 List<String> result = users.stream() // ここでリストusersからstreamオブジェクトを取得
		 .map( // 写像開始
		   (user) ->  { // ラムダという書き方で、この中の関数に引数として渡すuserの型や返値の型などを省略できる書き方
		     return user.getName();
		   }
		 )
		 .collect(Collectors.toList()); // この行はおまじない。最後にstreamから扱いやすいListに戻してあげる「終端操作」というやつ。javaはここが弱い。
		 System.out.println(result); // コンソールに [佐藤A男, 鈴木B子, 高橋C助] とひょうじされるはず。
		}

}
