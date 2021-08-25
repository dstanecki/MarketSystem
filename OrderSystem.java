package midterm;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class OrderSystem {

	public static void main(String[] args) {

		//System.out.println("Welcome to the Northwoods Whole Sale Market System");
		String another = "y";
		int count = 1;
		String finalOutput = "";
		while (another.equals("y")) {
			String items = "";
			System.out.println("Enter your name: ");
			Scanner scan = new Scanner(System.in);
			String name = scan.nextLine();
			String ans = "y";

			double sum = 0;

			while (ans.equals("y")) {
				Scanner scanP = new Scanner(System.in);
				System.out.println("Enter product: ");
				String product = scanP.nextLine();

				Scanner scan2 = new Scanner(System.in);

				System.out.println("Enter quantity: ");
				int quant = scan2.nextInt();

				switch (product) {
				case "bananas":
					sum += (quant * 0.49);
					items += "bananas($" + (quant*0.49) + ") ";
					break;
				case "toilet tissue":
					sum += (quant * 1.50);
					items += "toilet tissue($" + (quant*1.50) + ") ";
					break;
				case "skim milk":
					sum += (quant * 3.00);
					items += "skim milk($" + (quant*3.00) + ") ";
					break;
				case "canned tuna":
					sum += (quant * 1.50);
					items += "canned tuna($" + (quant*1.50) + ") ";
					break;
				case "roma tomatoes":
					sum += (quant * 1);
					items += "roma tomatoes($" + (quant*1) + ") ";
					break;
				case "laundry detergent":
					sum += (quant * 92.5);
					items += "laundry detergent($" + (quant*92.5) + ") ";
					break;
				case "cottage cheese":
					sum += (quant * 2.00);
					items += "cottage cheese($" + (quant*2.00) + ") ";
					break;
				case "chicken breast":
					sum += (quant * 0.95);
					items += "chicken breast($" + (quant*0.95) + ") ";
					break;
				case "facial tissue":
					sum += (quant * 4.00);
					items += "facial tissue($" + (quant*4.00) + ") ";
					break;
				case "french bread":
					sum += (quant * 2.00);
					items += "french bread($" + (quant*2.00) + ") ";
					break;
				case "green grapes":
					sum += (quant * 3.00);
					items += "green grapes($" + (quant*3.00) + ") ";
					break;
				case "whole milk":
					sum += (quant * 3.00);
					items += "whole milk($" + (quant*3.00) + ") ";
					break;
				case "sink cleanser":
					sum += (quant * 0.90);
					items += "sink cleanser($" + (quant*0.90) + ") ";
					break;
				case "real whip cream":
					sum += (quant * 1.65);
					items += "real whip cream($" + (quant*1.65) + ") ";
					break;
				case "lettuce":
					sum += (quant * 0.80);
					items += "lettuce($" + (quant*0.80) + ") ";
					break;
				case "hamburger buns":
					sum += (quant * 2.89);
					items += "hamburger buns($" + (quant*2.89) + ") ";
					break;
				case "ground beef":
					sum += (quant * 1.90);
					items += "ground beef($" + (quant*1.90) + ") ";
					break;
				case "carrots":
					sum += (quant * .80);
					items += "carrots($" + (quant*0.80) + ") ";
					break;
				case "croissants":
					sum += (quant * 4.00);
					items += "croissants($" + (quant*4.00) + ") ";
					break;
				case "round steak":
					sum += (quant * 3.50);
					items += "round steak($" + (quant*3.50) + ") ";
					break;
				case "paper towels":
					sum += (quant * 2.0);
					items += "paper towels($" + (quant*2.0) + ") ";
					break;
				case "beefsteak tomatoes":
					sum += (quant * 1.75);
					items += "beefsteak tomatoes($" + (quant*1.75) + ") ";
					break;
				case "campbell's chicken soup":
					sum += (quant * 4.75);
					items += "campbell's chicken soup($" + (quant*4.75) + ") ";
					break;
				case "disinfectant":
					sum += (quant * 9.5);
					items += "disinfectant($" + (quant*9.5) + ") ";
					break;
				default:
					System.out.println("Product not valid or not available.");
					break;
				}
				System.out.println("Would you like to add another item? (y/n): ");
				Scanner scan3 = new Scanner(System.in);
				ans = scan3.next();
			}
			double tax = 0;
			Scanner scan4 = new Scanner(System.in);
			System.out.println("Enter your sales tax: ");
			tax = scan4.nextDouble();
			double pretaxSum = sum;
			DecimalFormat df = new DecimalFormat("#.00");
			//df.format(pretaxSum);
			double taxOnSum = sum*(tax/100);
			sum += sum * (tax/100);

			String delivery = "";
			Scanner scan5 = new Scanner(System.in);
			System.out.println("Choose delivery options of: pickup, 2 hours, next day, in 2 days, and in one week: ");
			delivery = scan5.next();

			Scanner scan6 = new Scanner(System.in);
			String discount = "";
			System.out.println("Is this a student, senior, birthday, or corporate order? Enter n for none.");
			discount = scan6.next();

			switch (discount) {
			case "student":
				sum -= sum * .1;
				pretaxSum -= sum * .1;
				break;
			case "senior":
				sum -= sum * .2;
				pretaxSum -= sum *.2;
				break;
			case "birthday":
				sum -= sum * .15;
				pretaxSum -= sum *.15;
				break;
			case "corporate":
				if (sum > 2000) {
					sum -= sum * .25;
					pretaxSum -= sum*.25;
				}
				break;
			default:
				break;
			}
			
			df.format(pretaxSum);
			df.format(taxOnSum);
			df.format(sum);
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Date date = new Date();
			String output = "\nName: " + name + "\nDate: " + dateFormat.format(date) + "\nItems: " + items + "\nTotal: $" + pretaxSum + "\nTax: $" + taxOnSum + "\nGrand Total: $" + sum + "\n";
			finalOutput += output;
			Scanner scan9 = new Scanner(System.in);
			System.out.println("Would you like to enter another order? y/n: ");
			another = scan9.next();
			
			count ++;
		}
		System.out.println("Welcome to the Northwoods Whole Sale Market System.\n");
		System.out.println(finalOutput);
	}
}
