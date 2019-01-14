import java.util.Random;

public class ComputerPlayer
{
    private int[][] preferredMoves = {
            {1, 1}, {0, 0}, {0, 2}, {2, 0}, {2, 2},
            {0, 1}, {1, 0}, {1, 2}, {2, 1}};
    private Board board;
     private char player = 'O';
    /** Constructor with reference to game board */
    public ComputerPlayer(Board board)
    {
       this.board = board;
    }
    public char setPlayer() {
        if (player == 'O')
            player = 'X';
        else
            player = 'O';
        return player;
    }

    public char getPlayer() {
        return player;
    }
    /** Search for the first empty cell, according to the preferences
     *  @return int array of two values [row, col]
     */
    public int[] generateMove()
    {
        for (int[] move : preferredMoves)
        {
            // checks for empty space on board
            // (i.e. checks if this "move" is available, if the space is empty its available)
            if (board.board[move[0]][move[1]] == ' ')
            {
                return move;
            }
        }
        int[] movement = {1,2};
        return movement;
    }
    public String phrase() {
        Random rnd = new Random();
        int rndNum = rnd.nextInt(4) + 1;
        if (rndNum == 1)
            return "You lost! Dare to try again?";
        else if (rndNum == 2)
            return "C'mon, you can do better!";
        else if (rndNum == 3)
            return "Ouch, that hurts!";
        else
            return "You know you have to get three X's in a row, not three O's...right?";
    }
}