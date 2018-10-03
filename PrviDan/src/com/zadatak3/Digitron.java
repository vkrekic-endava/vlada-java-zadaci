/*ZADATAK3: Napisati program koji će predstavljati jednostavan digitron.
  Program treba da radi tako što korisnik unese dva cela broja, zatim kod operacije
  koju želi da izvrši (‘s’ – sabiranje, ‘o’ – oduzimanje, ‘m’ – množenje, ‘d’ – deljenje).
  Kao rezultat se očekuje ispisivanje rezultata te operacije nad unetim operandima.
  Sve operacije smestiti u posebne metode.
  Vrteti se u petlji, sve dok se za kod operacije ne unese nepostojeći kod.
 */

 package com.zadatak3;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * AUTOR: Vladimir Krekic
 */

class Digitron {

    private static long broj1;
    private static long broj2;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        boolean petlja = true;

        do {

            System.out.print("\nUnesite prvi broj: ");
            try {
                broj1 = scanner.nextLong();
            }catch (InputMismatchException e){
                System.out.println("Niste uneli broj!");
                scanner.nextLine();
                continue;
            }
            System.out.print("Unesite drugi broj: ");
            try {
                broj2 = scanner.nextLong();
            }catch (InputMismatchException e){
                System.out.println("Niste uneli broj!");
                scanner.nextLine();
                continue;
            }
            System.out.println("Izaberite operaciju\n‘s’ – sabiranje, ‘o’ – oduzimanje, ‘m’ – množenje, ‘d’ – deljenje");
            String izbor = scanner.next();

            switch (izbor) {
                case "s":
                    System.out.printf("Rezultat sabiranja brojeva %d i %d je %d", broj1, broj2, sabiranje(broj1, broj2));
                    petlja = ponovo();
                    break;
                case "o":
                    System.out.printf("Rezultat oduzimanja brojeva %d i %d je %d", broj1, broj2, oduzimanje(broj1, broj2));
                    petlja = ponovo();
                    break;
                case "m":
                    System.out.printf("Rezultat mnozenja brojeva %d i %d je %d", broj1, broj2, mnozenje(broj1, broj2));
                    petlja = ponovo();
                    break;
                case "d":
                    if (broj2 == 0){
                        System.out.println("Ne mozete deliti sa nulom");
                        petlja = ponovo();
                        break;
                    }else {
                        System.out.printf("Rezultat deljenja brojeva %d i %d je %f", broj1, broj2, deljenje(broj1, broj2));
                        petlja = ponovo();
                        break;
                    }
                default:
                    petlja = false;
            }
        }while(petlja);
    }

    private static long sabiranje(long broj1, long broj2){
        return broj1+broj2;
    }

    private static long oduzimanje(long broj1, long broj2){
        return broj1-broj2;
    }

    private static long mnozenje(long broj1, long broj2){
        return broj1*broj2;
    }

    private static double deljenje(long br1, long br2){
            return (double) br1/br2;
    }

    private static boolean ponovo(){
        System.out.println("\nZelite li ponovo da racunate (d/n)");
        String izbor = scanner.next();
        return izbor.equalsIgnoreCase("d");
    }
}
