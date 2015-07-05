package blog;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

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
public class SomeTestClass_LocalMethodTest {

	@Mock
	private MockTargetClass fieldName;

	@InjectMocks
	private SomeTestClass testSuite = PowerMockito.spy(new SomeTestClass());

	@Test
	public void local以外が付与されることを確認() throws Exception {

		// 入力値
		String arg1 = "firstParam";
		int arg2 = 100;

		// Mockの設定
		{
			MockitoAnnotations.initMocks(this);

			PowerMockito.doReturn("not local:"+arg1).when(testSuite, "addLocal", "firstParam");
		}

		// 期待値
		String expected = "not local:firstParam";

		// 検証
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		PrintStream old = System.out;
		System.setOut(ps);

		testSuite.someMethod(arg1, arg2);

	    System.out.flush();
	    System.setOut(old);

	    String actual = baos.toString().replaceAll(System.getProperty("line.separator"), "");

	    assertEquals(expected, actual);
	}
}
