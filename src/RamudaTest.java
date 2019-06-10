import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RamudaTest {

	public static void main(String[] args) {

		Map<Integer, String> users = new HashMap<Integer, String>();
		users.put(1, "佐藤A男");
		users.put(2, "鈴木B子");
		users.put(3, "高橋C助");
	}

	public void testMethod(List<User> users) {
		 List<String> result = users.stream() // ここでリストusersからstreamオブジェクトを取得
		 .map( // 写像開始
		   (user) ->  { // ラムダという書き方で、この中の関数に引数として渡すuserの型や返値の型などを省略できる書き方
		     return user.get();
		   }
		 )
		 .collect(Collectors.toList()); // この行はおまじない。最後にstreamから扱いやすいListに戻してあげる「終端操作」というやつ。javaはここが弱い。
		 System.out.println(result); // コンソールに [佐藤A男, 鈴木B子, 高橋C助] とひょうじされるはず。
		}

}
