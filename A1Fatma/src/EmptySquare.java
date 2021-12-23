
public class EmptySquare {
	private int value; // each square contain value
	private String hiddenSquare; // each square show value to the player
	public EmptySquare() {//constructor of empty square
		value=0;
		hiddenSquare = "# ";
	}
	public int getValue() {//an option to get the value of the square
		return this.value;
	}
	public void setValue(int value) {//an option to set the value of the square
		this.value = value;
	}
	public String getHiddenSquare() { //an option to get the hidden value of the square
		return this.hiddenSquare;
	}
	public String setHiddenSquare(String hiddenSquare) {//an option to set the hidden value of the square
		return this.hiddenSquare = hiddenSquare;
	}
	public void showValue(EmptySquare[][] board, int row, int col) { //this function activate an empty squares and the numbers in the bounds
		if(row > 8 || row  < 0 || col > 8 || col < 0  || board[row][col].getHiddenSquare() != "# " && board[row][col].getHiddenSquare() != "& ") {
			return;
		}
		if(board[row][col].getValue() == 0) {
			board[row][col].setHiddenSquare("  ");
		}
		if(board[row][col].getValue() > 0) {
			board[row][col].setHiddenSquare(Integer.toString(board[row][col].getValue())+ " ");// update the value of the square
			return;
		}
		if(board[row][col].getValue() == 0) {
			showValue(board,row-1,col-1);
			showValue(board,row-1,col);
			showValue(board,row-1,col+1);
			showValue(board,row,col+1);
			showValue(board,row,col-1);
			showValue(board,row+1,col+1);
			showValue(board,row+1,col);
			showValue(board,row+1,col-1);
		}
	}
	public String toString() {	//this function prints the empty square
		return "  ";
	} 
}
