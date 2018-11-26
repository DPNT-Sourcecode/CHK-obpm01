package befaster.solutions.CHK;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class CheckoutSolutionTest {

	private CheckoutSolution checkout;
	
	@Before
	public void setUp(){
		checkout = new CheckoutSolution();
		
	}
	
	@Test
	public void testChecout(){
		Assert.assertEquals((50+30+20), Integer.valueOf(checkout.checkout("ABC")).intValue());
	}
}
