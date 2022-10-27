package org.example;

import java.util.*;

public class TicTacToe {

    static ArrayList<Integer> playerPostions = new ArrayList<Integer>();
    static ArrayList<Integer> cpuPostions = new ArrayList<Integer>();

    public static void main(String[] args) {
        char[][] gameBoard = {{' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '}};

        printGameBoard(gameBoard);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter your placement (1-9): ");
            int playerPostion = scanner.nextInt();
            while (playerPostions.contains(playerPostion) || cpuPostions.contains(playerPostions)) {
                System.out.println("Position has taken! Enter correct position");
                playerPostion = scanner.nextInt();
            }
            placePiece(gameBoard, playerPostion, "player");
            String result = checkWinner();
            if (result.length() > 0) {
                System.out.println(result);
                break;
            }
            Random random = new Random();
            int cpuPosition = random.nextInt(9) + 1;
            while (playerPostions.contains(cpuPosition) || cpuPostions.contains(cpuPosition)) {

                cpuPosition = random.nextInt(9) + 1;
            }
            placePiece(gameBoard, cpuPosition, "cpu");

            printGameBoard(gameBoard);
            result = checkWinner();
            if (result.length() > 0) {
                System.out.println(result);
                break;
            }
            System.out.println(result);

        }
    }

    public static String checkWinner() {
        List topRow = Arrays.asList(1, 2, 3);
        List middleRow = Arrays.asList(4, 5, 6);
        List bottomRow = Arrays.asList(7, 8, 9);
        List leftCol = Arrays.asList(1, 4, 7);
        List middleCol = Arrays.asList(2, 5, 8);
        List rightCol = Arrays.asList(3, 6, 9);
        List cross1 = Arrays.asList(1, 5, 9);
        List cross2 = Arrays.asList(7, 5, 3);

        List<List> winning = new ArrayList<List>();
        winning.add(topRow);
        winning.add(middleRow);
        winning.add(bottomRow);
        winning.add(leftCol);
        winning.add(middleCol);
        winning.add(rightCol);
        winning.add(cross1);
        winning.add(cross2);

        for (List l : winning) {
            if (playerPostions.containsAll(l)) {
                return "Congratulation u win";
            } else if (cpuPostions.containsAll(l)) {
                return "U lose HAHAHA!";
            } else if (playerPostions.size() + cpuPostions.size() == 9) {
                return "TIE";
            }
        }
        return "";
    }

    public static void printGameBoard(char[][] gameBoard) {
        for (char[] row : gameBoard) {
            for (char c : row) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    public static void placePiece(char[][] gameBoard, int pos, String user) {
        char symbol = ' ';
        if (user.equals("player")) {
            symbol = 'X';
            playerPostions.add(pos);
        } else if (user.equals("cpu")) {
            symbol = 'O';
            cpuPostions.add(pos);
        }

        switch (pos) {
            case 1:
                gameBoard[0][0] = symbol;
                break;
            case 2:
                gameBoard[0][2] = symbol;
                break;
            case 3:
                gameBoard[0][4] = symbol;
                break;
            case 4:
                gameBoard[2][0] = symbol;
                break;
            case 5:
                gameBoard[2][2] = symbol;
                break;
            case 6:
                gameBoard[2][4] = symbol;
                break;
            case 7:
                gameBoard[4][0] = symbol;
                break;
            case 8:
                gameBoard[4][2] = symbol;
                break;
            case 9:
                gameBoard[4][4] = symbol;
                break;
            default:
                break;

        }
    }
}