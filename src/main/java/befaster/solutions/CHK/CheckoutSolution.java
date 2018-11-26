package befaster.solutions.CHK;

import java.util.HashMap;

import befaster.runner.SolutionNotImplementedException;

public class CheckoutSolution {


	public Integer checkout(String skus) {
	 HashMap<Character, Integer> charFequencyMap = new HashMap<Character, Integer>();
		for (char c : skus.toCharArray()) {
			Integer value = charFequencyMap.get(c);
			if (value != null) {
				charFequencyMap.put(c, new Integer(value + 1));
			} else {
				charFequencyMap.put(c, 1);
			}
		}
		int sum = 0;
		for (Character key : charFequencyMap.keySet()) {
			int unit = charFequencyMap.get(key);
			switch (key) {
			case 'A': 
				if (unit == 3) {
//					System.out.println(">>> greater than three");					
					sum += 130;
				} else {
					sum += ((unit < 1) ? 0 : (unit * 50));
				}
				break;
			case 'B': 
				if (unit >= 2) {
					sum += 45;
				} else {
					sum += ((unit < 1) ? 0 : (unit * 30));
				}
				break;
			case 'C': 
				sum += ((unit < 1) ? 0 : (unit * 20));
				break;
			
			case 'D':  
				sum += ((unit < 1) ? 0 : (unit * 15));
				break;
				
			default:
				return -1;
//				break;
			}
		}
		System.out.println(skus + " >>>> " + sum);
		return sum;
	}


	

	public static void main(String[] args) {
		CheckoutSolution cks = new CheckoutSolution();
		cks.checkout("AAAABC");
		cks.checkout("");//, resp = 0
		cks.checkout("A");//, resp = 50
		cks.checkout("B");//, resp = 80
		cks.checkout("C");//, resp = 100
		cks.checkout("D");//, resp = 115
		cks.checkout("a");//, resp = -1
		cks. checkout("-");//, resp = -1
		cks.checkout("ABCa");//, resp = -1
		cks.checkout("AxA");//, resp = -1
		cks.checkout("ABCD");//, resp = -1
		cks.checkout("A");//, resp = -1
		cks.checkout("AA");//, resp = -1
		cks.checkout("AAA");//, resp = -1
		cks.checkout("AAAA");//, resp = -1
		cks.checkout("AAAAA");//, resp = -1
		cks. checkout("AAAAAA");//, resp = -1
		cks. checkout("B");//, resp = -1
		cks. checkout("BB");//, resp = -1
		cks. checkout("BBB");//, resp = -1
		cks.checkout("BBBB");//, resp = -1
		cks. checkout("ABCDABCD");//, resp = -1
		cks. checkout("BABDDCAC");//, resp = -1
		cks.checkout("AAABB");//, resp = -1
		cks.checkout("ABCDCBAABCABBAAA");//, resp = -1
		System.out.println("<>>>>");
	}
}
