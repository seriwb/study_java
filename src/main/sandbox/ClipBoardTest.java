package sandbox;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * OSのクリップボードからデータを取り出し、
 * そのデータが判定できることをテストしている。<br>
 * クリップボードのデータが画像の場合のみ、
 * そのデータをSwingを利用して画面表示している。<br>
 *
 * ImageSelectionを使っている部分はここでやりたいこととは無関係
 *
 * @author seri
 */
public class ClipBoardTest extends JPanel {

	Image image;

	@Override
	public void paint(Graphics g) {
		// 再描画, image を g に描く
		g.drawImage(image, 0, 0, this);
	}

	public void setImage(Image img) {
		image = img;
	}

	/**
	 * Clipboardのデータの内容を判定するコード<br>
	 * クリップボードにコピーしておいてから実行する。<br>
	 *
	 * @param args
	 */
	public static void main(String[] args) {

		// クリップボードからデータ取得
		Clipboard clip = Toolkit.getDefaultToolkit().getSystemClipboard();
		Transferable data = clip.getContents(null);

		// 画像データ判定
		boolean imageflag = data.isDataFlavorSupported(DataFlavor.imageFlavor);

		System.out.println("isImage:" + imageflag);
		System.out.println("isString:" + data.isDataFlavorSupported(DataFlavor.stringFlavor));
		System.out.println("isJavaFileList:" + data.isDataFlavorSupported(DataFlavor.javaFileListFlavor));

		// クリップボードの内容が画像であれば、画面に出力する
		if (imageflag) {
			try {
				Image img = (Image) clip.getData(DataFlavor.imageFlavor);

				ClipBoardTest cb = new ClipBoardTest();
				cb.setImage(img);

				// 画面に画像を出力する場合はこんな感じ
				JFrame f = new JFrame("TestImage");
				f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				f.getContentPane().add(cb);
				f.pack();
				f.setSize(new Dimension(480, 360));
				f.setVisible(true);

//				// クリップボードに画像の設定は例えばこんな感じ（ちなみにこれだと同じものを詰めてるだけ）
//				ImageSelection is = new ImageSelection(img);
//				clip.setContents(is, is);

			} catch (UnsupportedFlavorException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}

/**
 * 画像をクリップボートに設定するクラス
 *
 * @see <a
 *      href="http://www.ne.jp/asahi/hishidama/home/tech/java/clipboard.html">
 *      クリップボード（ひしだま's 技術メモページ）</a>
 */
class ImageSelection implements Transferable, ClipboardOwner {

	protected Image data;

	public ImageSelection(Image image) {
		this.data = image;
	}

	/**
	 * 対応しているフレーバーを返す
	 *
	 * @see java.awt.datatransfer.Transferable#getTransferDataFlavors()
	 */
	@Override
	public DataFlavor[] getTransferDataFlavors() {
		return new DataFlavor[] { DataFlavor.imageFlavor };
	}

	/**
	 * フレーバーが対応しているかどうか
	 *
	 * @see java.awt.datatransfer.Transferable#isDataFlavorSupported(java.awt.datatransfer.DataFlavor)
	 */
	@Override
	public boolean isDataFlavorSupported(DataFlavor flavor) {
		return DataFlavor.imageFlavor.equals(flavor);
	}

	/**
	 * 保持している画像を返す
	 *
	 * @see java.awt.datatransfer.Transferable#getTransferData(java.awt.datatransfer.DataFlavor)
	 */
	@Override
	public Object getTransferData(DataFlavor flavor)
			throws UnsupportedFlavorException, IOException {
		if (DataFlavor.imageFlavor.equals(flavor)) {
			return data;
		}
		throw new UnsupportedFlavorException(flavor);
	}

	/**
	 * クリップボードのデータとして不要になっときに呼ばれる
	 *
	 * @see java.awt.datatransfer.ClipboardOwner#lostOwnership(java.awt.datatransfer.Clipboard, java.awt.datatransfer.Transferable)
	 */
	@Override
	public void lostOwnership(Clipboard clipboard, Transferable contents) {
		this.data = null;
	}

}
