package sandbox;

import java.util.HashSet;
import java.util.Set;

/**
 * 文字列の中で重複している文字を出力する
 *
 * @author seri
 */
public class ArrayAndStringSample {

	/**
	 * targetstrの中に重複した文字が出現した場合、
	 * 重複順に重複文字を出力する。<br>
	 * 空文字の場合は何もしない。
	 *
	 * @param targetstr 検査対象文字列
	 */
	static void question1_1(String targetstr) {
		Set<String> checkSet = new HashSet<>();

		if (targetstr == null || targetstr.length() == 0) return;

		for (int i=0,size=targetstr.length(); i<size; i++) {
			String checkstr = targetstr.substring(i, i+1);
			if (!checkSet.contains(checkstr)) {
				checkSet.add(checkstr);
			}
			else {
				System.out.println("重複文字：" + checkstr);
			}
		}

	}


	public static void main(String[] args) {
		question1_1("hogehogehuga");
	}
}
