package main;

import java.util.ArrayList;
import java.util.Scanner;

public class Java_netbeans_binus_fruits_case {

    public static void main(String[] args) {
        ArrayList<Fruit> fruits = new ArrayList();
        Scanner sc = new Scanner(System.in);
        int pilih = 0;
    
        do{
            System.out.println("=========================================");
            System.out.println("           pohStiurF");
            System.out.println("=========================================");
            System.out.println("  1. View Fruits ");
            System.out.println("  2. Insert Fruits");
            System.out.println("  3. Remove Movie");
            System.out.println("  4. EXIT");
            System.out.println("=========================================");
            System.out.print(" Type [ 1, 2, 3 or 4 ]: " );
            pilih = sc.nextInt();
        
            if ( pilih == 1 ){
                viewFruits( fruits );
            }else if ( pilih == 2 ){
                fruits = insertFruit( fruits );
            }else if ( pilih == 3 ){
                removeFruit( fruits );
            }else{
                pilih = 4;
                System.out.print("[ Wrong number try again ]");
                sc.nextLine();
            }
        }while( pilih != 4 );
    }

    private static ArrayList<Fruit> insertFruit(ArrayList<Fruit> f) {
        Scanner sc = new Scanner(System.in);
        String name, type;
        int price;
        
        //cek jumlah data
        if ( f.size() >= 5 ){
            System.out.println( "[ only 5 fruits can be collected ] Press enter to continue.." );
            sc.nextLine();
            sc.nextLine();
        }else{
            //cek panjang string
            boolean ok = false;
            do{ 
                System.out.print("Input fruits name [ length 3 - 15 char ]: ");
                name = sc.nextLine();

                if ( name.length() >= 3 || name.length() <= 15  ){
                    ok = true;
                }else{
                    System.out.println("[ type between 3 - 15 char ]: ");
                    ok = false;
                }

            } while ( ok == false );

            //cek type
            ok = false;
            do{ 
                System.out.print("Input fruit type [ Citrus / Berries / Tropical ]: ");
                type = sc.nextLine();

                if ( type.equals("Citrus") || 
                        type.equals("Berries") ||
                        type.equals("Tropical") ) {
                    ok = true;
                }else{
                    System.out.println("[ Wrong type ]");
                    ok = false;
                }
            } while ( ok == false );

            //cek price
            ok = false;
            do{ 
                System.out.print("Fruit price [ multiple of 1000 ]: ");
                price = sc.nextInt();

                if ( ( price % 1000 ) == 0 ){ 
                    ok = true;
                }else{
                    ok = false;
                }
            } while ( ok == false );

            f.add( new Fruit( name, type, price ));

            System.out.println( "[ "+ name +" added!  ] Press enter to continue.." );
            sc.nextLine();
            sc.nextLine();
        }
        
        return f;
    }

    private static void viewFruits( ArrayList<Fruit> f ) {
        Scanner sc = new Scanner(System.in);
        
        if ( f.size() == 0){
            System.out.println("[ No Fruits Available ] Press enter to continue..");
            sc.nextLine();
        }else{
            int num = 1;
            for(int i = 0; i < f.size(); i++ ) {
                System.out.println("No. "+ num++ ); 
                System.out.println("No. "+ f.get( i ).getName()  ); 
                System.out.println("No. "+ f.get( i ).getType() ); 
                System.out.println("No. "+ f.get( i ).getPrice() );
                System.out.println();
            }
            System.out.print("Press enter to continue..");
            sc.nextLine();
        }
    }

    private static void removeFruit(ArrayList<Fruit> f) {
        Scanner sc = new Scanner(System.in);
        int idx = 0, jumlah = 0, bayar = 0;
        boolean correct;
        
        //view fruits
        System.out.println("[ Type "+ ( f.size() + 1 ) +" to check out ]" );
        System.out.print("=================================================");
        System.out.println();
        System.out.printf("| %-3s| %-6s| %-20s| %-10s|", 
                "No. ", 
                "Name", 
                "Type", 
                "Price");
        System.out.println();
        System.out.print("=================================================");
        System.out.println();

        int num = 1;
        for(int i = 0; i < f.size(); i++ ) {
            System.out.printf("| %-3s| %-6s| %-20s| %-10s|", 
            num++ , 
            f.get(i).getName(), 
            f.get(i).getType(), 
            f.get(i).getPrice() );
            System.out.println();
        }

        System.out.print("=================================================");
        System.out.println();
        
        correct = true;
        do{ 
            System.out.print("Choose Fruit to be delete [ 1 - "+ f.size() +" ]: " );
            idx = sc.nextInt();
            
            if ( idx > 0 && idx <= f.size() ){ 
                f.remove( idx - 1 );
                correct = true;
            }else{
                correct = false;
            }
        } while ( correct == false );
        
        System.out.println( "[ Fruit deleted! ]. Press enter to continue.." );
        sc.nextLine();
        sc.nextLine();
    }
}
