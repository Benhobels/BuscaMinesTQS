package ScannerMock;

import java.util.ArrayList;
import java.util.List;

public class ScannerMock implements IScanner{
	
	private List<String> inputs = new ArrayList<>();
	
	public void addLine(String line) {
		inputs.add(line);
	}
	
	@Override
	public String nextLine() {
		String input = inputs.get(0);
		inputs.remove(0);
		return input;
	}

	
	
}
