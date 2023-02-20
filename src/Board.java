public class Board {
    MoveUp moveUp = new MoveUp();
    MoveDown moveDown = new MoveDown();


    String[][] board = new String[8][8];

    public void starterBoard() {
        System.out.print("  A B C D E F G H");
        System.out.println();


        for (int i = 0; i < 8; i++) {
            System.out.print(i + 1 + " ");
            for (int j = 0; j < 8; j++) {
                board[i][j] = "-";
                System.out.print(board[i][j] + " ");
            }
            System.out.println();

        }
    }


    public void printBoard() {

        System.out.print("  A B C D E F G H");
        System.out.println();


        for (int i = 0; i < 8; i++) {
                        System.out.print(1+ i+ " ");
            for (int j = 0; j < 8; j++) {
                if (i == 0 || i == 2) {
                    if (j % 2 == 0 & i != 2) {
                        board[i][j] = "W";
                        System.out.print(board[i][j] + " ");
                    } else {
                        board[i][j] = "-";
                        System.out.print(board[i][j] + " ");
                    }
                } else if (i == 1) {
                    if (j % 2 != 0) {
                        board[i][j] = "W";
                        System.out.print(board[i][j] + " ");
                    } else {
                        board[i][j] = "-";
                        System.out.print(board[i][j] + " ");
                    }
                } else if (i == 7) {
                    if (j % 2 == 0) {
                        board[i][j] = "B";
                        System.out.print(board[i][j] + " ");
                    } else {
                        board[i][j] = "-";
                        System.out.print(board[i][j] + " ");
                    }
                } else if (i == 6) {
                    if (j % 2 != 0) {
                        board[i][j] = "B";
                        System.out.print(board[i][j] + " ");
                    } else {
                        board[i][j] = "-";
                        System.out.print(board[i][j] + " ");
                    }
                } else {
                    board[i][j] = "-";
                    System.out.print(board[i][j] + " ");
                }
            }
            System.out.println();


        }

    }

    public void changeValue() {
   moveUp.moveDecision();
        moveDown.moveDecision();
        board[moveUp.getWierszUp()][moveUp.getKloumnaUp()] = "-";
        board[moveDown.getWierszDown()][moveDown.getKolumnaDown()] = "W";
        System.out.print("  A B C D E F G H");
        System.out.println();
        for (int i = 0; i < board.length; i++) {

            System.out.print(1+ i+ " ");
                        for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + " ");

            }  System.out.println();
        }
    }


}





