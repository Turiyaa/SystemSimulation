package vm;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws VendingMachineException, NumberFormatException, IOException {
		Model model = new Model();
		char coin = 0;
		double prevtr = 0;
		double realTime = 0;
		double elapsedTime = 0;

		Scanner scan = new Scanner(System.in);
		BufferedReader br = null;
		String batchFile;
		System.out.print("Enter file name\t: ");
		batchFile = scan.next();
		FileReader fr = new FileReader(batchFile);
		br = new BufferedReader(fr);

		String line;
		while ((line = br.readLine()) != null) {
			double ta = model.timeAdvance();

			String[] strs = line.trim().split("\\s+");
			if (!(strs.length == 1)) {
				realTime = Double.parseDouble(strs[0]);
				coin = strs[1].charAt(0);

			} else {
				coin = 'x';
				if (ta != Double.POSITIVE_INFINITY)
					realTime += ta;
			}
			System.out.print(realTime +" ");

			System.out.println(model);

			elapsedTime = model.format(realTime - prevtr);

			if (elapsedTime == ta && (coin == 'q' || coin == 'd' || coin == 'n')) {
				model.deltacon(coin);
			} else if (coin == 'q' || coin == 'd' || coin == 'n') {
				model.deltaext(coin);
			} else if (elapsedTime == ta) {
				model.deltaint();
			}
			prevtr = realTime;
		}
		System.out.print(realTime +" ");

		System.out.println(model);

		if (model.timeAdvance() == 2)
			model.deltaint();
		
		scan.close();
		br.close();

	}
}