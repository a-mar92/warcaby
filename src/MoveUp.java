
public class MoveUp implements Move {
    Board board;

    String poleUp;

    public MoveUp(int kloumna, int wiersz) {
        this.kloumnaUp = kloumna;
        this.wierszUp = wiersz;
    }
    public MoveUp(){};

    int kloumnaUp;
    int wierszUp;

    public void moveDecision() {
        System.out.println("Podaj pole pionka do przesunięcia : ");
        System.out.print(">");
        poleUp = scanner.nextLine();
        System.out.println("Wybrałeś pionka z pola " + poleUp);

        executionMove();

    }

    public void executionMove() {
        int kloumna = Character.getNumericValue(poleUp.charAt(0)) - 10;
        int wiersz = Character.getNumericValue(poleUp.charAt(1)) - 1;
        System.out.println("K "+ kloumna);
        System.out.println("W " +wiersz);


    }

    public int getKloumnaUp() {
        return Character.getNumericValue(poleUp.charAt(0)) - 10;
    }

    public int getWierszUp() {
        return Character.getNumericValue(poleUp.charAt(1)) - 1;
    }

    //
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







