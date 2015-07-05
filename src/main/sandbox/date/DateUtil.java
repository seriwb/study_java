package sandbox.date;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日時関連のユーティリティ
 *
 * @author seri
 */
public class DateUtil {

	private static final String DEFAULT_DATE_FORMAT = "yyyy/MM/dd hh:mm:ss";

	/**
	 * 現在日時取得処理。<br>
	 * yyyy/MM/dd hh:mm:ssの形式の現在日時を返却する。
	 *
	 * @return 現在日時（yyyy/MM/dd hh:mm:ss形式）
	 */
	public static String getSysdateAtMillis() {
		return getSysdateAtMillis(DEFAULT_DATE_FORMAT);
	}

	/**
	 * 現在日時取得処理。<br>
	 *
	 * @param format 取得する現在日時のフォーマット
	 * @return 指定したフォーマットに成形した現在日時
	 */
	public static String getSysdateAtMillis(String format) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		Date date = new Date(System.currentTimeMillis());
		return dateFormat.format(date);
	}

	/**
	 * 嘘っこ現在日時取得処理。<br>
	 * 取得するのは現在時刻ではなく、固定された任意の時間からの経過時間 (ナノ秒)。<br>
	 *
	 * @return 嘘っこ現在日時
	 */
	public static String getSysdateAtNano() {
		return getSysdateAtNano(DEFAULT_DATE_FORMAT);
	}

	public static String getSysdateAtNano(String format) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		Date date = new Date(System.nanoTime());
		return dateFormat.format(date);
	}
}
