import java.util.HashMap;
import java.util.Scanner;

public class Main {

	private static Scanner scn;

	public static void main(String[] args) {
		scn = new Scanner(System.in);
		System.out.println("Please type a string: ");
		String inputString = scn.nextLine();
		if(inputString!=null) {
			StringFormatter strForm = new StringFormatter(inputString);
			strForm.toWord();
		}
		else scn.close();
	}

}
