/**
 * Napisati program za pogađanje slučajno generisanog broja u opsegu od 1 do 50.
 * Program treba da radi na sledeći način: Korisnik preko standardnog ulaza unosi jedan ceo broj.
 * Broj koji treba pogoditi generisati “random” u opsegu od 1 do 50.
 * Vrteti se u petlji dok ne pogodimo broj, ili budemo barem blizu (ako je razlika između brojeva 5 ili manja).
 * Taj deo sa proverom pogotka izdvojiti u zasebnu metodu, kojoj se kao argument prosleđuje broj koji tipujemo,
 * a povratna vrednost metode je 0 – ako smo pogodili, 1 – ako smo bili blizu, 2 – ako smo promašili.
 * U zavisnosti od rezultata pogađanja ispisati i odgovarajuću poruku.
 * Nakon odigrane partije proveriti da li korisnik zeli da prekine ili da nastavi igru.
 */

package com.zadatak2;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 * AUTOR: Vladimir Krekic
 */

class Pogadjanje {

    private static Scanner scanner = new Scanner(System.in);
    private static Random rnd= new Random();
    private static int broj;

    public static void main(String[] args) {

        while(true) {

            int pogodi = rnd.nextInt(50);

            System.out.print("Upisi broj izmedju 0 i 50: ");
            try {
                broj = scanner.nextInt();
                if(broj > 50 || broj <0){
                    System.out.println("Niste uneli broj izmedju 0 i 50");
                    continue;
                }
            }catch (InputMismatchException e){
                System.out.println("Niste uneli broj");
                scanner.nextLine();
                continue;
            }

            int rezultat = provera(pogodi, broj);

            if(rezultat==0){
                System.out.println("Pogodili ste");
                if (!ponovo())
                    break;
            }
            else if(rezultat==1){
                System.out.println("Blizu ste");
                if (!ponovo())
                    break;
            }
            else System.out.println("Niste pogodili. Pokusajte ponovo.");

        }

    }

    public static int provera(int rnd, int broj){
        if(rnd==broj)
            return 0;
        if(Math.abs(rnd-broj)<=5)
            return 1;
        return 2;
    }

    public static boolean ponovo(){
        System.out.println("Zelite li da igrate ponovo (d/n)");
        String izbor = scanner.next();
        if (izbor.equalsIgnoreCase("d"))
            return true;
        return false;
    }
}
