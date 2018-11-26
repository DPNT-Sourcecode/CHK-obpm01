package befaster.solutions.CHK;

import java.util.HashMap;

public class CheckoutSolution {

	private int  applySimplePrizeDiscount(char item, int originalCost, int discountedCost, int bundleCount, HashMap<Character, Integer> charFequencyMap){
		int currentItemUnitCount = charFequencyMap.get(item);
		int sum = 0;
		if (currentItemUnitCount >= bundleCount) {
			sum += ((currentItemUnitCount / bundleCount) * discountedCost) + ((currentItemUnitCount % bundleCount) * originalCost);
		} else {
			sum += ((currentItemUnitCount < 1) ? 0 : (currentItemUnitCount * originalCost));
		}
		return sum;
	}
	
	private int  applyComplexPrizeDiscount(char item, int originalCost, int lDiscountedCost,int uDiscountedCost, int lBundleCount, int uBundleCount, HashMap<Character, Integer> charFequencyMap){
		int currentItemUnitCount = charFequencyMap.get(item);
		int sum = 0;
		if (currentItemUnitCount >= lBundleCount && currentItemUnitCount < uBundleCount) {
			sum += (currentItemUnitCount / lBundleCount * lDiscountedCost) + (currentItemUnitCount % lBundleCount * originalCost);
		} else if (currentItemUnitCount >= uBundleCount) {
			sum += ((currentItemUnitCount / uBundleCount) * uDiscountedCost) + (((currentItemUnitCount % uBundleCount) / lBundleCount) * lDiscountedCost) + (((currentItemUnitCount % uBundleCount) % lBundleCount) * originalCost);
		} else {
			sum += ((currentItemUnitCount < 1) ? 0 : (currentItemUnitCount * originalCost));
		}
		return sum;
	}
	
	private void applyItemSwapDiscount(char item, char discountItem, int discountUnit, HashMap<Character, Integer> charFequencyMap){
		int finalUnit = 0;
		int eUnit = 0;
		
		if (charFequencyMap.containsKey(discountItem)) {
			finalUnit = charFequencyMap.get(discountItem);
		}
		if (charFequencyMap.containsKey(item)) {
			eUnit = (charFequencyMap.get(item) / discountUnit);
		}
		if (eUnit >= 1 && finalUnit >= 1) {
			finalUnit = ((finalUnit >= eUnit) ? (finalUnit - eUnit) : (eUnit - finalUnit));
			charFequencyMap.put(discountItem, finalUnit);
		}
	}
	
	private void applySelfSwapDiscount(char item,int discountUnit, HashMap<Character, Integer> charFequencyMap){
		int finalUnit = 0;
		int iUnitAct = 0;
		int iUnitMod = 0;
		if (charFequencyMap.containsKey(item)) {
			finalUnit = charFequencyMap.get(item);
			if (finalUnit >= (discountUnit + 1)) {
				iUnitAct = (charFequencyMap.get(item) / discountUnit);
			    iUnitMod = (charFequencyMap.get(item) % discountUnit);
			    finalUnit = (iUnitAct + ((iUnitMod == 0) ? 1 : iUnitMod));
				charFequencyMap.put(item, finalUnit);
			}
		}
	}
	
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
		applyItemSwapDiscount('E', 'B', 2,  charFequencyMap);
		applyItemSwapDiscount('N', 'M', 3,  charFequencyMap);
		applyItemSwapDiscount('R', 'Q', 3,  charFequencyMap);
		applySelfSwapDiscount('F', 2, charFequencyMap);
		applySelfSwapDiscount('U', 3, charFequencyMap);
		
//		int fUnit = 0;
//		int fUnitAct = 0;
//		int fUnitMod = 0;
//		if (charFequencyMap.containsKey('F')) {
//			fUnit = charFequencyMap.get('F');
//			if (fUnit >= 3) {
//				fUnitAct = (charFequencyMap.get('F') / 2);
//			    fUnitMod = (charFequencyMap.get('F') % 2);
//			    fUnit = fUnitAct + ((fUnitMod == 0) ? 1 : fUnitMod);
//				charFequencyMap.put('F', fUnit);
//			}
//		}

		for (Character key : charFequencyMap.keySet()) {
			int currentItemUnitCount = charFequencyMap.get(key);
			switch (key) {
			case 'A':
				totalSum += applyComplexPrizeDiscount('A', 50, 130, 200, 3, 5, charFequencyMap);
				break;
			case 'B':
				totalSum += applySimplePrizeDiscount('B', 30, 45, 2, charFequencyMap);
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
				totalSum += applyComplexPrizeDiscount('H', 10, 45, 80, 5, 10, charFequencyMap);
				break;
			case 'I':
				totalSum += ((currentItemUnitCount < 1) ? 0 : (currentItemUnitCount * 35));
				break;
			case 'J':
				totalSum += ((currentItemUnitCount < 1) ? 0 : (currentItemUnitCount * 60));
				break;
			case 'K':
				totalSum += applySimplePrizeDiscount('K', 80, 150, 2, charFequencyMap);
				break;
			case 'L':
				totalSum += ((currentItemUnitCount < 1) ? 0 : (currentItemUnitCount * 90));
				break;
			case 'M':
				totalSum += ((currentItemUnitCount < 1) ? 0 : (currentItemUnitCount * 15));
				break;
			case 'N':
				totalSum += ((currentItemUnitCount < 1) ? 0 : (currentItemUnitCount * 40));
				break;
			case 'O':
				totalSum += ((currentItemUnitCount < 1) ? 0 : (currentItemUnitCount * 10));
				break;
			case 'P':
				totalSum +=  applySimplePrizeDiscount('P', 50, 200, 5, charFequencyMap);
				break;
			case 'Q':
				totalSum += applySimplePrizeDiscount('Q', 30, 80, 3, charFequencyMap);
				break;
			case 'R':
				totalSum += ((currentItemUnitCount < 1) ? 0 : (currentItemUnitCount * 50));
				break;
			case 'S':
				totalSum += ((currentItemUnitCount < 1) ? 0 : (currentItemUnitCount * 30));
				break;
			case 'T':
				totalSum += ((currentItemUnitCount < 1) ? 0 : (currentItemUnitCount * 20));
				break;
			case 'U':
				totalSum += ((currentItemUnitCount < 1) ? 0 : (currentItemUnitCount * 40));
				break;
			case 'V':
				totalSum += applyComplexPrizeDiscount('V', 50, 90, 130, 2, 3, charFequencyMap);
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
//		cs.checkout("A");
//		cs.checkout("AA");
//		cs.checkout("AAA");
//		cs.checkout("AAAAA");
//		cs.checkout("AAAAAA");
//		cs.checkout("EE");
//		cs.checkout("EEB");
//		cs.checkout("EEEB");
//		cs.checkout("EEBBBB");
//		cs.checkout("EEEEBB");
//		cs.checkout("F");
//		cs.checkout("FF");
//		cs.checkout("FFF");
//		cs.checkout("FFFF");
//		cs.checkout("U");
//		cs.checkout("UU");
		cs.checkout("UUU");
		cs.checkout("UUUU");
		cs.checkout("UUUUU");
		cs.checkout("UUUUUUUU");
//		cs.checkout("Q");
//		cs.checkout("QQ");
//		cs.checkout("QQQ");
//		cs.checkout("QQQQ");
//		cs.checkout("QQQQQ");
//		cs.checkout("QQQQQQ");
	}
}
