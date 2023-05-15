public class Tic_Toc_Toe_Game
{
	private static boolean isBoardOver(char[][] board) {
		int count = 0;
		for(int i=0;i<board.length;i++) {
			for(int j=0;j<board[0].length;j++) {
				if(board[i][j]!=' ') {
					count++;
				}
			}
		}
		if(count==board.length*board[0].length) {
			System.out.println("All Moves Completed...");
			return true;
		}
		return false;
	}
	private static void printBoard(char[][] board) {
		for(int row =0;row<board.length;row++) {
			for(int col=0;col<board[0].length;col++) {
				System.out.print(board[row][col]+" | ");
			}
			System.out.println();
		}
	}
	private static boolean hasWon(char[][] board,char player) {
		//Rows
		for(int row=0;row<board.length;row++) {
			if(board[row][0]==player && board[row][1]==player && board[row][2]==player) {
				return true;
			}
		}
		//Cols
		for(int col=0;col<board[0].length;col++) {
			if(board[0][col]==player && board[1][col]==player && board[2][col]==player) {
				return true;
			}
		}
		//Digonals
		if(board[0][0]==player &&board[1][1]==player &&board[2][2]==player) {
			return true;
		}
		if(board[0][2]==player &&board[1][1]==player &&board[2][0]==player) {
			return true;
		}
		return false; 
	}
	public static void Tic_Toc_Toe(char[][] board) {
		char player = 'X';
		boolean gameOver = false;
		Scanner scan = new Scanner(System.in);
		while(!gameOver) {
			printBoard(board);
			System.out.print("Enter "+player+ " move : ");
			int row = scan.nextInt();
			int col = scan.nextInt();
			if(board[row][col]==' ') {
				board[row][col] = player;
				gameOver = hasWon(board,player);
				if(gameOver) {
					printBoard(board);
					System.out.println("Player "+player+" has won the game..");
				}
				else {
					if(isBoardOver(board)) {
						break;
					}
					player = (player=='X')?'O':'X';
				}
			}
			else
			{
				System.out.println("Invalid Move...");
				gameOver = isBoardOver(board);
			}
		}
		
	}
	public static void main(String[] args) {
		char[][] board = new char[3][3];
		Scanner scan = new Scanner(System.in);
		boolean game = true;
		while(game) {
			System.out.println("Enter 1 to start/re-start the Game or 2 to Exit the Game");
			int n = scan.nextInt();
			if(n==1) {
				for(int i = 0;i<board.length;i++) {
					for(int j=0;j<board[i].length;j++) {
						board[i][j] = ' ';
					}
				}
				Tic_Toc_Toe(board);
			}
			else {
				System.out.println("Game has been ended...");
				game = false;
			}
		}
	}
}