/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daa;

import java.util.Scanner;

/**
 *
 * @author Muhammad Afif AF
 */
public class Daa {

    /**
     * @param args the command line arguments
     */
    static int petak;
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Input");
        Scanner sc = new Scanner(System.in);
        petak = sc.nextInt();
        int arr[][] = new int[petak][petak];
        boolean arr2[][] = new boolean[petak][petak];
        for (int i = 0; i < petak; i++) {
            for (int j = 0; j < petak; j++) {
                System.out.println("Baris ke " + i);
                arr[i][j] = sc.nextInt();
                arr2[i][j] = false;
            }
        }
        for (int k = 0; k < petak; k++) {
            for (int l = 0; l < petak; l++) {
                System.out.print(arr[k][l] + " ");
            }
            System.out.println();
        }
        System.out.println("Solusi");
        cari(arr,arr2,petak);
        
    }
    
    static void cari(int arr[][],boolean[][] arr2,int petak) {
        int jalan = 0;
        for (int i = 0; i < petak; i++) {
            for (int j = 0; j < petak; j++) {
                if((i == 0 || j == 0 || i == petak-1 || j == petak-1) && arr[i][j] == 1) {
                    carilagi(arr,arr2,i,j,jalan);
//                    reset(arr2);
                }
                jalan = 0;
            }
        }
    }
    
    static void carilagi(int[][] arr, boolean[][] arr2, int i, int j, int jalan) {
        if(arr[i][j] == 1) {
            arr2[i][j] = true;
            if(jalan > 0){
                if(jalan == 1) {
                    System.out.print((i-1) + "," + (j-1) + " => ");
                }
                System.out.print(i + "," + j + " => ");
            }
            if(i+1 >= 0 && i+1 <= petak-1 && arr[i+1][j] == 1 && arr2[i+1][j] == false) {
                carilagi(arr,arr2,++i,j,++jalan);
            }
            else if(j+1 >= 0 && j+1 <= petak-1 && arr[i][j+1] == 1 && arr2[i][j+1] == false) {
                carilagi(arr,arr2,i,++j,++jalan);
            }
            else if(i-1 >= 0 && i-1 <= petak-1 && arr[i-1][j] == 1 && arr2[i-1][j] == false) {
                carilagi(arr,arr2,--i,j,++jalan);
            }
            else if(j-1 >= 0 && j-1 <= petak-1 && arr[i][j-1] == 1 && arr2[i][j-1] == false) {
                carilagi(arr,arr2,i,--j,++jalan);
            }
            else {
//                System.out.println("Sampai");
            }
        }
    }
    
    static void reset(boolean arr2[][]) {
        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                arr2[i][j] = false;
            }
        }
    }
}