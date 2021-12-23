
public class InjuredMine extends EmptySquare {
	private int value;
	private String hiddenSquare;
	
	public InjuredMine() {//constructor of an injured square
		this.value = 665; 
		this.hiddenSquare = "# ";
	}
	public String getHiddenSquare() {//an option to get the hidden value of the square
		return this.hiddenSquare;
	}
	public String setHiddenSquare(String hiddenSquare) {//an option to set the hidden value of the square
		return this.hiddenSquare = hiddenSquare;
	}
	public void showValue(EmptySquare[][] board,int row,int col) {//this function uncover the value of an injured square
		this.hiddenSquare = "IN";
	}
	public int getValue() {//an option to get the value of the square
		return value;
	}
	public String toString() {//this function prints the value of ingured mine
		return "IN";
	}
}
