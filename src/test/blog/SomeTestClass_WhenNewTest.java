package blog;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.spy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ SomeTestClass.class })
public class SomeTestClass_WhenNewTest {

	@Mock
	private MockTargetClass fieldName;

	@InjectMocks
	private SomeTestClass testSuite = spy(new SomeTestClass());

	@Test
	public void インスタンス生成でエラー発生した場合を確認() throws Exception {

		// 入力値
		String arg1 = "localParam";
		int arg2 = 200;

		// Mockの設定
		{
			MockitoAnnotations.initMocks(this);

			PowerMockito.whenNew(
					MockTargetClass.class).withNoArguments().thenThrow(
							new RuntimeException("error message"));
		}

		// 期待値
		String expected = "error message";

		// 検証
		try {
			testSuite.someMethod(arg1, arg2);
			fail("exception is not occur.");

		} catch (RuntimeException re) {
			assertEquals(expected, re.getMessage());
		}
	}
}
