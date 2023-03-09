import java.util.Scanner;

public class Board {
    Scanner scanner = new Scanner(System.in);
    MoveUp moveUp = new MoveUp();
    MoveDown moveDown = new MoveDown();
    int pionkiW = 8;
    int pionkiB = 8;
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
        while ((moveUp.player == 1 || moveUp.player == 2)&&( endgame)) {
            if (moveUp.player == 1) {
                System.out.println("Ruch gracz 1 ");
                moveUp.moveDecisionPlayer();
                moveDown.moveDecisionPlayer();
                if (Math.abs(moveUp.getWierszUp() - moveDown.getWierszDown()) == 1 && Math.abs(moveUp.getKloumnaUp() - moveDown.getKolumnaDown()) == 1) {

                        pionekRuch(1);
                } else {
                    System.out.println("błąd ruchu ");
                    playerVsplaver();
                }


                drukowanieTablicyPoRuchu();
                moveUp.player++;
            } else if (moveUp.player == 2) {
                System.out.println("ruch gracz 2");
                moveUp.moveDecisionPlayer();
                moveDown.moveDecisionPlayer();
                if (Math.abs(moveUp.getWierszUp() - moveDown.getWierszDown()) == 1 && Math.abs(moveUp.getKloumnaUp() - moveDown.getKolumnaDown()) == 1) {
                    pionekRuch(2);

                } else {
                    System.out.println("błąd ruchu ");
                    playerVsplaver();
                }
                moveUp.player--;

                drukowanieTablicyPoRuchu();

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

    public void playerVsKomputer(){
        while (endgame) {
            System.out.println("Ruch gracza ");
            moveUp.moveDecisionPlayer();
            moveDown.moveDecisionPlayer();
            if (Math.abs(moveUp.getWierszUp() - moveDown.getWierszDown()) == 1 && Math.abs(moveUp.getKloumnaUp() - moveDown.getKolumnaDown()) == 1) {
                pionekRuch(1);
            } else {
                System.out.println("błąd ruchu ");
                playerVsKomputer();


        }drukowanieTablicyPoRuchu();


            System.out.println("Ruch Komputera ");
            moveUp.executionMoveComputer();
            moveDown.executionMoveKomputer();
            pionekRuch(3);
            System.out.println(moveUp.getKolumnaKomp());
            System.out.println(moveUp.getWierszKomputer());



    }}
    public void pionekRuch(int player) {
        if (player == 2 ) {
            if (board[moveDown.getWierszDown()][moveDown.getKolumnaDown()].equals("W")){
                System.out.println("Zbiłeś pionka przeciwnika");
                board[moveUp.getWierszUp()][moveUp.getKloumnaUp()] = "-";
                board[moveDown.getWierszDown()][moveDown.getKolumnaDown()] = "B";
                pionkiW--;


            }
            else if ((board[moveDown.getWierszDown()][moveDown.getKolumnaDown()].equals("B"))){
                System.out.println("Tutuaj stoi twój pionek, zrób inny ruch");
                playerVsplaver();
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
                playerVsplaver();}
            else {
            board[moveUp.getWierszUp()][moveUp.getKloumnaUp()] = "-";
            board[moveDown.getWierszDown()][moveDown.getKolumnaDown()] = "W";}

        }else if (player == 3) {
//            if (board[moveDown.getWierszDownKomputer()][moveDown.getKolumnaDownKomputer()].equals("W")){
                System.out.println("Zbiłeś pionka przeciwnika");
                System.out.println(board[moveUp.getWierszKomputer()][moveUp.getKolumnaKomp()]);
                board[moveUp.getWierszKomputer()][moveUp.getKolumnaKomp()] = "T";
                System.out.println(moveUp.getWierszKomputer());
                System.out.println(moveUp.getKolumnaKomp());

                board[moveUp.getWierszKomputer()][moveUp.getKolumnaKomp()] = "-";
                board[moveDown.getWierszDownKomputer()][moveDown.getKolumnaDownKomputer()] = "TTT";drukowanieTablicyPoRuchu();

                pionkiW--;

//        }

    }}

    public void endgame(){
        endgame = false;
        System.out.println("koniec gry");
    }

    public void wyborGry(){System.out.println("Witam w grze warcaby, wybierz z menu :\n" +
            "1 - gracz vs gracz \n" +
            "2 - gracz vs komputer\n" +
            "3 - exit\n" +
            ">");
        wyborGry = scanner.nextInt();
        Board board = new Board();

        switch (wyborGry) {

            case 1:
                System.out.println("Wybrałeś grę 1 vs 1. \n" +
                        "gracz 1 - pionki W \n" +
                        "gracz 2 - pionki B");
                board.printBoard();
                board.playerVsplaver();
                break;
            case 2:
                board.printBoard();
                playerVsKomputer();
                System.out.println("nic tu nie ma");
                break;
            case 3:
                board.endgame();
                break;
            default:
                System.out.println("nieznana wartość " );
                                wyborGry();
    }

}

    public void drukowanieTablicyPoRuchu(){
        System.out.print("  A B C D E F G H");
        System.out.println();
        for (int i = 0; i < board.length; i++) {

            System.out.print(1 + i + " ");
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + " ");

            }
            System.out.println();
        }
    }}





