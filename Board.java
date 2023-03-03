public class Board {
    MoveUp moveUp = new MoveUp();
    MoveDown moveDown = new MoveDown();


    static String[][] board = new String[8][8];

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
        while (moveUp.player ==1 || moveUp.player==2) {
            if (moveUp.player == 1) {
                System.out.println("Ruch gracz 1 ");
                moveUp.moveDecision();
                moveDown.moveDecision();
                if (moveUp.getWierszUp() - moveDown.getWierszDown() == -1 || moveUp.getWierszUp() - moveDown.getWierszDown() == 1) {
                    board[moveUp.getWierszUp()][moveUp.getKloumnaUp()] = "-";
                    board[moveDown.getWierszDown()][moveDown.getKolumnaDown()] = "W";
                } else {
                    System.out.println("błąd nie mażesz się ruszyć o tyle pól ");
                    moveUp.moveDecision();
                    moveDown.moveDecision();
                }


                System.out.print("  A B C D E F G H");
                System.out.println();
                for (int i = 0; i < board.length; i++) {

                    System.out.print(1 + i + " ");
                    for (int j = 0; j < board.length; j++) {
                        System.out.print(board[i][j] + " ");

                    }
                    System.out.println();
                }
                moveUp.player++;
            } else if (moveUp.player == 2) {
                System.out.println("ruch gracz 2");
                moveUp.moveDecision();
                moveDown.moveDecision();
                if (moveUp.getWierszUp() - moveDown.getWierszDown() == -1 || moveUp.getWierszUp() - moveDown.getWierszDown() == 1) {
                    board[moveUp.getWierszUp()][moveUp.getKloumnaUp()] = "-";
                    board[moveDown.getWierszDown()][moveDown.getKolumnaDown()] = "B";
                } else {
                    System.out.println("błąd nie mażesz się ruszyć o tyle pól");
                }
                moveUp.player--;

                System.out.print("  A B C D E F G H");
                System.out.println();
                for (int i = 0; i < board.length; i++) {

                    System.out.print(1 + i + " ");
                    for (int j = 0; j < board.length; j++) {
                        System.out.print(board[i][j] + " ");

                    }
                    System.out.println();
                }

            }
        }
    }


    }






