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
	public void testChecout1(){
		Assert.assertEquals((50+30+20+15), Integer.valueOf(checkout.checkout("ABCD")).intValue());
	}
	@Test
	public void testChecout2(){
		Assert.assertEquals((130+30+20), Integer.valueOf(checkout.checkout("AAABC")).intValue());
	}
	@Test
	public void testChecout3(){
//		Assert.assertEquals((50+30+20+15), Integer.valueOf(checkout.checkout("ABCD")).intValue());
//		Assert.assertEquals((130+30+20), Integer.valueOf(checkout.checkout("AAABC")).intValue());
		Assert.assertEquals((50+45+20), Integer.valueOf(checkout.checkout("ABBC")).intValue());
	}
}
