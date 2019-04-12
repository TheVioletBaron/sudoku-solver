/*
 * This class creates and stores sudoku puzzles
 * It can also make changes to them, and verify the legality of potential moves
 * 
 * @author Casey Edmonds-Estes
 */

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SudokuPuzzle {

	int [][] puzzle = new int [9] [9];
	
	/*
	 * Reads a file into a string
	 * 
	 * @param	filename	The name of the file to be read
	 * @return	The string
	 */
	private static String readFileAsString(String filename) {
		try {
				return new String(Files.readAllBytes(Paths.get(filename)));
			} catch (IOException e) {
				return null;
			}
	}

	/*
	 * Creates a SudokuPuzzle object
	 * 
	 * @param	filename	The filename of the file containing the puzzle
	 */
	public SudokuPuzzle(String filename) {
		String puzzleString = readFileAsString(filename);
		int stringIndex = 0;
		for (int i = 0; i < 9; i ++) {
			for (int j = 0; j < 9; j++) {
				if (puzzleString.charAt(stringIndex) == '0') 
				{
					puzzle[i][j] = 0;
				} else {
					puzzle[i][j] = Character.getNumericValue(puzzleString.charAt(stringIndex));
				}
				stringIndex += 2;
			}
		}
	}
	/*
	 * Makes a move
	 * 
	 * @param	i	The x coordinate of the move
	 * @param	j	The y coordinate of the move
	 * @param	num	The number to be imput
	 */
	public void makeMove(int i, int j, int num) {
		this.puzzle[i][j] = num;
	}
	
	/*
	 * Gets a value
	 * 
	 * @param	i	The x coordinate of the move
	 * @param	j	The y coordinate of the move
	 */
	public int get(int i, int j) {
		return this.puzzle[i][j];
	}
	
	public String toString() {
		String toPrint = "";
		for (int i = 0; i < 9; i ++) {
			for (int j = 0; j < 9; j++) {
				toPrint += " " + this.puzzle[i][j];
			}
			toPrint += "\n";	
		}
		return toPrint;
	}
	
	/*
	 * Checks the validity of a move
	 * 
	 * @param	i	The x coordinate of the move
	 * @param	j	The y coordinate of the move
	 * @param	num	The number to be checked
	 */
	public Boolean isValid(int row, int col, int num) {
		Boolean isValid = true;
		for (int i = 0; i < 9; i ++) {
			if (this.puzzle[row][i] == num) {
				isValid = false;
			}
			if (this.puzzle[i][col] == num) {
				isValid = false;
			}
		}
		int boxRow = row - (row % 3);
		int boxCol = col - (col % 3);
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (this.puzzle[boxRow + i][boxCol + j] == num) {
					isValid = false;
				}
			}
		}
		return isValid;
	}
	
	/*
	 * Checks whether two puzzles are equal
	 * 
	 * @param	puzzle	The puzzle to check against
	 * @return	Whether the puzzle is valid
	 */
	public Boolean equals(SudokuPuzzle puzzle) {
		Boolean isValid = true;
		for (int i = 0; i < 9; i ++) {
			for (int j = 0; j < 9; j++) {
				if (this.puzzle[i][j] != puzzle.get(i, j)) {
					isValid = false;
				}
			}	
		}
		return isValid;
	}
}
