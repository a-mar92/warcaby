import java.util.Random;

public class MoveUp implements Move {
    Board board;
    int player = 1;
    int computer = 1;
    String poleUp;
  static   int kolunmaKomputer;
  static   int wierszKomputer;
        int computerNumberMove;
    int kloumna;
    int wiersz;

    public MoveUp(int kloumna, int wiersz) {
        this.kloumnaUp = kloumna;
        this.wierszUp = wiersz;
    }

    public MoveUp() {
    }

    ;

    int kloumnaUp;
    int wierszUp;

    public void moveDecisionPlayer() {
        System.out.println("Podaj pole pionka do przesunięcia : ");
        System.out.print(">");
        poleUp = scanner.nextLine();
        sprawdzZnak();
    }

    public void moveDecisionComputer() {
        computerNumberMove = 1;
        executionMoveComputer();
        sprawdzZnak();
    }




    public void executionMovePlayer() {
        wiersz = Character.getNumericValue(poleUp.charAt(0)) - 10;
        kloumna = Character.getNumericValue(poleUp.charAt(1)) - 1;
    }

    public void executionMoveComputer() {

        computerNumberMove=1;
        if (computerNumberMove == 1) {
            wierszKomputer = 6;
            kolunmaKomputer = random.nextInt(8);
            if (kolunmaKomputer % 2 != 0) {
                kolunmaKomputer = kolunmaKomputer + 1;
            }


        }
        computerNumberMove++;

    }


        public  int getKloumnaUp () {
            return Character.getNumericValue(poleUp.charAt(0)) - 10;
        }

        public int getWierszUp () {
            return Character.getNumericValue(poleUp.charAt(1)) - 1;
        }

        public int getKolumnaKomp(){
        return kolunmaKomputer;

        }

        public int getWierszKomputer() {
        return wierszKomputer;
        }

        public void sprawdzZnak () {
            if (player == 1 && Board.board[getWierszUp()][getKloumnaUp()].equals("W")) {
                executionMovePlayer();
            } else if (player == 2 && Board.board[getWierszUp()][getKloumnaUp()].equals("B")) {
                executionMovePlayer();

            } else if (player == 1 && Board.board[getWierszUp()][getKloumnaUp()].equals("-") || player == 2 && Board.board[getWierszUp()][getKloumnaUp()].equals("-")) {
                System.out.println("To nie jest pionek!");
                moveDecisionPlayer();

            }
            else if (player == 3 && Board.board[getWierszUp()][getKloumnaUp()].equals("B")) {
                executionMoveComputer();}
            else {
                System.out.println("nie możesz ruszyć pionka od przeciwnika");
                moveDecisionPlayer();
            }
        }
//
//
//
//        int poleLiczba = Character.getNumericValue(pole.charAt(1));
//        char poleZnak = pole.charAt(0);
//        int asciZnak = Character.valueOf(poleZnak);
//        int poleZnakLiczba =Character.getNumericValue(pole.charAt(0));
//
//
//        System.out.println("Liczba " + poleLiczba + "Liczba +1 " + (poleLiczba+1));
//        System.out.println("Znak : " + poleZnak+" znak +1 " + (char)(asciZnak+1));


    }







