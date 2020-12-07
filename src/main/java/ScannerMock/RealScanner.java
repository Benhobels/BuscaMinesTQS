package ScannerMock;

import java.util.Scanner;

public class RealScanner implements IScanner {

	private Scanner sc = new Scanner(System.in);
	
	@Override
	public String nextLine() {
		return sc.nextLine();
	}

	
	
}
