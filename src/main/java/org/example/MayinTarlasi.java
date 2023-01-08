package org.example;

import java.util.Random;
import java.util.Scanner;

public class MayinTarlasi {
    int rowNumber, colNumber, size, success=0;
    int[][] map;
    int[][] board;
    boolean game = true;

    Random rnd = new Random();
    Scanner input = new Scanner(System.in);

    public MayinTarlasi(int rowNumber, int colNumber){
        this.rowNumber = rowNumber;
        this.colNumber = colNumber;
        this.map = new int[rowNumber][colNumber];
        this.board = new int[rowNumber][colNumber];
        this.size = rowNumber*colNumber;
    }
    public void runner(){
        int row, col;
        prepareGame();
        print(map);
        System.out.println("Oyun basladi");
        while (game){
            print(board);
            System.out.println("Row :");
            row = input.nextInt();
            System.out.println("Col :");
            col = input.nextInt();
            if (row < 0 || row >= rowNumber-1){
                System.out.println("Gecersiz koordinat");
                continue;
            }
            if (col < 0 || col >= colNumber){
                System.out.println("Gecersiz koordinat");
                continue;
            }
            if (map[row][col] != -1){
                check(row,col);
                success++;
                if (success == (size - (size/4))){
                    System.out.println("Basardiniz");
                    break;
                }
            }else {
                game = false;
                System.out.println("Game Over");
            }
        }
    }
    public void check(int r, int c){
        if (board[r][c] == 0) {
            if ((c < colNumber-1) && (map[r][c + 1]) == -1) {
                board[r][c + 1]++;
            }
            if ((r < rowNumber-1) &&  (map[r + 1][c]) == -1) {
                board[r + 1][c]++;
            }
            if ((r > 0) &&  (map[r - 1][c]) == -1) {
                board[r - 1][c]++;
            }
            if ((c > 0) &&  (map[r][c - 1]) == -1) {
                board[r][c - 1]++;
            }
            if (board[r][c] == 0){
                board[r][c] = -2;
            }
        }
    }

    public void prepareGame(){
        int randRow, randCol, count = 0;
        while (count != (size/4)){
            randRow = rnd.nextInt(rowNumber);
            randCol = rnd.nextInt(colNumber);
            if (map[randRow][randCol] != -1) {
                map[randRow][randCol] = -1;
            }
            count++;
        }
    }
    public void print(int[][] arr){
        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr[0].length; j++){
                    if (arr[i][j] >= 0){
                        System.out.print(" ");
                    }
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }

}
