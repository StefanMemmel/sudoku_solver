package sudokuSolver;

import java.util.Scanner;

public class App {

	private static Scanner scanner;

	public static void main(String[] args) {

		System.out.println("This is commandline programm for solving sudokus ");
		System.out.println(
				"You have to enter your sudoku line by line. \n For empty cells please enter a zero (0). \n Don`t use blanks, just digits!");
		System.out.println("---- Ready? Let`s start! ----");
		commandlineApp();
	}

	private static void commandlineApp() {

		int[][] matrix = new int[9][9];

		scanner = new Scanner(System.in);
		String inputString = null;
		int index = 0;
		do {
			System.out.println(
					"Please enter the " + (index + 1) + ". line of your sudoku. For the unknown digit enter a 0");
			inputString = scanner.nextLine();
			if (isAccepted(inputString)) {
				for (int c = 0; c < 9; c++) {
					matrix[index][c] = Integer.parseInt(String.valueOf(inputString.charAt(c))); // (int)
																								// inputString.charAt(index)-16;
																								// //ASCII

				}
				index++;
			}
		} while (index < 9);
		System.out.println("The Sudoku you entered is:");
		Sudoku.printSolution(matrix);

		System.out.println("The solution of your sudoku is:");
		Sudoku.printSolution(Sudoku.solvePrepare(matrix));

	}

	private static boolean isAccepted(String inputString) {

		if (inputString.length() == 9) {

			try {
				int test = Integer.parseInt(inputString);

			} catch (NumberFormatException e) {
				System.out.println("You have entered an invalid character.");
				return false;

			}

			return true;
		} else {
			System.out.println("Please enter exactly 9 digits!");
		}

		return false;
	}

}