public class IllegalMoveException extends Exception {
    public IllegalMoveException(String msg) {
        //Exception if space occupied by X or O
        super("Move has already been made");
    }
}