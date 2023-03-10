public class MoveUp implements Move {
    Board board;
    int player = 1;
    int computer = 1;
    String fieldUp;
    static int columnComputer;
    static int rowComputer;
    int computerNumberMove = 1;
    int column;
    int row;
    public MoveUp(int column, int row) {
        this.collumnUp = column;
        this.rowUp = row;
    }
    public MoveUp() {
    }
    int collumnUp;
    int rowUp;

    public void moveDecisionPlayer() {
        System.out.println("Give me a field of pawn : ");
        System.out.print(">");
        fieldUp = scanner.nextLine();
        checkMove();
    }
    public void moveDecisionComputer() {
        computerNumberMove = 1;
        executionMoveComputer();
        checkMove();
    }
    public void executionMovePlayer() {
        row = Character.getNumericValue(fieldUp.charAt(0)) - 10;
        column = Character.getNumericValue(fieldUp.charAt(1)) - 1;
    }
    public void executionMoveComputer() {
        if (computerNumberMove == 1) {
            rowComputer = 6;
            columnComputer = random.nextInt(7);
            if (columnComputer % 2 != 0) {
                columnComputer = columnComputer + 1;
            }
            computerNumberMove++;
        } else if (computerNumberMove != 1) {
            columnComputer = random.nextInt(7);
            rowComputer = random.nextInt(8);
            if ((Board.board[rowComputer][columnComputer]).equals("-") || (Board.board[rowComputer][columnComputer]).equals("W")) {
                executionMoveComputer();
            } else {
                rowComputer = rowComputer;
                columnComputer = columnComputer;
            }
        }
    }
    public int getCollumnUp() {
        return Character.getNumericValue(fieldUp.charAt(0)) - 10;
    }
    public int getRowUp() {
        return Character.getNumericValue(fieldUp.charAt(1)) - 1;
    }
    public int getKolumnaKomp() {
        return columnComputer;
    }
    public int getWierszKomputer() {
        return rowComputer;
    }
    public void checkMove() {
        if (player == 1 && Board.board[getRowUp()][getCollumnUp()].equals("W")) {
            executionMovePlayer();
        } else if (player == 2 && Board.board[getRowUp()][getCollumnUp()].equals("B")) {
            executionMovePlayer();

        } else if (player == 1 && Board.board[getRowUp()][getCollumnUp()].equals("-") || player == 2 && Board.board[getRowUp()][getCollumnUp()].equals("-")) {
            System.out.println("It isnt pawn!");
            moveDecisionPlayer();

        } else if (player == 3 && Board.board[getRowUp()][getCollumnUp()].equals("B")) {
            executionMoveComputer();
        } else {
            System.out.println("You Cant move pawn of your your opponent");
            moveDecisionPlayer();
        }
    }
}







