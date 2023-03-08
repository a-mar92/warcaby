public class Board {
    MoveUp moveUp = new MoveUp();
    MoveDown moveDown = new MoveDown();
    int pionkiW = 8;
    int pionkiB = 8;
    boolean endgame = true;
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

    public void changeValue() {
        while ((moveUp.player == 1 || moveUp.player == 2)&&( endgame)) {
            if (moveUp.player == 1) {
                System.out.println("Ruch gracz 1 ");
                moveUp.moveDecision();
                moveDown.moveDecision();
                if (Math.abs(moveUp.getWierszUp() - moveDown.getWierszDown()) == 1 && Math.abs(moveUp.getKloumnaUp() - moveDown.getKolumnaDown()) == 1) {

                        pionekRuch(1);
                } else {
                    System.out.println("błąd ruchu ");
                    changeValue();
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
                if (Math.abs(moveUp.getWierszUp() - moveDown.getWierszDown()) == 1 && Math.abs(moveUp.getKloumnaUp() - moveDown.getKolumnaDown()) == 1) {
                    pionekRuch(2);

                } else {
                    System.out.println("błąd ruchu ");
                    changeValue();
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

        if(pionkiW == 0 ){
            System.out.println("Koniec gry, wygrywa B");
            endgame = false;
        } else if (pionkiB == 0) {
            System.out.println("Koniec gry, wygrywa W");
            endgame=false;
        }
        }
    }

    public void pionekRuch(int player) {
        if (player == 2) {
            if (board[moveDown.getWierszDown()][moveDown.getKolumnaDown()].equals("W")){
                System.out.println("Zbiłeś pionka przeciwnika");
                board[moveUp.getWierszUp()][moveUp.getKloumnaUp()] = "-";
                board[moveDown.getWierszDown()][moveDown.getKolumnaDown()] = "B";
                pionkiW--;


            }
            else if ((board[moveDown.getWierszDown()][moveDown.getKolumnaDown()].equals("B"))){
                System.out.println("Tutuaj stoi twój pionek, zrób inny ruch");
                changeValue();
            }


            else{
            board[moveUp.getWierszUp()][moveUp.getKloumnaUp()] = "-";
            board[moveDown.getWierszDown()][moveDown.getKolumnaDown()] = "B";}

        } else if (player == 1) {
            if (board[moveDown.getWierszDown()][moveDown.getKolumnaDown()].equals("B")){
                              System.out.println("Zbiłeś pionka przeciwnika");
                              pionkiB--;

                board[moveUp.getWierszUp()][moveUp.getKloumnaUp()] = "-";
                board[moveDown.getWierszDown()][moveDown.getKolumnaDown()] = "W";

            }
            else if ((board[moveDown.getWierszDown()][moveDown.getKolumnaDown()].equals("W"))){
                System.out.println("Tutuaj stoi twój pionek, zrób inny ruch");
                changeValue();}
            else {
            board[moveUp.getWierszUp()][moveUp.getKloumnaUp()] = "-";
            board[moveDown.getWierszDown()][moveDown.getKolumnaDown()] = "W";}

        }

    }

}







