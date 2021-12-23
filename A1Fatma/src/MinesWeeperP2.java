import java.util.Scanner;

public class MinesWeeperP2 {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		boolean playMinesweeper = true; // this helping variable keeps the while loop running 
		while (playMinesweeper) { // this loop reset the game when it is done
			initiateGame(); 
			EmptySquare[][] board = new EmptySquare[9][9];
			int lives =2; // each game you start with 2 lives
			for(int i=0;i<9;i++) {
				for(int j=0;j<9;j++) {
					board[i][j] = new EmptySquare();
				}
			}
			Board GameBoard = new Board(board);  
			GameBoard.placeMines(board);
			while(!gameOver(board,lives,GameBoard)) { 
				GameBoard.toString();
				int move = chooseMove(); 
				if(((move/100)%10) == 5) {// an option to quit the game
					playMinesweeper = false;
					break;
				}
				if((move/100)%10 == 1) {
					selectSquare(move,board,lives);
				}
				if((move/100)%10 == 2) {
					markMine(move,board);
				}
				if((move/100)%10 == 3) {
					unMarkMine(move,board);
				}
			}
			sc.nextLine();
		}
	}
	public static void initiateGame() { // this function print a welcome introduction
		System.out.println("Welcome to Fatma Minesweeper to start the game press 'enter'");
		sc.nextLine();	
	}
	public static void markMine(int move,EmptySquare[][] board) { // this function marks the square that the user choose
		int col = move%10;
		int row = (move/10)%10;
		if(board[row][col].getHiddenSquare() != "# ") { // the user can only choose a square that is hidden
			return;
		}
		board[row][col].setHiddenSquare("& "); 
	}
	public static void unMarkMine(int move,EmptySquare[][] board) { // this function unmark a square and transform it into the hidden sign again
		int col = move%10;
		int row = (move/10)%10;
		if(board[row][col].getHiddenSquare() != "& ") { // the user can only choose a square that is marked
			return;
		}
		board[row][col].setHiddenSquare("# ");
	}
	public static int chooseMove() { // this function gets the user move decision 
		System.out.println("Please enter an operation number and its location");
		System.out.println("(1=select a square, 2= mark a mine, 3= unmark a mine)");
		System.out.println("To abandon the game please press - 555 ");
		int move = sc.nextInt();
		return move; 
	}
	public static int selectSquare(int move,EmptySquare[][] board,int lives) { // if the user decide to open a square this function will open it
		int col = move%10;
		int row = (move/10)%10;
		if(board[row][col].getHiddenSquare() != "# ") {
			return lives; 
		}
		if(board[row][col].getValue() <9) { // if the square is a number/empty 
			board[row][col].showValue(board, row, col);
		}
		if(board[row][col].getValue() == 102) { // if the square is FA 
			((FASquare)board[row][col]).showValue(board,row,col); 
			lives = 2;
		}
		if(board[row][col].getValue() == 665) { // if the square is IN
			((InjuredMine)board[row][col]).showValue(board,row,col);
			if(lives==1) {
				lives =0; // no more lives = you lost
			}
			else {
				lives = 1;
			}
		}
		if(board[row][col].getValue() == 666) { // if the square is Deadly
			((DeadlyMine)board[row][col]).showValue(board,row,col);
			lives = 0; // no more lives = you lost
		}
		return lives;
	}
	public static boolean gameOver(EmptySquare[][] board,int lives,Board GameBoard) { // this function check's if the game is over
		if(checkIfLose(lives)) { // no more lives = you lost
			System.out.println("Boom!!! You've hit a mine and lost…");
			GameBoard.toStringEndGame();
			return true;
		}
		if(checkIfWon(board)) { 
			System.out.println("Congratulations, you won :)");
			GameBoard.toStringEndGame();
			return true;
		}
		return false;
	}
	public static boolean checkIfLose(int lives) {  // check if the player hit a mine and lost
		if(lives==0) {
			return true;
		}
		return false;
	}
	public static boolean checkIfWon(EmptySquare[][] board) {  //check if the player won the game
		int counter =0; // count the unmarked mines
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				if(board[i][j].getHiddenSquare() != "# " && board[i][j].getValue() < 9) {
					counter++;
				}
			}// end inner loop
		}// end loop
		if(counter == 71 ) { // the only way to win is to have only 10 squares left 
			return true;
		}
		return false;
	}
}

