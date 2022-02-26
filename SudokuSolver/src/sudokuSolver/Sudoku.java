package sudokuSolver;

import java.awt.List;
import java.util.ArrayList;
import java.util.Stack;

import javax.sql.rowset.RowSetWarning;

public class Sudoku {
 
 
public Sudoku(){
	
}


private static ArrayList<int[]>  freeCells = new ArrayList<int[]>();



	public static int [][] getSolution(int[][] matrix) {
		// TODO Auto-generated method stub
		/*wrapper for the function solve*/ 
		
		 	return solve(matrix, 0); 	// the startDigit for the first blank =0; 
									//all digits are possible for the first blank	
	}
	
public static void printSudoku(int[][] matrix) {
		
		
		// TODO Auto-generated method stub

		for(int r=0; r<matrix[0].length;r++){
			for(int c=0; c<matrix[1].length;c++){ 
			System.out.print(matrix[r][c] +" ");	
				
			}		
			System.out.println();
		}
		
	}
	private static int[][] solve(int[][] matrix, int startDigit){

		int r_n, c_n, r_nminus1, c_nminus1;    
		boolean EmergencyExit =false; // realizes an EmergencyExit if the recursion is to deep for the current heap
		int	newDigit=startDigit;
	 
		while(findFirstZero(matrix)[0]!=-1 && EmergencyExit ==false){  // no 0 in the sudoku anymore
			
			r_n=findFirstZero(matrix)[0];
			c_n=findFirstZero(matrix)[1];
 
			do{		
				newDigit = getNumberFromBlock(get3Block(matrix, r_n, c_n),newDigit) ;  // hier ziehen aus Quadrat
				if(newDigit<=9){
				matrix[r_n][c_n]=newDigit;
				}else{
					r_nminus1= freeCells.get(freeCells.size()-1)[0];
					c_nminus1= freeCells.get(freeCells.size()-1)[1];
					freeCells.remove(freeCells.size()-1 ); //delete last element
				 
					 startDigit=matrix[r_nminus1][c_nminus1];
					 matrix[r_nminus1][c_nminus1]=0;  // set last cell =0
					matrix[r_n][c_n]=0;			
					EmergencyExit=true; // if the call of solve(m,s) fails the loop is broken
					try {
				 	matrix= solve(matrix,startDigit);
					}
					catch(StackOverflowError e) {			
						System.out.println("StackOverflowError - Increase the size of your heap "+ EmergencyExit +" ");						
					} 
			 
				}
				
			}while(rowAndColumnUnique(matrix, r_n, c_n)==false  && EmergencyExit ==false); 
			int cell[]={r_n, c_n};   
			freeCells.add(cell); //add current Element			 
			newDigit= 0; // start search for the digit in the next cell with newDigit=			
		}
		return matrix;
	}
	
	
	static int getNumberFromBlock(int[][] matrix, int startDigit){
		// Returns the lowest missing digit, that is greater then the startdigit
		// there is no check whether the digit is a number <=9, that has to be done in the calling function 
		int number =startDigit;
		int row= matrix[0].length;
		int column=matrix[1].length;
		
		boolean  FlagReturn=false;
	 	do{
			number++;
			FlagReturn=false;
			for(int r=0; r<row;r++){
				for(int c=0; c<column;c++){
					if(matrix[r][c]==number){
						FlagReturn=true; // go on with the next Number
						break;
					}
				}
			}
		  
		}while(FlagReturn);  //while(FlagReturn && digit <10 ); False Intension 
		return number;	
	}
	
	
	static int[][] get3Block(int[][] matrix, int row, int column){
 
		int [][]Block= new int [3][3];
		
		int rowStart= row - row%3; // decimal place behind the dot are cut off automatically 
		int columnStart = column - column %3;
		
		for(int r=0; r<3; r++){
			for(int c=0;c<3; c++ ){
				Block[r][c]=matrix[rowStart+r][columnStart+c];
			}
		}	
		return Block;		
	}
	
	
	static int [] findFirstZero(int[][] matrix){
		int result[]={0,0};
		for(int r=0; r<9;r++){
			boolean zero=false;
			for(int c=0; c<9;c++){
				if(matrix[r][c]==0){
					result[0]=r;
					result[1]=c;
					zero=true;
					break;
				}
			}
			if(zero==true){
				break;
			}
		if(matrix[8][8]!=0){
		result[0]=-1; result[1]=-1; //no zeros in the array
		}
		}
		return result;
	}
	
	/**
	 *  checks if the value of the cell (r,c) is unique in column and row
	 */
	
	private static boolean rowAndColumnUnique(int[][] matrix, int r, int c){
		
		for(int r_i=0; r_i < 9; r_i++){
			if(r_i!=r && matrix[r_i][c]!=0){
				if(matrix[r_i][c]==matrix[r][c]){
					return false;
				}
			}			
		}
		
		for(int c_i=0; c_i<9; c_i++){
			if(c_i!=c && matrix[r][c_i]!=0 ){
				if(matrix[r][c_i]==matrix[r][c]){
					return false;
				}
			}
		}	
		return true;
	}
 
}
