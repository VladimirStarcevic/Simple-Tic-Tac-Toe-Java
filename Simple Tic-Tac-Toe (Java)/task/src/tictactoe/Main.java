package tictactoe;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);


       playTheGame(scanner);

    }

    private static void playTheGame(Scanner scanner) {
        char[][] grid = {
                {' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '}
        };

        fillTheGrid(grid, scanner);


    }

    private static void fillTheGrid(char[][] grid, Scanner scanner) {
        char playerX = 'X';
        char playerO = 'O';
        char currentPlayer = playerX;

        printGrid(grid);
        while (true){
            String[] tokens = scanner.nextLine().split(" ");
            if (!isCorrectInput(tokens)) {
                continue;
            }

            int row = Integer.parseInt(tokens[0]) - 1;
            int col = Integer.parseInt(tokens[1]) - 1;

            if (grid[row][col] != ' ') {
                System.out.println("This cell is occupied! Choose another one!");
                continue;
            }

            grid[row][col] = currentPlayer;

            printGrid(grid);

            if (isGameFinish(grid, row, col)) {
                System.out.printf("%c wins", currentPlayer);
                break;
            }

            currentPlayer = (currentPlayer == playerX) ? playerO : playerX;
        }


    }

    private static void printGrid(char[][] grid) {
        System.out.println("---------");
        for (int i = 0; i < grid.length; i++) {
            System.out.print("| ");
            for (int j = 0; j < grid[i].length; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }

    private static boolean isGameFinish(char[][] grid, int row, int col) {
        char playerSymbol = grid[row][col];

        if (grid[row][0] == playerSymbol && grid[row][1] == playerSymbol && grid[row][2] == playerSymbol) {
            return true;
        }

        if (grid[0][col] == playerSymbol && grid[1][col] == playerSymbol && grid[2][col] == playerSymbol) {
            return true;
        }

        if (row == col) {
            if (grid[0][0] == playerSymbol && grid[1][1] == playerSymbol && grid[2][2] == playerSymbol) {
                return true;
            }
        }

        if (row == grid.length - 1 - col) {
            if (grid[0][2] == playerSymbol && grid[1][1] == playerSymbol && grid[2][0] == playerSymbol) {
                return true;
            }
        }

        return false;
    }

    private static  boolean isCorrectInput(String[] tokens) {
        if (tokens.length != 2) {
            System.out.println("You should enter exactly two numbers!");
            return false;
        }

        try{
            int row = Integer.parseInt(tokens[0]);
            int col = Integer.parseInt(tokens[1]);

            if (row >= 1 && row <= 3 && col >= 1 && col <= 3) {
                return true;
            } else {
                System.out.println("Coordinates should be from 1 to 3!");
                return false;
            }

        } catch (NumberFormatException e){
            System.out.println("You should enter numbers!");
            return false;
        }
    }

    private static void printEmptyGrid() {
        int n = 5;
        for (int i = 0; i < n; i++) {
            if (i == 0 || i == n - 1) {
                for (int j = 0; j < n; j++) {
                    System.out.print("-");
                }
                System.out.println();
            } else {
                System.out.print("|");
                for (int j = 0; j < n - 2; j++) {
                    System.out.print(" ");
                }
                System.out.println("|");
            }

        }
    }


}
