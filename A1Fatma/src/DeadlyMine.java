
public class DeadlyMine extends EmptySquare{
	private int value;
	private String hiddenSquare;
	public DeadlyMine() {//constructor of deadly mine
		this.value = 666;
		this.hiddenSquare = "# ";
	}
	public void showValue(EmptySquare[][] board,int row,int col){//this function will activate the value of deadly mine on the board
		this.hiddenSquare = "X ";
	}
	public int getValue() {//an option to get the value of the square
		return value;
	}
	public String setHiddenSquare(String hiddenSquare) {//an option to set the hidden value of the square
		return this.hiddenSquare = hiddenSquare ;
	}
	public String getHiddenSquare() {//an option to get the hidden value of the square
		return this.hiddenSquare;
	}
	public String toString() {//this function prints the value of deadly mine
		return "X ";
	}
}
