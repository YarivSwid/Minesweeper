
public class NumberSquare extends EmptySquare{
	private int value;
	private String hiddenSquare;
	public NumberSquare() {
		this.value = 0;
		this.hiddenSquare = "# ";
	}
	public int getValue() {//an option to get the value of the square
		return this.value;
	}
	public String getHiddenSquare() {//an option to get the hidden value of the square
		return this.hiddenSquare;
	}
	public String setHiddenSquare(String hiddenSquare) {//an option to set the hidden value of the square
		return this.hiddenSquare = hiddenSquare;
	}
	public void showValue(EmptySquare[][] board,int row,int col){//this function uncover the value of number square on the board
		this.hiddenSquare = Integer.toString(board[row][col].getValue()) + " ";
	}
	public void setValue(int value) {//an option to set the value of the square
		this.value = value;
	}
	public String toString() {//this function prints the value of numbered square
		return  value+" ";
	}
}
