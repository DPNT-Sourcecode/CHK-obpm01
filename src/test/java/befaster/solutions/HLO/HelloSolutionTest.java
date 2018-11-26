package befaster.solutions.HLO;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class HelloSolutionTest {
	private HelloSolution hello;
	
	@Before
	public void setUp(){
		hello = new HelloSolution();
	}
	
	@Test
	public void checkHello(){
//		assertThat(hello.hello("Foo"), equals("Hello Foo"));
		Assert.assertEquals("Test failed", "Hello, Foo!", hello.hello("Foo"));
		
	}
}
