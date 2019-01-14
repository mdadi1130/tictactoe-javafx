import java.util.Scanner;

public class Game {
    private GameState stateOfGame;
    private Board board = new Board();
    private ComputerPlayer comp = new ComputerPlayer(board);
    int row, col;

    public Game() {
        newGame();
        while (stateOfGame == GameState.PLAYING) {
            comp.setPlayer();
            System.out.println("It is now player " + comp.getPlayer() + "'s turn.");
            System.out.println("Make a move by entering (separated by a comma) the row and column of where you want to place the next " + comp.getPlayer());
            board.border();
            playerMove();
            gameStatus();
        }
    }

    private void playerMove() {
        try {
            if (comp.getPlayer() == 'X') {
                Scanner input = new Scanner(System.in);
                String str = input.nextLine();
                String[] strVec;
                strVec = str.split(",");
                row = Integer.parseInt(strVec[0]);
                col = Integer.parseInt(strVec[1]);
                checkMove(row - 1, col - 1);
            } else {
                int[] strVec = comp.generateMove();
                row = strVec[0];
                col = strVec[1];
                checkMove(row, col);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Input is out of the grid's bounds: " + e);
            playerMove();
        } catch (NumberFormatException ne) {
            System.out.println("Incorrect format, please insert a comma between the 2 numeric values you input: " + ne);
            playerMove();
        } catch (IllegalMoveException e) {
            System.out.println("This is an illegal move. Please try another location on the board.");
            playerMove();
        }
    }

    private void checkMove(int row, int col) throws IllegalMoveException {
        if (board.board[row][col] == ' ') {
            board.board[row][col] = comp.getPlayer();
        } else {
            throw new IllegalMoveException("This space is taken!");
        }
    }

    private void newGame() {
        stateOfGame = GameState.PLAYING;
        System.out.println("Welcome to Tic Tac Toe! Get 3 X's or O's in a row (vertically, horizontally, or diagonally) to win!");
    }
    private void gameStatus() {
        if (board.hasWon(comp.getPlayer())) {
            if (comp.getPlayer() == 'X') {
                board.border();
                this.stateOfGame = GameState.X_WON;
                System.out.println("Player X has won!");
            } else {
                board.border();
                this.stateOfGame = GameState.O_WON;
                System.out.println("Player O has won!");
                System.out.println(comp.phrase());
            }
        }
        if (board.hasTied()) {
            System.out.println("There is a draw!");
            board.border();
            this.stateOfGame = GameState.DRAW;
        }
    }
    public static void main(String[] args) {
        new Game();
    }
}