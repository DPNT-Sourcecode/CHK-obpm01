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
		int totalSum = 0;
		int bUnit = 0;
		int eUnit = 0;
		int fUnit = 0;
		int fUnitAct = 0;
		int fUnitMod = 0;
		if (charFequencyMap.containsKey('B')) {
			bUnit = charFequencyMap.get('B');
		}
		if (charFequencyMap.containsKey('E')) {
			eUnit = (charFequencyMap.get('E') / 2);
		}
		if (charFequencyMap.containsKey('F')) {
			fUnit = charFequencyMap.get('F');
			if (fUnit >= 3) {
				fUnitAct = (charFequencyMap.get('F') / 2);
			    fUnitMod = (charFequencyMap.get('F') % 2);
			    fUnit = fUnitAct + ((fUnitMod == 0) ? 1 : fUnitMod);
				charFequencyMap.put('F', fUnit);
			}
		}


		if (eUnit >= 1 && bUnit >= 1) {
			bUnit = ((bUnit >= eUnit) ? (bUnit - eUnit) : (eUnit - bUnit));
			charFequencyMap.put('B', bUnit);
		}
		for (Character key : charFequencyMap.keySet()) {
			int currentItemUnitCount = charFequencyMap.get(key);
			switch (key) {
			case 'A':
				if (currentItemUnitCount >= 3 && currentItemUnitCount < 5) {
					totalSum += (currentItemUnitCount / 3 * 130) + (currentItemUnitCount % 3 * 50);
				} else if (currentItemUnitCount >= 5) {
					totalSum += ((currentItemUnitCount / 5) * 200) + (((currentItemUnitCount % 5) / 3) * 130) + (((currentItemUnitCount % 5) % 3) * 50);
				} else {
					totalSum += ((currentItemUnitCount < 1) ? 0 : (currentItemUnitCount * 50));
				}
				break;
			case 'B':
				if (currentItemUnitCount >= 2) {
					totalSum += ((currentItemUnitCount / 2) * 45) + ((currentItemUnitCount % 2) * 30);
				} else {
					totalSum += ((currentItemUnitCount < 1) ? 0 : (currentItemUnitCount * 30));
				}
				break;
			case 'C':
				totalSum += ((currentItemUnitCount < 1) ? 0 : (currentItemUnitCount * 20));
				break;

			case 'D':
				totalSum += ((currentItemUnitCount < 1) ? 0 : (currentItemUnitCount * 15));
				break;
			case 'E':
				totalSum += ((currentItemUnitCount < 1) ? 0 : (currentItemUnitCount * 40));
				break;
			case 'F':
				totalSum += ((currentItemUnitCount < 1) ? 0 : (currentItemUnitCount * 10));
				break;
			case 'G':
				totalSum += ((currentItemUnitCount < 1) ? 0 : (currentItemUnitCount * 20));
				break;
			case 'H':
				if (currentItemUnitCount >= 5 && currentItemUnitCount < 10) {
					totalSum += (currentItemUnitCount / 5 * 45) + (currentItemUnitCount % 3 * 10);
				} else if (currentItemUnitCount >= 10) {
					totalSum += ((currentItemUnitCount / 10) * 80) + (((currentItemUnitCount % 10) / 5) * 45) + (((currentItemUnitCount % 10) % 5) * 10);
				} else {
					totalSum += ((currentItemUnitCount < 1) ? 0 : (currentItemUnitCount * 10));
				}
				break;
			case 'I':
				totalSum += ((currentItemUnitCount < 1) ? 0 : (currentItemUnitCount * 35));
				break;
			case 'J':
				totalSum += ((currentItemUnitCount < 1) ? 0 : (currentItemUnitCount * 60));
				break;
			case 'K':
				if (currentItemUnitCount >= 2) {
					totalSum += ((currentItemUnitCount / 2) * 150) + ((currentItemUnitCount % 2) * 80);
				} else {
					totalSum += ((currentItemUnitCount < 1) ? 0 : (currentItemUnitCount * 80));
				}
				break;
			case 'L':
				totalSum += ((currentItemUnitCount < 1) ? 0 : (currentItemUnitCount * 90));
				break;
			case 'M':
				totalSum += ((currentItemUnitCount < 1) ? 0 : (currentItemUnitCount * 15));
				break;
			case 'N':
				break;
			case 'O':
				totalSum += ((currentItemUnitCount < 1) ? 0 : (currentItemUnitCount * 10));
				break;
			case 'P':
				break;
			case 'Q':
				break;
			case 'R':
				break;
			case 'S':
				totalSum += ((currentItemUnitCount < 1) ? 0 : (currentItemUnitCount * 30));
				break;
			case 'T':
				totalSum += ((currentItemUnitCount < 1) ? 0 : (currentItemUnitCount * 20));
				break;
			case 'U':
				break;
			case 'V':
				break;
			case 'W':
				totalSum += ((currentItemUnitCount < 1) ? 0 : (currentItemUnitCount * 20));
				break;
			case 'X':
				totalSum += ((currentItemUnitCount < 1) ? 0 : (currentItemUnitCount * 90));
				break;
			case 'Y':
				totalSum += ((currentItemUnitCount < 1) ? 0 : (currentItemUnitCount * 10));
				break;
			case 'Z':
				totalSum += ((currentItemUnitCount < 1) ? 0 : (currentItemUnitCount * 50));
				break;
			default:
				return -1;
			}
		}
		System.out.println(skus + " >>>> " + totalSum + "\n");
		return totalSum;
	}

	public static void main(String[] args) {
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
		cs.checkout("FF");
		cs.checkout("FFF");
		cs.checkout("FFFF");
	}
}
