/*
 * Calls the other methods to actually pick and solve a puzzle
 * 
 * @author	Casey Edmonds-Estes
 */
import java.util.Scanner;

public class SudokuTest {
	
	public static void main(String [] args) {
		Scanner myScan = new Scanner(System.in);
		System.out.println("Please enter a filename: ");
		String filename = myScan.nextLine();
		System.out.println("If you want, you may also enter a solution file: ");
		String solutionFile = myScan.nextLine();
		System.out.println("Starting puzzle:");
		SudokuSolver mySolver = new SudokuSolver(filename);
		System.out.println(mySolver);
		System.out.println("Solved puzzle: ");
		System.out.println(mySolver.solve());
		try {
			SudokuPuzzle solution = new SudokuPuzzle(solutionFile);
			if (mySolver.solve().equals(solution)) {
				System.out.println("Solution is correct!");
			} else {
				System.out.println("Solution is incorrect.");
			}
		} catch(NullPointerException e)  {
			//do nothing, since there's no solution file to check
		}
	}
}
