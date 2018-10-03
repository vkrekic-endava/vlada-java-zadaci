/*
  ZADATAK4: Za uneti niz celih brojeva duzine n (koja se takođe unosi),
  sortirati niz, ispitati da li sadrži broj x i ispisati prvih 5 članova niza
  na standardni izlaz.
 */


package com.zadatak4;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * AUTOR: Vladimir Krekic
 */

class Niz {

    private static int duzinaNiza;
    private static Scanner scanner = new Scanner(System.in);
    private static int trazeniBroj;

    public static void main(String[] args) {

        //Unosi duzinu niza i ponavlja dok god korisnik ne unese integer
        boolean uslov = false;
        do {
            System.out.print("Unesite duzinu niza: ");
            try {
                duzinaNiza = scanner.nextInt();
                uslov = true;
            }catch (InputMismatchException e){
                System.out.println("Niste uneli broj!");
                scanner.nextLine();
            }
        }while (!uslov);

        int[] niz = new int[duzinaNiza];

        //Unosi clanove niza i ponavlja samo za one koji ne budu isptavno ineti
        for(int brojac1=0; brojac1<duzinaNiza; ){
            System.out.print("Unesite " + (brojac1+1) + ". clan niza (samo cele brojeve): ");
            try {
                niz[brojac1] = scanner.nextInt();
                brojac1++;
            }catch (InputMismatchException e){
                System.out.println("Niste uneli celobrojnu vrednost!");
                scanner.nextLine();
            }
        }

        //Unosi broj za pretragu i ponavlja sve dok ne bude unet integer
        uslov = false;
        do {
            System.out.print("Unesite broj za pretragu (ceo broj): ");
            try {
                trazeniBroj = scanner.nextInt();
                uslov = true;
            }catch (InputMismatchException e){
                System.out.println("Niste uneli celobrojnu vrednost!");
            }
        }while (!uslov);

        //Efikasnije sortiranje od mog koda
        Arrays.sort(niz);

        //Moj kod za BoubleSort
//        for (int brojac1 = 0; brojac1 < duzinaNiza - 1; brojac1++) {
//            for(int brojac2 = 0; brojac2 < duzinaNiza-1-brojac1; brojac2++){
//                if (niz[brojac2] > niz[brojac2 + 1]) {
//                    int temp = niz[brojac2];
//                    niz[brojac2] = niz[brojac2 + 1];
//                    niz[brojac2 + 1] = temp;
//                }
//            }
//        }

        //Poziva metod provera() i formira poruku na osnovu resenja metoda
        String poruka = (pronadji(niz, trazeniBroj))? "Broj " + trazeniBroj + " je clan niza" : "Broj " + trazeniBroj + " nije clan niza";
        System.out.println(poruka);

        //Ako je niz duzi od 5 clanova, stampa samo prvih 5
        int lngNiza = (duzinaNiza>5)? 5: duzinaNiza;
        for(int i=0; i<lngNiza; i++){
            System.out.println((i+1) + ". clan niza je " + niz[i]);
        }
    }

    //Pretrazuje niz
    private static boolean pronadji(int[] niz, int trazeniBroj) {
        for (int i = 0; i < duzinaNiza; i++) {
            if (niz[i] == trazeniBroj)
                return true;
        }
        return false;
    }

}


