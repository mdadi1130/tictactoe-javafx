
public class Board {
    protected char board[][] = new char[3][3];
    public Board() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }
    public void border() {
        int[] a = new int[9];
        fillBox(a);
        for (int i = 0; i < 9; i += 3) {
            System.out.println("+---+---+---+");
            for (int j = i; j < i + 3; j++)
                System.out.printf("| %c ", a[j] == 10 ? 'O' : a[j] == 100 ? 'X' : ' ');
            System.out.println("|");
        }
        System.out.println("+---+---+---+");
    }
    public void fillBox(int[] a) {
        for (int i = 0; i < 3; i++) {
            //First row
            if (a[i] == 0 && board[0][i] != ' ') {
                if (board[0][i] == 'X')
                    a[i] = 100;
                else
                    a[i] = 10;
            }
            //Second row
            if (a[i + 3] == 0 && board[1][i] != ' ') {
                if (board[1][i] == 'X')
                    a[i + 3] = 100;
                else
                    a[i + 3] = 10;
            }
            //Third row
            if (a[i + 6] == 0 && board[2][i] != ' ') {
                if (board[2][i] == 'X')
                    a[i + 6] = 100;
                else
                    a[i + 6] = 10;
            }
        }
    }
    public boolean hasWon(char player) {
        for (int i = 0; i < 3; i++) {
            //Win 1 = In a row
            if (board[i][0] == player
                    && board[i][1] == player
                    && board[i][2] == player) {
                return true;
                //Win 2 = In a column
            } else if (board[0][i] == player
                    && board[1][i] == player
                    && board[2][i] == player) {
                return true;
                //Win 3 =  Diagonal top left to bottom right
            } else if (board[0][0] == player
                    && board[1][1] == player
                    && board[2][2] == player) {
                return true;
                //Win 4 = Diagonal top right to bottom left
            } else if (board[0][2] == player
                    && board[1][1] == player
                    && board[2][0] == player) {
                return true;
            }
        }
        return false;
    }
    public boolean hasTied() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') //If no boxes are empty then draw
                    return false;
            }
        }
        return true;
    }
}