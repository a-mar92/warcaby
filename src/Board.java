import java.util.Scanner;

public class Board {
    Scanner scanner = new Scanner(System.in);
    MoveUp moveUp = new MoveUp();
    MoveDown moveDown = new MoveDown();
    int pawnW = 1;
    int pawnB = 1;
    boolean endgame = true;
    static String[][] board = new String[8][8];
    int wyborGry;

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
            System.out.print(1 + i + " ");
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
                    if (j % 2 != 0) {
                        board[i][j] = "B";
                        System.out.print(board[i][j] + " ");
                    } else {
                        board[i][j] = "-";
                        System.out.print(board[i][j] + " ");
                    }
                } else if (i == 6) {
                    if (j % 2 == 0) {
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

    public void playerVsplaver() {
        while ((moveUp.player == 1 || moveUp.player == 2) && (endgame)) {
            if (moveUp.player == 1) {
                System.out.println("Player 1 ");
                moveUp.moveDecisionPlayer();
                moveDown.moveDecisionPlayer();
                if (Math.abs(moveUp.getRowUp() - moveDown.getRowDown()) == 1 && Math.abs(moveUp.getCollumnUp() - moveDown.getColumnDown()) == 1) {

                    movePlayer(1);
                } else {
                    System.out.println("move error ");
                    playerVsplaver();
                }


                printBoardAfterMove();
                moveUp.player++;
            } else if (moveUp.player == 2) {
                System.out.println("player 2");
                moveUp.moveDecisionPlayer();
                moveDown.moveDecisionPlayer();
                if (Math.abs(moveUp.getRowUp() - moveDown.getRowDown()) == 1 && Math.abs(moveUp.getCollumnUp() - moveDown.getColumnDown()) == 1) {
                    movePlayer(2);

                } else {
                    System.out.println("move error ");
                    playerVsplaver();
                }
                moveUp.player--;

                printBoardAfterMove();

            }

            if (pawnW == 0) {
                System.out.println("end game, win B");
                endgame = false;
            } else if (pawnB == 0) {
                System.out.println("end game, win W");
                endgame = false;
            }
        }
    }

    public void playerVsKomputer() {
        while (endgame) {
            System.out.println("player ");
            moveUp.moveDecisionPlayer();
            moveDown.moveDecisionPlayer();
            if (Math.abs(moveUp.getRowUp() - moveDown.getRowDown()) == 1 && Math.abs(moveUp.getCollumnUp() - moveDown.getColumnDown()) == 1) {
                movePlayer(1);
            } else {
                System.out.println("move error ");
                playerVsKomputer();


            }

            printBoardAfterMove();


            System.out.println("Computer : ");
            moveUp.executionMoveComputer();
            moveDown.executionMoveKomputer();
            movePlayer(3);


            if (pawnW == 0) {
                System.out.println("End game, win B");
                endgame = false;
            } else if (pawnB == 0) {
                System.out.println("End game, win W");
                endgame = false;
            }

        }
    }

    public void movePlayer(int player) {
        if (player == 2) {
            if (board[moveDown.getRowDown()][moveDown.getColumnDown()].equals("W")) {
                System.out.println("You Hit pawn W");
                board[moveUp.getRowUp()][moveUp.getCollumnUp()] = "-";
                board[moveDown.getRowDown()][moveDown.getColumnDown()] = "B";
                pawnW--;


            } else if ((board[moveDown.getRowDown()][moveDown.getColumnDown()].equals("B"))) {
                System.out.println("Here is your pawn, make another move");
                playerVsplaver();
            } else {
                board[moveUp.getRowUp()][moveUp.getCollumnUp()] = "-";
                board[moveDown.getRowDown()][moveDown.getColumnDown()] = "B";
            }

        } else if (player == 1) {
            if (board[moveDown.getRowDown()][moveDown.getColumnDown()].equals("B")) {
                System.out.println("\"You Hit pawn B");
                pawnB--;

                board[moveUp.getRowUp()][moveUp.getCollumnUp()] = "-";
                board[moveDown.getRowDown()][moveDown.getColumnDown()] = "W";

            } else if ((board[moveDown.getRowDown()][moveDown.getColumnDown()].equals("W"))) {
                System.out.println("Here is your pawn, make another move");
                playerVsplaver();
            } else {
                board[moveUp.getRowUp()][moveUp.getCollumnUp()] = "-";
                board[moveDown.getRowDown()][moveDown.getColumnDown()] = "W";
            }

        } else if (player == 3) {
            if (board[moveDown.getRowDownComputer()][moveDown.getColumnDownComputer()].equals("W")) {
                System.out.println("You Hit pawn W");
                System.out.println(board[moveUp.getWierszKomputer()][moveUp.getKolumnaKomp()]);
                board[moveUp.getWierszKomputer()][moveUp.getKolumnaKomp()] = "-";
                board[moveDown.getRowDownComputer()][moveDown.getColumnDownComputer()] = "B";

                pawnW--;
            } else if (moveDown.getColumnDownComputer() >= 7) {
                moveDown.setColumnDownComputer(5);
                if (board[moveDown.getRowDownComputer()][moveDown.getColumnDownComputer()].equals("W")) {
                    System.out.println("You Hit pawn W");
                    board[moveUp.getWierszKomputer()][moveUp.getKolumnaKomp()] = "-";
                    board[moveDown.getRowDownComputer()][moveDown.getColumnDownComputer()] = "B";
                    pawnW--;
                } else {
                    board[moveUp.getWierszKomputer()][moveUp.getKolumnaKomp()] = "-";
                    board[moveDown.getRowDownComputer()][moveDown.getColumnDownComputer()] = "B";
                }

            } else if ((board[moveDown.getRowDownComputer()][moveDown.getColumnDownComputer()]).equals("B")) {
                moveUp.executionMoveComputer();
                if (board[moveDown.getRowDownComputer()][moveDown.getColumnDownComputer()].equals("W")) {
                    System.out.println("You Hit pawn W");
                    board[moveUp.getWierszKomputer()][moveUp.getKolumnaKomp()] = "-";
                    board[moveDown.getRowDownComputer()][moveDown.getColumnDownComputer()] = "B";
                    pawnW--;
                }


            } else {
                board[moveUp.getWierszKomputer()][moveUp.getKolumnaKomp()] = "-";
                board[moveDown.getRowDownComputer()][moveDown.getColumnDownComputer()] = "B";
            }
        }
        printBoardAfterMove();
    }

    public void endgame() {
        endgame = false;
        System.out.println("End game");
    }

    public void wyborGry() {
        System.out.println("Welcome to the game of checkers, choose from the menu :\n" + "1 - player vs player \n" + "2 - player vs computer\n" + "3 - exit\n" + ">");
        wyborGry = scanner.nextInt();
        Board board = new Board();

        switch (wyborGry) {

            case 1:
                System.out.println("You choose grę 1 vs 1. \n" + "player 1 -  W \n" + "player 2 -  B");
                board.printBoard();
                board.playerVsplaver();
                break;
            case 2:
                board.printBoard();
                playerVsKomputer();

                break;
            case 3:
                board.endgame();
                break;
            default:
                System.out.println("enter correct value ");
                wyborGry();
        }

    }

    public void printBoardAfterMove() {
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





