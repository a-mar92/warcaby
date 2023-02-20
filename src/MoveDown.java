import java.util.Scanner;

public class MoveDown implements Move {
    public MoveDown(int kolumnaDown, int wierszDown) {
        this.kolumnaDown = kolumnaDown;
        this.wierszDown = wierszDown;
    }

    public MoveDown() {
    }

    int kolumnaDown;
     int wierszDown;
    String poleDown;

     public void moveDecision(){
         System.out.println();
         System.out.println("Podaj pole gdzie umieścisz pionka : ");
         System.out.print(">");
         poleDown = scanner.nextLine();
         System.out.println("Umieściłeś pionka na polu " + poleDown);
         executionMove();
     }

    @Override
    public void executionMove() {
        int kolumnaDown = Character.getNumericValue(poleDown.charAt(0)) - 10;
        int wierszDown = Character.getNumericValue(poleDown.charAt(1)) - 1;
        System.out.println("K "+ kolumnaDown);
        System.out.println("W " +wierszDown);



    }

    public int getKolumnaDown() {
        return Character.getNumericValue(poleDown.charAt(0)) - 10;
    }

    public int getWierszDown() {
        return Character.getNumericValue(poleDown.charAt(1)) - 1;
    }
}
