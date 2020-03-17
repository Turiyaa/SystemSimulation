import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws VendingMachineException {
		int tickNumber = 0;
		System.out.print("Ticks " + tickNumber + " Input: ");
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		Model model = new Model();

		while (!input.equals("exit")) {
			model.lambda();
			model.delta(input);
			
			tickNumber++;
			System.out.print("\nTicks " + tickNumber + " Input: ");
			input = scan.nextLine();
		}
		scan.close();
	}
}
