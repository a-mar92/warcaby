public class MoveDown implements Move {

    public MoveDown(int kolumnaDown, int wierszDown) {
        this.kolumnaDown = kolumnaDown;
        this.wierszDown = wierszDown;
    }

    public MoveDown() {
    }
    int kolumnaDownKomputer;
    int wierszDownKomputer;
        int kolumnaDown;
        int losowanieRuchu;
     int wierszDown;
    String poleDown;

     public void moveDecisionPlayer(){
         System.out.println();
         System.out.println("Podaj pole gdzie umieścisz pionka : ");
         System.out.print(">");
         poleDown = scanner.nextLine();
//         System.out.println("Umieściłeś pionka na polu " + poleDown);
         executionMovePlayer();
     }

    @Override
    public void executionMovePlayer() {
        int kolumnaDown = Character.getNumericValue(poleDown.charAt(0)) - 10;
        int wierszDown = Character.getNumericValue(poleDown.charAt(1)) - 1;
//        System.out.println("K "+ kolumnaDown);
//        System.out.println("W " +wierszDown);



    }
    public void executionMoveKomputer(){
        losowanieRuchu= random.nextInt(1);
        System.out.println(losowanieRuchu);
        if (losowanieRuchu==1){
            wierszDownKomputer =  MoveUp.wierszKomputer+1;}
        else  {wierszDownKomputer = MoveUp.wierszKomputer-1;}

        kolumnaDownKomputer = MoveUp.kolunmaKomputer+1;
    }

    public int getKolumnaDownKomputer(){
         return kolumnaDownKomputer;
    }

    public int getWierszDownKomputer() {
        return wierszDownKomputer;
    }

    public int getKolumnaDown() {
        return Character.getNumericValue(poleDown.charAt(0)) - 10;
    }

    public int getWierszDown() {
        return Character.getNumericValue(poleDown.charAt(1)) - 1;
    }
}
