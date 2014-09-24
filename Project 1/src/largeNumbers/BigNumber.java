/**
 * 
 */
package largeNumbers;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author Eugene Fedotov
 *
 */
public class BigNumber {
	ArrayList<Integer> valArray = new ArrayList<Integer>();
	Boolean negative = false;
	
	BigNumber(String val)
	{
		char[] charArray = val.toCharArray();
		
		int n = charArray.length;
		
		for (int i = 0; i < n; i++) {
			int a = Character.getNumericValue(charArray[i]);
			if (Character.getNumericValue(charArray[0]) == -1) {
				negative = true;
				if (i == 0) {
					valArray.add(i, 9);
				} else {
					int temp = 9 - a;
					if ((n - 1) == i) {
						valArray.add(i, (temp + 1));
					} else {

						valArray.add(i, temp);
					}
				}

			} else {
				valArray.add(i, a);
			}
		}
		
		System.out.println(valArray);

	}
	
	BigNumber(ArrayList<Integer> val)
	{
		valArray = val;
		System.out.println(valArray);
	}
	
	String getNumber(){
		String sum = "";
		for (int x : valArray){
			sum += x;
		}
		return sum;
	}
	
	int getSize()
	{
		return valArray.size();
	}
	
	int getDigit(int i)
	{
		return valArray.get(i);
	}
	
	ArrayList<Integer> sumArray = new ArrayList<Integer>();
	ArrayList<Integer> carryArray = new ArrayList<Integer>();
	
	BigNumber add(BigNumber big)
	{
		ArrayList<Integer> array1 = reverse(valArray);
		ArrayList<Integer> array2 = reverse(big.valArray);
		int sum;
		int carry = 0;
		int shortest;
		int shortArray;
		if (array1.size() >= array2.size())
		{
			shortest = array2.size();
			shortArray = 2;
		}
		else{
			shortest = array1.size();
			shortArray = 1;
		}
		
		int diff = Math.abs(array2.size() - array1.size());
		for (int i = 0; i < shortest + 1; i++)
		{
			sumArray.add(0);
		}
		
		for (int i = 0; i < diff; i++)
		{
			if (shortArray == 2)
			{
				array2.add(shortest + i, 0);
			}
			else
			{
				array1.add(shortest + i, 0);
			}
		}
		
		for(int i = 0; i < array1.size(); i++)
		{
			sum = array1.get(i) + array2.get(i) + carry;
			if (sum >= 10)
			{
				sum = sum % 10;
				carry = 1;
			}
			else
			{
				carry = 0;
			}
			//System.out.println(sum);
			sumArray.set(i, sum);
		}
		if (carry == 1)
		{
			sumArray.set(shortest, 1);
		}
		
		return new BigNumber(reverse(sumArray));
	}
	
	ArrayList<Integer> reverse(ArrayList<Integer> val)
	{
		Collections.reverse(val);
		return val;
	}
}
