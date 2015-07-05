package blog;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.internal.util.reflection.Whitebox;

public class SomeTestClass_SomeMethodTest {

	@Mock
	private MockTargetClass fieldName;

	@InjectMocks
	private SomeTestClass testSuite = spy(new SomeTestClass());

	@Test
	public void OKが返却されることを確認() {

		// 入力値
		String arg1 = "firstParam";
		int arg2 = 100;

		// Mockの設定
		{
			MockitoAnnotations.initMocks(this);

			// fieldName#someProcess(String, int)をモックする
			// fieldName.someProcess("firstParam", 100)を実行した際に"OK"の文字列を返却する例
			doReturn("OK").when(fieldName).someProcess("firstParam", 100);
			// どんなパラメータで呼ばれても"OK"を返す場合は以下のように書く
			//		doReturn("OK").when(fieldName).someProcess(anyString(), anyInt());

			// testSuiteのsomeFieldに、fieldNameの値を設定する
			// setInternalStateのパラメータは
			// リフレクション対象クラス、リフレクション対象のフィールド名、リフレクションで設定するフィールド、の順
			Whitebox.setInternalState(testSuite, "someField", fieldName);
		}

		// 期待値
		String expected = "OK";

		// 検証
		String actual = testSuite.someMethod(arg1, arg2);
		assertEquals(expected, actual);
	}
}
