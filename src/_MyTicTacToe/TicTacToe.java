package _MyTicTacToe;

import java.util.Arrays;
import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {

        int[][] board = new int[3][3];
        int currentPlayer = (int) (Math.random() * 2) + 1;

        int gameMode = selectGameMode();
        String namePlayer1 = insertName(gameMode, 1);
        String namePlayer2 = insertName(gameMode, 2);

        System.out.println("Game started!");
        System.out.println(namePlayer1 + " VS " + namePlayer2);
        System.out.println();

        printBoard(board, true);
        letsPlay(board, gameMode, currentPlayer, namePlayer1, namePlayer2);

    }

    private static String insertName(int gameMode, int playerNumber) {
        String name;
        if (gameMode == 1 || (gameMode == 2 && playerNumber == 1)) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("PLayer " + playerNumber + " please insert your name: ");
            name = scanner.next();
        } else {
            name = "AI player " + (gameMode == 2 ? "1" : playerNumber);
        }
        return name;
    }

    private static int selectGameMode() {
        System.out.println("Game mods:");
        System.out.println("1 - Player & Player");
        System.out.println("2 - Player & AI");
        System.out.println("3 - AI & AI");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Select game mode: ");
        int gameMode = scanner.nextInt();
        if (gameMode < 1 || gameMode > 3) {
            System.out.println();
            selectGameMode();
        }
        System.out.println();

        return gameMode;
    }

    private static void printBoard(int[][] board, boolean example) {
        int boardLen = board.length;
        String cellText;

        for (int row = 0, i = 1; row < boardLen; row++) {
            int rowLen = board[row].length;
            for (int column = 0; column < rowLen; column++) {
                if (example) {
                    cellText = Integer.toString(i);
                    i++;
                } else {
                    cellText = getTicTacToe(board[row][column]);
                }
                System.out.print(cellText + (column == rowLen - 1 ? "" : " | "));
            }
            System.out.println();
            System.out.println((row == boardLen - 1 ? "" : "--+---+--"));
        }
    }

    private static String getTicTacToe(int value) {
        String res;
        if (value == 0) {
            res = " ";
        } else if (value == 1) {
            res = "X";
        } else {
            res = "0";
        }
        return res;
    }

    private static void letsPlay(int[][] board, int gameMode, int currentPlayer, String namePlayer1, String namePlayer2) {
        boolean keepPlaying = false;
        String currentPlayerName;
        Scanner scanner = new Scanner(System.in);

        int input = 0;

        do {
            currentPlayerName = currentPlayer == 1 ? namePlayer1 : namePlayer2;
            System.out.println(currentPlayerName + "'s turn.");

            if (gameMode == 3 || (gameMode == 2 && currentPlayer == 2)) {
                input = getAiInput(board, currentPlayer);
                printBoard(board, false);
                keepPlaying = checkCurrentState(board, input, currentPlayer, currentPlayerName);
                currentPlayer = currentPlayer == 1 ? 2 : 1;
            } else {
                System.out.print("Enter your move: ");
                input = scanner.nextInt();
                if (input >= 1 && input <= 9 && checkPlayersInput(board, input, currentPlayer)) {
                    printBoard(board, false);
                    keepPlaying = checkCurrentState(board, input, currentPlayer, currentPlayerName);
                    currentPlayer = currentPlayer == 1 ? 2 : 1;
                } else {
                    if (input == 99) {
                        System.out.println("Game crashed.");
                        keepPlaying = false; //crash game ending
                    } else {
                        System.out.println("This move is not correct.");
                        System.out.println("U can try again or enter 99 to end the game.");
                        System.out.println();
                    }
                }
            }
            System.out.println();
        } while (keepPlaying);
    }

    private static int getAiInput(int[][] board, int currentPlayer) {

        int input;
        boolean correctInput;

        int smartInput = getSmartMove(board, currentPlayer, "Attack");

        if (smartInput == 0) {
            smartInput = getSmartMove(board, currentPlayer, "Defence");
        }

        if (smartInput != 0) {
            int row = (smartInput - 1) / 3; //Convert 1-9 to 0-2
            int col = smartInput - (row * 3) - 1; //Convert 1-9 to 0-2
            board[row][col] = currentPlayer;
            return smartInput;
        } else {
            do {
                input = (int) ((Math.random() * 9) + 1);
                correctInput = checkPlayersInput(board, input, currentPlayer);
            } while (!correctInput);
        }

        return input;
    }

    private static int getSmartMove(int[][] board, int currentPlayer, String typeOfMove) {

        int res = 0;
        int[][] boardTrans = trans(board);

        // Check rows
        res = checkLinesDef(board, currentPlayer, typeOfMove, "Rows");
        if (res == 0) { // Check columns
            res = checkLinesDef(boardTrans, currentPlayer, typeOfMove, "Columns");

            if (res == 0) { // Check diagonal
                res = checkDiagonalsDef(board, currentPlayer, typeOfMove, "Normal");

                if (res == 0) { // Check diagonal2
                    res = checkDiagonalsDef(boardTrans, currentPlayer, typeOfMove, "Trans");
                }
            }
        }
        return res;
    }

    private static int checkLinesDef(int[][] board, int currentPlayer, String typeOfMove, String type) {

        for (int i = 0; i < board.length; i++) {
            if (rowIsDangerous(board[i], currentPlayer, typeOfMove)) {
                for (int j = 0; j < board[i].length; j++) {
                    if (board[i][j] == 0) {
                        if (type.equals("Rows")) {
                            return i * 3 + (j + 1);// Convert [0-2][0-2] to 1-9
                        } else if (type.equals("Columns")) {
                            return j * 3 + (i + 1); // Convert [0-2][0-2] to 1-9
                        }
                    }
                }
            }
        }
        return 0;
    }

    private static int checkDiagonalsDef(int[][] board, int currentPlayer, String typeOfMove, String type) {

        int[] checkArray = new int[3];
        for (int i = 0; i < board.length; i++) {
            checkArray[i] = board[i][i];
        }

        if (rowIsDangerous(checkArray, currentPlayer, typeOfMove)) {
            for (int i = 0; i < board.length; i++) {
                if (board[i][i] == 0) {
                    if (type.equals("Normal")) {
                        return i * 3 + (i + 1);// Convert [0-2][0-2] to 1-9
                    } else { // Transpos
                        return (i + 1) * 3 - i;// Convert [0-2][0-2] to 1-9
                    }
                }
            }
        }
        return 0;
    }

    private static boolean rowIsDangerous(int[] row, int currentPlayer, String typeOfMove) {
        int[] array = row.clone();
        Arrays.sort(array);

        if (typeOfMove.equals("Attack")
                && array[0] == 0
                && array[1] == currentPlayer
                && array[2] == currentPlayer) {
            return true;
        } else return typeOfMove.equals("Defence")
                && array[0] == 0
                && array[1] != currentPlayer && array[1] != 0
                && array[2] != currentPlayer && array[2] != 0;
    }

    private static int[][] trans(int[][] arrayInitial) {

        int[][] transArray = new int[arrayInitial[0].length][arrayInitial.length];
        for (int i = 0; i < arrayInitial.length; i++) {
            for (int k = 0; k < arrayInitial[i].length; k++) {
                transArray[k][i] = arrayInitial[i][k];
            }
        }
        return transArray;
    }

    private static boolean checkPlayersInput(int[][] board, int input, int currentPlayer) {

        boolean res = true;
        int row = (input - 1) / 3; //Convert 1-9 to 0-2
        int col = input - (row * 3) - 1; //Convert 1-9 to 0-2

        if (board[row][col] != 0) {
            res = false;
        } else board[row][col] = currentPlayer;

        return res;
    }

    private static boolean checkCurrentState(int[][] board, int input, int currentPlayer, String PlayerName) {

        int lastInputRow = (input - 1) / 3; //Convert 1-9 to 0-2
        int lastInputCol = input - lastInputRow * 3 - 1; //Convert 1-9 to 0-2

        if ((board[lastInputRow][0] == currentPlayer //Check 3 in the last entered row
                && board[lastInputRow][1] == currentPlayer
                && board[lastInputRow][2] == currentPlayer)
                || (board[0][lastInputCol] == currentPlayer // Check 3 in the last entered column
                && board[1][lastInputCol] == currentPlayer
                && board[2][lastInputCol] == currentPlayer)
                || (lastInputRow == lastInputCol //Check diagonal
                && board[0][0] == currentPlayer
                && board[1][1] == currentPlayer
                && board[2][2] == currentPlayer)
                || (lastInputRow + lastInputCol == 2 //Check opposite diagonal
                && board[0][2] == currentPlayer
                && board[1][1] == currentPlayer
                && board[2][0] == currentPlayer)) {
            System.out.println(PlayerName + " won!");
        } else { //Check for draw
            for (int[] rows : board) {
                for (int columns : rows) {
                    if (columns == 0) { // Still can play
                        return true;
                    }
                }
            }
            System.out.println("Draw!");
        }
        return false;
    }
}
