package largeNumbers;

public class Driver {

	public static void main(String[] args) {
		BigNumber number1 = new BigNumber("-3");
		BigNumber number2 = new BigNumber("23");
		//System.out.println(number1.getNumber());
		String sum = number1.add(number2).getNumber();
		System.out.println(sum.replaceFirst("^0+(?!$)", ""));
	}

}
