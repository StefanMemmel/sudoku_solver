package sudokuSolver;

import java.util.Scanner;

public class App {

	private static Scanner scanner;

	public static void main(String[] args) {
/*
		System.out.println("This is commandline programm for solving sudokus ");
		System.out.println(
				"You have to enter your sudoku line by line. \n For empty cells please enter a zero (0). \n Don`t use blanks, just digits!");
		System.out.println("---- Ready? Let`s start! ----");
		//commandlineApp();*/
		test();
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
					matrix[index][c] = Integer.parseInt(String.valueOf(inputString.charAt(c)));  

				}
				index++;
			}
		} while (index < 9);
		System.out.println("The Sudoku you entered is:");
		Sudoku.getSolution(matrix);

		System.out.println("The solution of your sudoku is:");
		Sudoku.getSolution(Sudoku.getSolution(matrix));


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
 static void test() {
	 
	 int [][]schwer26Jan= {{0,4,0,2,3,0,7,0,0},{5,3,0,0,7,0,0,0,0},{0,0,1,4,0,0,6,0,0},{0,0,9,0,0,0,0,0,0},{0,0,0,6,0,8,0,0,2},{0,0,5,0,0,9,0,8,0},{7,0,2,0,0,0,0,0,8},{1,0,0,0,0,0,9,0,7},{0,5,0,3,0,7,0,6,1}};
//	 Sudoku.printSolution(Sudoku.getSolution(schwer26Jan));
int [][]Mittel= {{8,5,3,0,0,0,7,9,4},{0,0,9,0,4,0,0,0,0},{0,0,7,5,9,0,1,0,3},{0,0,0,4,1,0,0,6,9},{0,0,0,0,0,3,0,0,0},{3,1,5,0,2,9,0,0,7},{2,0,6,0,0,0,0,0,0},{0,0,0,0,7,6,0,0,0},{0,7,1,8,0,0,2,3,6} };
	 int [][]schwer= {{0,4,3,0,0,0,0,0,1},{0,0,6,0,3,0,7,0,0},{8,0,0,0,6,0,0,2,0}, {1,0,0,0,2,8,0,0,0}, {0,5,0,0,0,0,6,8,0},{0,0,0,0,0,9,0,1,0},{0,8,5,1,0,0,0,0,7},{0,0,0,0,0,4,0,0,0},{0,0,0,3,0,0,9,0,8}};
	 int [][]wikiExample = {{5,3,0,0,7,0,0,0,0},{6,0,0,1,9,5,0,0,0},{0,9,8,0,4,0,0,6,0},{8,0,0,0,6,0,0,0,3},{4,0,0,8,5,3,0,0,1},{7,0,0,0,2,0,0,0,6},{0,6,0,0,0,0,2,8,0},{0,0,0,4,1,9,0,0,5},{0,0,0,0,8,0,0,7,9}};
	 int [][]ursprungsProblem= {{0,4,3,0,0,0,0,0,0}, {0,0,6,0,3,0,7,0,0},{8,0,0,0,6,0,0,2,0,0},{1,0,0,0,2,8,0,0,0},{0,5,0,0,0,0,6,8,0},{0,0,0,0,0,9,0,1,0},{0,8,5,1,0,0,0,0,7},{0,0,0,0,0,4,0,0,0},{0,0,0,3,0,0,9,0,8}};
//		Sudoku.printSudoku(Sudoku.getSolution(wikiEx));
		System.out.println("---------------------------------------------");
		 
	 Sudoku.printSudoku(ursprungsProblem);
	 System.out.println("----------------------");
	 Sudoku.printSudoku(Sudoku.getSolution(ursprungsProblem));
	 /*
	  * 
	  
 Sudoku.getSolution(Sudoku.getSolution(schwer));
	Sudoku.printSudoku(Mittel);
	
	 System.out.println("---------------------------------------------");
	Sudoku.printSudoku(Sudoku.getSolution(Mittel));
	 System.out.println("-----------------------wikiEx----------------------");
		 Sudoku.printSudoku(wikiExample);
		 System.out.println("---------------------------------------------");
			Sudoku.printSudoku(Sudoku.getSolution(wikiExample));		
		*/
	//	Sudoku.printSudoku(Sudoku.getSolution(wikiEx));
 }
}