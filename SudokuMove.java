/*
 * This class stores sudoku moves
 * Becuase the only methods it contains are an initialiser and three getters,
 * it is not javadoc'd, since it is so simple
 * 
 * @author Casey Edmonds-Estes
 */
public class SudokuMove {
	int row = 0;
	int col = 0;
	int digit = 0;
	
	public SudokuMove(int row, int col, int digit) {
		this.row = row;
		this.col = col;
		this.digit = digit;
	}	
	
	public int getDigit() {
		return this.digit;
	}
	
	public int getCol() {
		return this.col;
	}
	
	public int getRow() {
		return this.row;
	}
}
