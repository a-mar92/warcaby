import java.util.Random;
import java.util.Scanner;

public interface Move {
    Scanner scanner = new Scanner(System.in);
    Random random = new Random();

    void moveDecisionPlayer();

    public void executionMovePlayer();

}
