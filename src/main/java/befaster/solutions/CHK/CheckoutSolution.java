package befaster.solutions.CHK;

import java.util.HashMap;


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
				if (unit >= 3) {
					int act = unit / 3;
					int mod = unit % 3;
					sum += (act * 130) + (mod * 50);
				} else {
					sum += ((unit < 1) ? 0 : (unit * 50));
				}
				break;
			case 'B': 
				if (unit >= 2) {
					int act = unit / 2;
					int mod = unit % 2;
					sum += (act * 45) + (mod * 30);
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
			}
		}
		System.out.println(skus+ " >>>> " + sum);
		return sum;
	}

	
}
