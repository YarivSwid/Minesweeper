
public class FASquare extends EmptySquare{
	private int value;
	private String hiddenSquare;
	
	public FASquare() {//constructor of first aid square
		this.value = 102;
		this.hiddenSquare = "# ";
	}
	public void showValue(EmptySquare[][] board,int row,int col){//this function uncover the value of first aid square on the board
		this.hiddenSquare = "FA";
	}
	public int getValue() {//an option to get the value of the square
		return value;
	}
	public String setHiddenSquare(String hiddenSquare) {//an option to set the hidden value of the square
		return this.hiddenSquare = hiddenSquare;
	}
	public String getHiddenSquare() {//an option to get the hidden value of the square
		return this.hiddenSquare;
	}
	public String toString() {//this function prints the value of first aid square
		return "FA";
	}
}
