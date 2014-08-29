/**
 * https://codeiq.jp/ace/cielavenir/q431
 * 数字、文字、文字列リテラルを使わずに
 * Hello Worldを標準出力に出力するプログラム
 *
 * ※パッケージを指定するとこれはうまく動かない
 *
 * @author seri
 */
public class HelloWorldChallenge {

	public static void main(String[] args) {

		String hello = Hello.class.getSimpleName();
		String result = World.class.toString();
		System.out.println(hello.concat(result.substring(hello.length())));
	}
}

class Hello {}
class World {}
