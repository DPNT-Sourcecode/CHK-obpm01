package befaster.solutions.CHK;

import java.util.HashMap;

public class CheckoutSolution {

	private int applySimplePrizeDiscount(char item, int originalCost, int discountedCost, int bundleCount,
			HashMap<Character, Integer> charFequencyMap) {
		int currentItemUnitCount = charFequencyMap.get(item);
		int sum = 0;
		if (currentItemUnitCount >= bundleCount) {
			sum += ((currentItemUnitCount / bundleCount) * discountedCost)
					+ ((currentItemUnitCount % bundleCount) * originalCost);
		} else {
			sum += ((currentItemUnitCount < 1) ? 0 : (currentItemUnitCount * originalCost));
		}
		return sum;
	}

	private int applyComplexPrizeDiscount(char item, int originalCost, int lDiscountedCost, int uDiscountedCost,
			int lBundleCount, int uBundleCount, HashMap<Character, Integer> charFequencyMap) {
		int currentItemUnitCount = charFequencyMap.get(item);
		int sum = 0;
		if (currentItemUnitCount >= lBundleCount && currentItemUnitCount < uBundleCount) {
			sum += (currentItemUnitCount / lBundleCount * lDiscountedCost)
					+ (currentItemUnitCount % lBundleCount * originalCost);
		} else if (currentItemUnitCount >= uBundleCount) {
			sum += ((currentItemUnitCount / uBundleCount) * uDiscountedCost)
					+ (((currentItemUnitCount % uBundleCount) / lBundleCount) * lDiscountedCost)
					+ (((currentItemUnitCount % uBundleCount) % lBundleCount) * originalCost);
		} else {
			sum += ((currentItemUnitCount < 1) ? 0 : (currentItemUnitCount * originalCost));
		}
		return sum;
	}

	private void applyItemSwapDiscount(char item, char discountItem, int discountUnit,
			HashMap<Character, Integer> charFequencyMap) {
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

	private int applyGroupDiscount(int bundleCount, int discountedCost, HashMap<Character, Integer> charFequencyMap,
			char... groupMemberItems) {
		int totalGroupSize = 0;
		for (char c : groupMemberItems) {
			if (charFequencyMap.containsKey(c)) {
				totalGroupSize += charFequencyMap.get(c);
			}
		}

		int sub = totalGroupSize;
		for (char c : groupMemberItems) {
			if (charFequencyMap.containsKey(c)) {
				int currFre = charFequencyMap.get(c);
				if(sub > bundleCount && currFre < totalGroupSize){
					sub = totalGroupSize - currFre;			
					charFequencyMap.put(c, 0);		
				}else{
					break;
				}
			}
		}

		int sum = 0;
		if (totalGroupSize >= bundleCount) {
			sum += ((totalGroupSize / bundleCount) * discountedCost);
			// + ((totalGroupSize % bundleCount) * originalCost);
		}
		// else {
		// sum += ((totalGroupSize < 1) ? 0 : (totalGroupSize * originalCost));
		// }
		return sum;

	}

	private void applySelfSwapDiscount(char item, int discountUnit, HashMap<Character, Integer> charFequencyMap) {
		int cUnit = 0;
		int iUnitAct = 0;
		int iUnitMod = 0;
		if (charFequencyMap.containsKey(item)) {
			cUnit = charFequencyMap.get(item);
			if (cUnit >= discountUnit) {
				iUnitAct = (charFequencyMap.get(item) / discountUnit);
				iUnitMod = (charFequencyMap.get(item) % discountUnit);
				cUnit = (cUnit - iUnitAct) + ((iUnitMod == 0) ? 1 : 0);
				charFequencyMap.put(item, cUnit);
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
		applyItemSwapDiscount('E', 'B', 2, charFequencyMap);
		applyItemSwapDiscount('N', 'M', 3, charFequencyMap);
		applyItemSwapDiscount('R', 'Q', 3, charFequencyMap);
		applySelfSwapDiscount('F', 2, charFequencyMap);
		applySelfSwapDiscount('U', 3, charFequencyMap);

		totalSum += applyGroupDiscount(3, 45, charFequencyMap, 'S', 'T', 'X', 'Y', 'Z');

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
				totalSum += applySimplePrizeDiscount('K', 70, 120, 2, charFequencyMap);
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
				totalSum += applySimplePrizeDiscount('P', 50, 200, 5, charFequencyMap);
				break;
			case 'Q':
				totalSum += applySimplePrizeDiscount('Q', 30, 80, 3, charFequencyMap);
				break;
			case 'R':
				totalSum += ((currentItemUnitCount < 1) ? 0 : (currentItemUnitCount * 50));
				break;
			case 'S':
				totalSum += ((currentItemUnitCount < 1) ? 0 : (currentItemUnitCount * 20));
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
				totalSum += ((currentItemUnitCount < 1) ? 0 : (currentItemUnitCount * 17));
				break;
			case 'Y':
				totalSum += ((currentItemUnitCount < 1) ? 0 : (currentItemUnitCount * 20));
				break;
			case 'Z':
				totalSum += ((currentItemUnitCount < 1) ? 0 : (currentItemUnitCount * 21));
				break;
			default:
				return -1;
			}
		}
		System.out.println(skus + " >>>> " + totalSum + "\n");
		return totalSum;
	}

}
