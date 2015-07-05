package blog;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

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
public class SomeTestClass_StaticMethodTest {

	@Mock
	private MockTargetClass fieldName;

	@InjectMocks
	private SomeTestClass testSuite = spy(new SomeTestClass());

	@Test
	public void hogeをHOGEに変えてみる() {

		// Mockの設定
		{
			MockitoAnnotations.initMocks(this);

			PowerMockito.mockStatic(SomeTestClass.class);

			when(SomeTestClass.getHoge()).thenReturn("HOGE");
		}

		// 期待値
		String expected = "HOGE";

		// 検証
		String actual = SomeTestClass.getHoge();
		assertEquals(expected, actual);
	}
}
