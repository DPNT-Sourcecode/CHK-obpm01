package befaster.solutions.CHK;

import java.util.HashMap;

import befaster.runner.SolutionNotImplementedException;

public class CheckoutSolution {

	HashMap<Character, Integer> charFequencyMap = new HashMap<Character, Integer>();

	public Integer checkout(String skus) {
		for (char c : skus.toCharArray()) {
			Integer value = charFequencyMap.get(c);
			if (value != null) {
				charFequencyMap.put(c, new Integer(value + 1));
			} else {
				charFequencyMap.put(c, 1);
			}
		}
		return calculatePrizeTotal();
	}


	private int calculatePrizeTotal() {
		int sum = 0;
		for (Character key : charFequencyMap.keySet()) {
			int unit = charFequencyMap.get(key);
			switch (key) {
			case 'A': case 'a':
				if (unit >= 3) {
//					System.out.println(">>> greater than three");
					int act = unit / 3;
					int mod = unit % 3;
					sum += (act * 130) + (mod * 50);
				} else {
					sum += ((unit < 1) ? 0 : (unit * 50));
				}
				break;
			case 'B':  case 'b':
				if (unit >= 2) {
					int act = unit / 2;
					int mod = unit % 2;
					sum += (act * 45) + (mod * 30);
				} else {
					sum += ((unit < 1) ? 0 : (unit * 30));
				}
				break;
			case 'C':  case 'c':
				sum += ((unit < 1) ? 0 : (unit * 20));
				break;
			
			case 'D':  case 'd':
				sum += ((unit < 1) ? 0 : (unit * 15));
				break;
				
			default:
				return -1;
//				break;
			}
		}
		return sum;
	}

	public static void main(String[] args) {
		CheckoutSolution cks = new CheckoutSolution();
		cks.checkout("AAAABC");
		System.out.println("<>>>>");
	}
}
