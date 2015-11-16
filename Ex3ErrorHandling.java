public class Ex3ErrorHandling {
	
	public double requestUserInput() {
		boolean isInputCorrect = false;
		double output = 0;
		while(!isInputCorrect) {
			try {
				System.out.print("Enter number: ");
				String str = System.console().readLine();
				output = Integer.parseInt(str);
				isInputCorrect = true;
			} catch(NumberFormatException ex) {
				System.out.println("What you entered is not a number!");
			}
		}
		return output;
	}
	
	public double getMean() {
		System.out.println("How many numbers do you want to enter");
		int count = (int)requestUserInput();
		double total = 0;
		System.out.println("");
		for(int i = 0; i < count; i++) {
			double d = requestUserInput();
			total += d;
		}
		return (double)(total / count); 
	}
	
	public static void main(String[] args) {
		Ex3ErrorHandling ex3 = new Ex3ErrorHandling();
		ex3.launch();
	}
	
	public void launch() {
		double result = getMean();
		System.out.println(result);
	}
}