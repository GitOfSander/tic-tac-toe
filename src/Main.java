import java.util.Scanner;

class Main {
    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scanner = new Scanner(System.in);

        TicTacToe ticTacToe = new TicTacToe();
        while(ticTacToe.isWorking()) {
            ticTacToe.printLabel();
            ticTacToe.handler(scanner.nextLine());
        }

        scanner.close();
    }
}