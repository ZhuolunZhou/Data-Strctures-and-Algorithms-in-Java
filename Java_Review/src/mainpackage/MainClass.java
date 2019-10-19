package mainpackage;
import java.util.Scanner;

public class MainClass {
	static Scanner reader = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("Hello");
		String name = reader.nextLine();
		System.out.println("My name is " + name);
		double salary = reader.nextDouble();
		
		//String input = reader.nextLine();
	}
}
