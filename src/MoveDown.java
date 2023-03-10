public class MoveDown implements Move {

    public MoveDown(int kolumnaDown, int rowDown) {
        this.columnDown = kolumnaDown;
        this.rowDown = rowDown;
    }

    public MoveDown() {
    }

    int columnDownComputer;
    int rowDownComputer;
    int columnDown;
    int randomMove;
    int rowDown;
    String fieldDown;

    public void moveDecisionPlayer() {
        System.out.println();
        System.out.println("Give me a field of pawn : ");
        System.out.print(">");
        fieldDown = scanner.nextLine();
        executionMovePlayer();
    }

    @Override
    public void executionMovePlayer() {
        int columnDown = Character.getNumericValue(fieldDown.charAt(0)) - 10;
        int rowDown = Character.getNumericValue(fieldDown.charAt(1)) - 1;


    }

    public void executionMoveKomputer() {
        randomMove = random.nextInt(1);

        if (randomMove == 1 || MoveUp.rowComputer == 0) {
            rowDownComputer = MoveUp.rowComputer + 1;
            columnDownComputer = MoveUp.columnComputer + 1;

        } else {
            rowDownComputer = MoveUp.rowComputer - 1;
            columnDownComputer = MoveUp.columnComputer + 1;
        }
    }

    public int getColumnDownComputer() {
        return columnDownComputer;
    }

    public int getRowDownComputer() {
        return rowDownComputer;
    }

    public void setColumnDownComputer(int columnDownComputer) {
        this.columnDownComputer = columnDownComputer;
    }

    public int getColumnDown() {
        return Character.getNumericValue(fieldDown.charAt(0)) - 10;
    }

    public int getRowDown() {
        return Character.getNumericValue(fieldDown.charAt(1)) - 1;
    }
}
