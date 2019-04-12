/*
 * This class solves sudoku puzzles using SudokuPuzzle and SudokuMove objects
 * 
 * @author Casey Edmonds-Estes
 */

import java.util.ArrayDeque;
import java.util.Deque;

public class SudokuSolver {
	SudokuPuzzle myPuzzle = null;
	Deque <SudokuMove> moveDeque= new ArrayDeque<SudokuMove>();
	SudokuMove holdMove = new SudokuMove(1,1,0);
	
	/*
	 * Makes a puzzle to solve
	 * 
	 * @param	filename	The name of the file with the unsolved puzzle
	 */
	public SudokuSolver(String filename) {
		myPuzzle = new SudokuPuzzle(filename);
	}
	
	/*
	 * Finds a valid number to imput
	 * 
	 * @param	row	The row where the move will be made
	 * @param	col The column where the move will be made
	 */
	private int moveFinder(int row, int col) {
		for (int i = myPuzzle.get(row, col); i <= 9; i++) {
				if (myPuzzle.isValid(row, col, i)) {
					return i;
				}
			}
		return 0;
	}
	
	public String toString() {
		String toPrint = "";
		for (int i = 0; i < 9; i ++) {
			for (int j = 0; j < 9; j++) {
				toPrint += " " + myPuzzle.get(i, j);
			}
			toPrint += "\n";	
		}
		return toPrint;
	}
	
	/*
	 * Solves a puzzle
	 * 
	 * @return	The solved puzzle
	 */
	public SudokuPuzzle solve() {
		for (int i = 0; i < 9; i ++) {
			for (int j = 0; j < 9; j++) {
				if (myPuzzle.get(i,j) == 0 | (i == holdMove.getRow() & j == holdMove.getCol())) {
					if (moveFinder(i, j) != 0) {
						moveDeque.push(new SudokuMove(i, j, moveFinder(i, j)));
						myPuzzle.makeMove(i, j, moveFinder(i, j));
					} else {
						holdMove = moveDeque.pop();
						myPuzzle.makeMove(i, j, 0);
						i = holdMove.getRow();
						j = holdMove.getCol();
						j-=1;
					}
				}
			}
		}
		
		return myPuzzle;
	}
}
