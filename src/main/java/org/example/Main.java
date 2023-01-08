package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Mayin Tarlasi\n*************************************");
        int row,col;
        System.out.println("Oynamak istediginiz boyutlari giriniz.\nSatir sayisi giriniz...");
        row = input.nextInt();
        System.out.println("Sutun sayisi giriniz...");
        col = input.nextInt();
        MayinTarlasi mayinTarlasi = new MayinTarlasi(row,col);
        mayinTarlasi.runner();
    }


}