
public class Board {
	private final int row  = 9;// the number of rows in the board
	private final int col = 9;// the number of columns in the board
	private EmptySquare[][] board;
	
	public Board(EmptySquare[][] board) {//constructor of a board
		this.board= board;
	}
	public Board clone(){// copy constructor - clone
		return new Board( this.board );
	}
	public void placeNums(EmptySquare[][] board,int row,int col) { // this function place numbers on the board according to the game laws
		for(int i = 0; i < row ; i++) {
			for(int j = 0; j < col; j++) {
				if(board[i][j].getValue() < 9 ) {//if this square is an active one, the function will increase by one the value of the squares around it
					int counter = 0;
					if(i != 0 && board[i-1][j].getValue() > 9) {
						counter++;
					}
					if(i != 8 && board[i+1][j].getValue() > 9) {
						counter++;
					}
					if(j != 0 && board[i][j-1].getValue() > 9) {
						counter++;
					}
					if(j != 8 && board[i][j+1].getValue() > 9) {
						counter++;
					}
					if(i-1 >= 0 && j-1 >= 0 && board[i-1][j-1].getValue() > 9) {
						counter++;
					}
					if(i-1 >= 0 && j+1 <= 8 && board[i-1][j+1].getValue() > 9) {
						counter++;
					}
					if(i+1 <= 8 && j-1 >= 0 && board[i+1][j-1].getValue() > 9) {
						counter++;
					}
					if(i+1 <= 8 && j+1 <= 8 && board[i+1][j+1].getValue() > 9) {
						counter++;
					}
					if(counter > 0) {
						board[i][j]= new NumberSquare();
						board[i][j].setValue(counter) ;
					}
				}
			}
		}
	}
	public void placeMines(EmptySquare[][] board) { // this function place mines randomly by a mathematical algorithm
		double placeOrNot; // help variable to use an algorithm to place mines on the board
		double cubes = 81; // the numbers of squares on the board
		double mines = 10; //the number of active squares that we will place
		double probability; // probability to place mine
		int DeadlyMines = 4;//maximum number of deadly mines
		int InguredlyMines = 4;//maximum number of injured mines
		int FASquare = 4;//maximum number of first aid squares
		double placeActiveSquare;
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				placeOrNot = Math.random();
				probability = mines/cubes;
				if(mines == 0) {
					break;
				}
				if(probability >= placeOrNot) {
					placeActiveSquare = Math.random();
					if(DeadlyMines != 0 &&((placeActiveSquare <= 0.333 && DeadlyMines > 0 )||
							(FASquare==0 && placeActiveSquare <= 0.5)||(InguredlyMines ==0 && FASquare==0)
							||(InguredlyMines ==0 && placeActiveSquare <= 0.5 ))) {
						board[i][j] = new DeadlyMine();
						DeadlyMines = DeadlyMines - 1;
					}
					else if(InguredlyMines != 0 && ((placeActiveSquare > 0.333 && placeActiveSquare <= 0.666 && InguredlyMines > 0) 
							||(FASquare ==0 && DeadlyMines==0) || (FASquare ==0 && placeActiveSquare <= 1 && placeActiveSquare > 0.5)
							|| (DeadlyMines==0 && placeActiveSquare <= 0.5))) {
						board[i][j] = new InjuredMine();
						InguredlyMines = InguredlyMines - 1;
					}
					else if(FASquare != 0 && ((placeActiveSquare > 0.666 && placeActiveSquare <= 1  && FASquare > 0)||
							(InguredlyMines ==0 && DeadlyMines==0) || 
							(InguredlyMines ==0 &&placeActiveSquare > 0.5 && placeActiveSquare <= 1 )||
							(DeadlyMines==0 && placeActiveSquare > 0.5 && placeActiveSquare <= 1))) {
						board[i][j] = new FASquare();
						FASquare = FASquare - 1;
					}
					mines = mines-1;
					cubes = cubes-1;
				}
				if(probability < placeOrNot) {
					cubes = cubes-1;
				}
			}
		}
		this.placeNums(board,9,9);
	}
	public String toStringEndGame() {//this function prints the board in the end of the game 
		for(int i=0;i<this.row;i++) {
			for(int j=0;j<this.col;j++) {
				System.out.print(board[i][j] +"  ");
			}
			System.out.println();
		}
		return "";	
	}
	public String toString() {//this function prints the board
		for(int i=0;i<this.row;i++) {
			for(int j=0;j<this.col;j++) {
				System.out.print(board[i][j].getHiddenSquare() +"  ");
			}
			System.out.println();
		}
		return "";	
	}
}
