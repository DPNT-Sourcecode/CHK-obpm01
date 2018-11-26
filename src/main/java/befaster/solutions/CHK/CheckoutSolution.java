package befaster.solutions.CHK;

import java.util.HashMap;

import befaster.runner.SolutionNotImplementedException;

public class CheckoutSolution {

	HashMap<Character, Integer> charFequencyMap = new HashMap<Character, Integer>();

	public Integer checkout(String skus) {        
		generateSKFrequence(skus);
		calculatePrizeTotal();
		return null;
    }
	
	private void generateSKFrequence(String skus){
		for(char c : skus.toCharArray()){
    		Integer value = charFequencyMap.get(c);
    		if(value != null){
    			charFequencyMap.put(c, new Integer(value + 1));
    		}else{
    			charFequencyMap.put(c, 1);
    		}
    	}
	}
	
	private void calculatePrizeTotal(){
		for(Character key : charFequencyMap.keySet()){
			System.out.println("key ==> " + key + " fequence ==> " + charFequencyMap.get(key));
			switch (key) {
			case 'A':
				if(charFequencyMap.get(key) > 3){
					System.out.println(">>> greater than three");
				}
				break;

			default:
				break;
			}
		}
	}
	
	public static void main (String[] args){
		CheckoutSolution cks = new CheckoutSolution();
		cks.generateSKFrequence("AAAABC");
		cks.calculatePrizeTotal();
		System.out.println("<>>>>");
	}
}
