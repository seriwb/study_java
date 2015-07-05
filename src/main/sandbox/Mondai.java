package sandbox;

/**
 * 1 2 3 4 5 6の配列を2 1 4 3 6 5にするプログラム
 *
 * @author seri
 */
public class Mondai {

	public static void main(String[] args) {

		int[] datas = { 1, 2, 3, 4, 5, 6 };

		for (int data : saiki(datas, datas.length)) {
			System.out.print(data + " ");
		}
	}

	/**
	 * 受け取った数字配列の奇数を+1、偶数を-1して返却する
	 *
	 * @param datas 数字配列
	 * @param length チェックする配列の位置
	 * @return 奇数は+1、偶数は-1した後の数字配列
	 */
	static int[] saiki(int[] datas, int length) {

		if (length == 0) return datas;

		int data = datas[length-1];

		if ((data % 2) == 1) {
			datas[length - 1] += 1;
		}
		else {
			datas[length - 1] -= 1;
		}
		return saiki(datas, length - 1);

	}

}
