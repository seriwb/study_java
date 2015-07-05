package blog;

import org.springframework.stereotype.Component;

@Component
public class MockTargetClass {

	public String someProcess(String arg1, int arg2) {

		return "No implementation";
	}
}
