package sidequests;

import kotlin.Pair;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

public class TicTacToe {
    static String[][] gameMatrix;
    static HashSet<List<Integer>> winningSet;
    static int turn = 1;

    public static void main(String[] args) {
        int width = getGridSize();

        gameMatrix = new String[width][width];

        initGridWithNumbers();

        printGrid();

        startGame();
    }

    public static int getGridSize() {
        try {
            System.out.println("What grid width do you want for the game?");

            String gridWidth = readConsoleInput();

            int grid = Integer.parseInt(gridWidth);

            if (grid > 10) {
                println("Grid cannot be bigger than 10x10");
                throw new NumberFormatException("10");
            }

            return grid;
        } catch (NumberFormatException e) {
            if (Objects.equals(e.getMessage(), "10")) {
                println("Defaulting to a 10x10 grid");
                return 10;
            } else {
                println("Defaulting to a 3x3 grid");
                return 3;
            }
        }
    }

    private static Pair<Integer, Integer> getMatrixPosition(String move) {
        try {
            int movePosition = Integer.parseInt(move) - 1;
            int gridWidth = gameMatrix.length;

            if (movePosition >= gridWidth * gridWidth) {
                throw new NumberFormatException();
            }

            if (movePosition == 0) {
                return new Pair<>(0, 0);
            }

            int x = movePosition / gameMatrix.length;
            int y = movePosition % gameMatrix.length;

            if (Objects.equals(gameMatrix[x][y], "x") || Objects.equals(gameMatrix[x][y], "o")) {
                throw new NumberFormatException();
            }

            return new Pair<>(x, y);
        } catch (Exception exception) {
            return new Pair<>(-1, -1);
        }
    }

    private static void initGridWithNumbers() {
        for (int i = 0; i < gameMatrix.length; i++) {
            String[] curr = gameMatrix[i];
            for (int j = 0; j < curr.length; j++) {
                int position = i * gameMatrix.length + j;
                StringBuilder builder = new StringBuilder();

                if (position < 9 && gameMatrix.length > 3) {
                    builder.append("0");
                }

                builder.append(position + 1);

                gameMatrix[i][j] = builder.toString();
            }
        }
    }

    public static void startGame() {
        System.out.println("Game started");
        boolean gameComplete = false;
        turn = 1;
        int roundsPlayed = 0;

        while (roundsPlayed < (gameMatrix.length * gameMatrix.length) && !gameComplete) {
            println("Player " + turn + " please make a move. Enter a number that is currently not filled");

            String move = readConsoleInput();

            boolean isAvailable = checkIfPositionAvailable(move);

            if (!isAvailable) {
                println("Please select a valid position");
                continue;
            }

            boolean gameUpdated = updatePosition(move);

            if (!gameUpdated) {
                println("We encountered an error. Please try again");
                continue;
            }

            if (turn == 1) {
                gameComplete = checkIfWinner("x");

                if (gameComplete) printWinner(turn);

                turn = 2;
            } else {
                gameComplete = checkIfWinner("o");

                if (gameComplete) printWinner(turn);

                turn = 1;
            }

            printGrid();

            roundsPlayed += 1;
        }

        if (!gameComplete) {
            println("Game ended as draw");
        }
    }

    private static boolean checkIfPositionAvailable(String move) {
        Pair<Integer, Integer> positionPair = getMatrixPosition(move);

        int x = positionPair.getFirst();
        int y = positionPair.getSecond();

        return x != -1 && y != -1;
    }

    private static boolean updatePosition(String move) {
        try {
            Pair<Integer, Integer> positionPair = getMatrixPosition(move);

            int x = positionPair.getFirst();
            int y = positionPair.getSecond();

            String play;

            if (turn == 1) {
                play = "x";
            } else {
                play = "o";
            }

            gameMatrix[x][y] = play;

            return true;
        } catch (NumberFormatException exception) {
            return false;
        }
    }

    private static boolean checkIfWinner(String toCheck) {
        winningSet = new HashSet<>();

        // Horizontal combinations
        for (String[] curr : gameMatrix) {
            for (int j = 0; j < curr.length; j++) {
                if (!Objects.equals(curr[j], toCheck)) {
                    break;
                }

                if (j == curr.length - 1) {
                    return true;
                }
            }
        }

        // Vertical combinations
        for (int y = 0; y < gameMatrix.length; y ++) {
            for (int x = 0; x < gameMatrix.length; x++) {
                if (!Objects.equals(gameMatrix[x][y], toCheck)) {
                    break;
                }

                if (x == gameMatrix.length - 1) {
                    return true;
                }
            }
        }

        // Diagonal combinations
        int x = 0;

        while (x < gameMatrix.length) {
            if (!Objects.equals(gameMatrix[x][x], toCheck)) {
                break;
            }

            if (x == gameMatrix.length - 1) {
                return true;
            }

            x ++;
        }

        // Reverse diagonal combinations
        int x2 = gameMatrix.length - 1;
        int y2 = 0;

        while (y2 < gameMatrix.length) {
            if (!Objects.equals(gameMatrix[x2][y2], toCheck)) {
                break;
            }

            if (y2 == gameMatrix.length - 1) {
                return true;
            }

            x2 --;
            y2 ++;
        }

        return false;
    }

    public static void printGrid() {
        printMatrix(gameMatrix);
    }

    private static void printWinner(int winner) {
        println("Player " + winner +" wins!!");
    }

    private static void printMatrix(String [][] matrix) {
        for (String[] arr: matrix) {
            println(Arrays.toString(arr));
        }
    }

    public static String readConsoleInput() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            return reader.readLine();
        }catch (IOException exception) {
            return "";
        }
    }

    public static void println(Object object) {
        System.out.println(object);
    }
}
