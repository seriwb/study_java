package blog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class SomeTestClass {

	@Autowired
	@Qualifier("mockTargetClass")
	private MockTargetClass someField;

	public static String getHoge() { return "hoge"; }

	public String someMethod(String arg1, int arg2) {

		System.out.println(addLocal(arg1));

		if ("localParam".equals(arg1)) {
			someField = new MockTargetClass();
		}

		return someField.someProcess(arg1, arg2);
	}

	private String addLocal(String str) {

		return "local:" + str;
	}
}
