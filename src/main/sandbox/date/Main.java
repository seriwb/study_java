package sandbox.date;

/**
 *
 *
 * @author seri
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println("Sysdate at Millis\t:" + DateUtil.getSysdateAtMillis());	// こっちが通常の現在日時
		System.out.println("Sysdate at Nano\t\t:" + DateUtil.getSysdateAtNano());	// 現在日時にはならない
	}

}
