
public class MoveUp implements Move {
    Board board;
    int player = 1;
    String poleUp;
    int kloumna;int wiersz;
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
        sprawdzZnak();





    }

    public void executionMove() {
        wiersz  = Character.getNumericValue(poleUp.charAt(0)) - 10;
        kloumna = Character.getNumericValue(poleUp.charAt(1)) - 1;
//        System.out.println("K "+ kloumna);
//        System.out.println("W " +wiersz);


    }

    public int getKloumnaUp() {
        return Character.getNumericValue(poleUp.charAt(0)) - 10;
    }

    public int getWierszUp() {
        return Character.getNumericValue(poleUp.charAt(1)) - 1;
    }

    public void sprawdzZnak(){
        if(player==1 && Board.board[getWierszUp()][getKloumnaUp()].equals("W")){
            executionMove();}
        else if (player==2 && Board.board[getWierszUp()][getKloumnaUp()].equals("B")) {
            executionMove();

        }else if (player==1 && Board.board[getWierszUp()][getKloumnaUp()].equals("-")||player==2 && Board.board[getWierszUp()][getKloumnaUp()].equals("-")) {
            System.out.println("To nie jest pionek!");
            moveDecision();}

        else{
            System.out.println("nie możesz ruszyć pionka od przeciwnika\n player1 - W\n player2 - B");
            moveDecision();
    }}
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







