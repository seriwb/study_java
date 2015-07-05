package blog;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * SomeTestClassのテストスイート。<br>
 * SomeTestClassのテストをメソッド単位でテストクラスを作成し、SuiteClassesに追加すること。<br>
 *
 * 作成するテストクラスは「SomeTestClass_ + メソッド名（先頭大文字） + Test」という名前にする。
 *
 * @author seri
 */
@RunWith(Suite.class)
@SuiteClasses({
	SomeTestClass_SomeMethodTest.class,
	SomeTestClass_StaticMethodTest.class,
	SomeTestClass_WhenNewTest.class,
	SomeTestClass_LocalMethodTest.class,
})
public class SomeTestClassAllTest {
}
