package ØveKlasse;


import java.util.Scanner;

public class EksFraNett
{
    public static Scanner in = new Scanner(System.in);

    public static void main(String[] args)
    {
       while (true) {
          System.out.print("Number:");
          int n = in.nextInt();
          System.out.print("Line1:");
          in.nextLine();
          String r1 = in.nextLine();
          System.out.print("Line2:");
          String r2 = in.nextLine();
          System.out.println("Done "+r1);
          System.out.println("Done "+r2);
       }
    }
}
