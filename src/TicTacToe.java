public class TicTacToe {
    static final int COLUMNS = 3;
    static final int ROWS = 3;

    private enum Turn {
        PLAYER_X, PLAYER_O
    }

    private String input = "";
    private State state = State.PLAY;
    private Turn turn = Turn.PLAYER_X;
    private char[][] gameGridArr = {{' ',' ',' '}, {' ',' ',' '}, {' ',' ',' '}};

    public boolean isWorking() {
        return this.state != State.EXIT;
    }

    public void printLabel() {
        switch (state) {
            case MAIN -> System.out.println("Enter starting grid:");
            case PLAY -> System.out.println("Player " + (turn == Turn.PLAYER_X ? "X" : "O") + " can input the coordinates:");
        }
    }

    public void handler(String input) {
        this.input = input;

        switch (state) {
            case MAIN:
                init();
                state = State.PLAY;
                break;
            case PLAY:
                play();
                break;
        }
    }

    private void init() {
        try {
            strToGrd(input);
            printGrid();
        } catch(Exception e) {
            System.out.println(e.getMessage());

            state = State.EXIT;
        }


        int oCount = (int) input.chars().filter(ch -> ch == 'O').count();;
        int xCount = (int) input.chars().filter(ch -> ch == 'X').count();;

        int difference = Math.abs(oCount - xCount);
        if (difference > 1) {
            System.out.println("Impossible");

            state = State.EXIT;
        }
    }

    private void play() {
        String coordinates = input.replaceAll(" ", "");
        String regex = "[0-9]+";
        if (!coordinates.matches(regex)) {
            System.out.println("You should enter numbers!");

            return;
        }

        if (coordinates.length() != 2) {
            System.out.println("You should enter two numbers!");

            return;
        }

        int row = Integer.parseInt(coordinates.substring(0, 1));
        int column = Integer.parseInt(coordinates.substring(1));


        if (row > ROWS || column > COLUMNS) {
            System.out.println("Coordinates should be from 1 to 3!");

            return;
        }

        //System.out.println(arr[row - 1][column - 1] == '_');
        if (gameGridArr[row - 1][column - 1] == ' ') {
            gameGridArr[row - 1][column - 1] = (turn == Turn.PLAYER_X ? 'X' : 'O');
        } else {
            System.out.println("This cell is occupied! Choose another one!");

            return;
        }

        printGrid();

        String result = checkWinner(gameGridArr);
        System.out.println(result);
        if (result.equals("Draw") || result.equals("Impossible")) {
            state = State.EXIT;

            return;
        }

        turn = (turn == Turn.PLAYER_X ? Turn.PLAYER_O : Turn.PLAYER_X);
    }

    @Deprecated(since = "v1.0", forRemoval = true)
    public char[][] strToGrd(String str) throws Exception {
        int strLength = str.length();
        int count = 0;

        int requiredLength = ROWS * COLUMNS;
        if (requiredLength != strLength)
        {
            throw new Exception("Input must have " + requiredLength + " characters.");
        }

        // convert the string into grid
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                if (count < strLength)
                    gameGridArr[i][j] = str.charAt(count);
                count++;
            }
        }

        return gameGridArr;
    }

    public void printGrid() {
        StringBuilder str = new StringBuilder();
        str.append("---------");

        for (int i = 0; i < ROWS; i++)
        {
            str.append("\n| ");

            for (int j = 0; j < COLUMNS; j++)
            {
                if (gameGridArr[i][j] == 0)
                {
                    break;
                }
                str.append(gameGridArr[i][j] + " ");
            }

            str.append("|");
        }

        str.append("\n---------\n");

        System.out.println(str.toString());
    }

    private static String checkWinner(char[][] arr) {
        String result = null;

        for (int i = 0; i < 8; i++) {
            String line = null;

            switch (i) {
                case 0:
                    line = codePointToString(arr[0][0], arr[0][1], arr[0][2]);
                    break;
                case 1:
                    line = codePointToString(arr[1][0], arr[1][1], arr[1][2]);
                    break;
                case 2:
                    line = codePointToString(arr[2][0], arr[2][1], arr[2][2]);
                    break;
                case 3:
                    line = codePointToString(arr[0][0], arr[1][0], arr[2][0]);
                    break;
                case 4:
                    line = codePointToString(arr[0][1], arr[1][1], arr[2][1]);
                    break;
                case 5:
                    line = codePointToString(arr[0][2], arr[1][2], arr[2][2]);
                    break;
                case 6:
                    line = codePointToString(arr[0][0], arr[1][1], arr[2][2]);
                    break;
                case 7:
                    line = codePointToString(arr[0][2], arr[1][1], arr[2][0]);
                    break;
            }

            if (line.equals("XXX")) {
                result = "X wins";
                break;
            } else if (line.equals("OOO")) {
                result = "O wins";
                break;
            }
        }

        if (result != null) {
            System.out.println(result);
            System.exit(0);
            return result;
        }

        forLoop:
        for (int i = 0; i < ROWS; i++)
        {
            for (int j = 0; j < COLUMNS; j++)
            {
                if (arr[i][j] == ' ')
                {
                    break forLoop;
                }

                if (i == (ROWS - 1) && j == (COLUMNS - 1)) {
                    return "Draw";
                }
            }
        }

        return "";
    }

    public static String codePointToString(int a, int b, int c) {
        return Character.toString(a) + Character.toString(b) + Character.toString(c);
    }
}
