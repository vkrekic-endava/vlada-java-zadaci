/**
 * ZADATAK4: Za uneti niz celih brojeva duzine n (koja se takođe unosi),
 * sortirati niz, ispitati da li sadrži broj x i ispisati prvih 5 članova niza
 * na standardni izlaz.
 */


package com.zadatak4;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * AUTOR: Vladimir Krekic
 */

class Niz {

    private static int duzinaNiza;
    private static int[] niz;
    private static Scanner scanner = new Scanner(System.in);
    private static int trazeniBroj;

    public static void main(String[] args) {

        boolean u1 = false;
        do {
            System.out.print("Unesite duzinu niza: ");
            try {
                duzinaNiza = scanner.nextInt();
                u1 = true;
            }catch (InputMismatchException e){
                System.out.println("Niste uneli broj!");
                scanner.nextLine();
            }
        }while (!u1);

        niz = new int[duzinaNiza];

        for(int i=0; i<duzinaNiza; ){
            System.out.print("Unesite " + (i+1) + ". clan niza: ");
            try {
                niz[i] = scanner.nextInt();
                i++;
            }catch (InputMismatchException e){
                System.out.println("Niste uneli broj!");
                scanner.nextLine();
            }
        }

        u1 = false;
        do {
            System.out.print("Unesite broj za pretragu: ");
            try {
                trazeniBroj = scanner.nextInt();
                u1 = true;
            }catch (InputMismatchException e){
                System.out.println("Niste uneli broj!");
            }
        }while (!u1);

        for (int i = 0; i < duzinaNiza - 1; i++) {
            for(int j = 0; j < duzinaNiza-1-i; j++)
            if (niz[j] > niz[j + 1]) {
                int temp = niz[j];
                niz[j] = niz[j + 1];
                niz[j + 1] = temp;
            }
        }

        String poruka = (pronadji(niz, trazeniBroj))? "Broj " + trazeniBroj + " je clan niza" : "Broj " + trazeniBroj + " nije clan niza";
        System.out.println(poruka);

        int lng = (duzinaNiza>5)? 5: duzinaNiza;
        for(int i=0; i<lng; i++){
            System.out.println((i+1) + ". clan niza je " + niz[i]);
        }
    }

    public static boolean pronadji(int[] niz, int trazeniBroj) {
        for (int i = 0; i < duzinaNiza; i++) {
            if (niz[i] == trazeniBroj)
                return true;
        }
        return false;
    }

}


