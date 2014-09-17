/**
 * 
 */
package largeNumbers;

import java.util.ArrayList;

/**
 * @author Eugene Fedotov
 *
 */
public class BigNumber {
	char[] charArray = {};
	ArrayList<Integer> number = new ArrayList<>();	
	
	BigNumber(String val){
		charArray = val.toCharArray();
		for (char ch: charArray) {
			int a = Character.getNumericValue(ch);
			number.add(a);
		}
	}
	
	ArrayList<Integer> getNumber(){
		return number;
	}
}