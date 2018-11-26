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
		int bUnit = 0;
		int eUnit = 0;
		int fUnit = 0;
		if(charFequencyMap.containsKey('B')){
			bUnit = charFequencyMap.get('B');
		}
		if(charFequencyMap.containsKey('E')){
			eUnit = (charFequencyMap.get('E') / 2);
		}
		if(charFequencyMap.containsKey('F')){
			fUnit = (charFequencyMap.get('F') / 2) + (charFequencyMap.get('F') % 2);
			charFequencyMap.put('f', fUnit );
		}
		
//		System.out.println("B >>> " +bUnit + " E >>> " + eUnit);
		if(eUnit >= 1 && bUnit >= 1){
			bUnit = ((bUnit >= eUnit) ? (bUnit - eUnit) : (eUnit - bUnit));
//			System.out.println("Final BUnit >>>> " + bUnit);
			charFequencyMap.put('B', bUnit );
		}
		for (Character key : charFequencyMap.keySet()) {
			int unit = charFequencyMap.get(key);
			switch (key) {
			case 'A':
				if (unit >= 3 && unit < 5) {
					int act = unit / 3;
					int mod = unit % 3;
					sum += (act * 130) + (mod * 50);
				} else if (unit >= 5) {
					int act5 = unit / 5;
					int mod5 = unit % 5;
					int act = mod5 / 3;
					int mod = mod5 % 3;
					sum += (act5 * 200) + (act * 130) + (mod * 50);
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
			case 'E':
				sum += ((unit < 1) ? 0 : (unit * 40));				
				break;
			case 'F':
				sum += ((unit < 1) ? 0 : (unit * 10));				
				break;
			default:
				return -1;
			}
		}
		System.out.println(skus + " >>>> " + sum+"\n");
		return sum;
	}

	public static void main(String [] args){
		CheckoutSolution cs = new CheckoutSolution();
		cs.checkout("A");
		cs.checkout("AA");
		cs.checkout("AAA");
		cs.checkout("AAAAA");
		cs.checkout("AAAAAA");
		cs.checkout("EE");
		cs.checkout("EEB");
		cs.checkout("EEEB");
		cs.checkout("EEBBBB");
		cs.checkout("EEEEBB");
	}
}
