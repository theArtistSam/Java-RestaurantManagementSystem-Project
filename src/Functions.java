
/*
Name: Abdullah Mehdi    
Registration No: SP21-BCS-OO2
Java Project: Sam
*/
import java.io.*;
import java.sql.SQLOutput;
import java.util.*;
import java.lang.*;

public class Functions extends Main{
    public static Scanner input = new Scanner(System.in);
    public static String orderID = null;
    public static int availableSpace;
    public static String[][] soupRestaurant = new String[10][2];
    public static String[][] pizzaRestaurant = new String[10][2];
    public static String[][] desiRestaurant = new String[10][2];
    public static String[][] randomRestaurant4 = new String[10][2];
    public static String[][] randomRestaurant5 = new String[10][2];
    public static String[][] randomRestaurant6 = new String[10][2];
    public static String[][] randomRestaurant7 = new String[10][2];


    public static void main(String[] args) throws IOException {

        //
        // String[][] raw = soupRestaurant();
        // //printMatrix(raw, matrixLength(raw));

        // File myFile = new File("soupRestaurant.txt");
        // myFile.createNewFile();

        // FileWriter write = new FileWriter(myFile);
        // for(int i = 0; i < raw.length; i++){
        // for(int j = 0; j < raw[i].length; j++){
        // if(raw[i][j] == null){
        // continue;
        // }
        // else{
        // write.write(raw[i][j]+",");
        // }
        // }
        // write.write("\n");
        // }
        // write.close();

        // /*String[][] list = new String[5][];
        // int row = 0;
        // Scanner ip = new Scanner(myFile);
        // while (ip.hasNextLine()) {

        // String a = ip.nextLine();
        // list[row] = a.split(",");

        // row++;
        // }

        // printMatrix(list);*/

        // soupRestaurantMenu();
        // printMatrix(soupRestaurant(), matrixLength(soupRestaurant()));
        // System.out.println();
        // /*printMatrix(pizzaRestaurant());
        // System.out.println();
        // printMatrix(desiRestaurant());
        // System.out.println();
        // printMatrix(soupRestaurantDash());
        // System.out.println();
        // printMatrix(pizzaRestaurantDash());
        // System.out.println();
        // printMatrix(desiRestaurantDash());*/

        // String[][] restaurant = soupRestaurant();
        // String[][] receipt = orderGeneration();
        // //generatingReceipt(receipt,restaurant);
        // String[][] updated = updateItems(restaurant);
        // printMatrix(updated, matrixLength(updated));
    }

    public static String unique_order_id() {
        return orderID;
    }
    // public static String[][] read_rider(String filename) throws IOException {

    //     File myFile = new File(filename + ".txt");
    //     String[][] raw = x;

    //     String[][] list = new String[raw.length][1];
    //     int row = 0;
    //     Scanner ip = new Scanner(myFile);
    //     while (ip.hasNextLine()) {

    //         String a = ip.nextLine();
    //         list[row] = a.split(",");

    //         row++;
    //     }
    //     return list;
    // }

    public static String[][] reciept_file_reader(String filename, String[][] x) throws IOException {

        File myFile = new File(filename + ".txt");
        String[][] raw = x;

        String[][] list = new String[raw.length][1];
        int row = 0;
        Scanner ip = new Scanner(myFile);
        while (ip.hasNextLine()) {

            String a = ip.nextLine();
            list[row] = a.split(",");

            row++;
        }
        return list;
    }

    public static void rider_reader(String filename) throws IOException {

        try{

            int index_no = 0;
            File myFile = new File(filename + ".txt");
            int length = Main.get_lines(filename+".txt");
            String[] rider_array = new String[length];
            if(myFile.length() == 0){
                System.out.println("No Orders from this restaraunt Yet.");
            }else{



                Scanner ip = new Scanner(myFile);
                int line_no = 0;
                while (ip.hasNextLine()) {

                    String a = ip.nextLine();
                    rider_array[line_no] = a;line_no++;

                }


                String [] neat_output = rider_array[4].split(",");



                // System.out.println(neat_output.length);
                // System.out.println(Arrays.toString(neat_output));

                System.out.println("Name :"+ rider_array[3]);
                for (int i = 0; i < neat_output.length; i++) {

                    System.out.println("Food Item: "+neat_output[i]  );
                    System.out.println("Food Quantity: " +neat_output[++i] );
                    System.out.println("Food Price: " +neat_output[++i] );
                }

                // To find Index No
                for(int i = 3; i < rider_array.length; i++){
                    if(rider_array[i].equals("\n") || rider_array[i]== null|| rider_array[i].equals("")){
                        index_no = i+1;break;
                    }
                }

                String home_location = "";
                String home_address = rider_array[1];
                String user_order_id = rider_array[2];

                for(int row = 8; row < Components.ipAddress.length; row++){
                    for(int col = 0; col < Components.ipAddress[row].length; col++){
                        if(Components.ipAddress[row][2].equals(home_address)){
                            home_location += (Components.ipAddress[row][0] +" " + Components.ipAddress[row][1]); break; // Mehdi ke hisab se error
                        }
                    }

                }

                System.out.println("Deliver the order at: " + home_location);
                System.out.println("User's order ID is: " + user_order_id);

                FileWriter myWriter = new FileWriter(filename+".txt");
                for(int i = index_no; i<rider_array.length ; i++ ){
                    myWriter.write(rider_array[i]+"\n");
                }
                myWriter.close();

                // for(int i = 0; i < rider_array.length; i++){
                //     if(rider_array[0] == null){

                //     }
                // }
            }

        }catch(Exception e){
            System.out.println(e.getMessage()+"\n"+e.getStackTrace());}
    }

    public static void menu_file(String[][] raw2, String filename) throws IOException {
        String[][] raw = raw2;
        // printMatrix(raw, matrixLength(raw));

        File myFile = new File(filename + ".txt");

        FileWriter write = new FileWriter(myFile);
        int lengthRaw = matrixLength(raw);
        for (int i = 0; i < lengthRaw; i++) {
            for (int j = 0; j < raw[i].length; j++) {
                if (raw[i][j] == null) {
                    continue;
                } else {
                    write.write(raw[i][j] + ",");
                }
            }
            write.write("\n");
        }
        // write.write("\n\n");
        write.close();
    }

    public static void Receipt_file(String[][] raw2, String filename,String restaraunt_ip,String username_ip, String username) throws IOException {
        String[][] raw = raw2;

        // printMatrix(raw, matrixLength(raw));

        File myFile = new File(filename + ".txt");
        FileWriter write = new FileWriter(myFile,true);

        write.write(restaraunt_ip + "\n");
        write.write(username_ip + "\n");
        write.write(orderID + "\n");
        write.write(username + "\n");

        for (int i = 0; i < matrixLength(raw); i++) {
            for (int j = 0; j < raw[i].length; j++) {
                if (raw[i][j] == null) {
                    continue;
                } else {
                    write.write(raw[i][j] + ",");
                    // System.out.println(raw[i][j]);
                }
            }
        }

        write.write("\n\n");
        // write.write("\n\n");
        write.close();
    }

    public static void soupRestaurantMenu() {
        System.out.println("---------- Soup Restaurant ---------");
        System.out.println("    Soups                    Price       ");
        System.out.println("------------------------------------ ");
    }


    public static String[][] randomRestaurant4() {

        return randomRestaurant4;
    }

    public static String[][] randomRestaurant5() {
        String[][] randomRestaurant5 = new String[10][2];
        return randomRestaurant5;
    }

    public static String[][] randomRestaurant6() {
        String[][] randomRestaurant6 = new String[10][2];
        return randomRestaurant6;
    }

    public static String[][] randomRestaurant7() {
        String[][] randomRestaurant7 = new String[10][2];
        return randomRestaurant7;
    }

    public static String[][] soupRestaurant() {

        soupRestaurant[0][0] = "Hot and Sour Soup";
        soupRestaurant[0][1] = "200";
        soupRestaurant[1][0] = "Chicken Corn Soup";
        soupRestaurant[1][1] = "220";
        soupRestaurant[2][0] = "Chicken Salsa Soup";
        soupRestaurant[2][1] = "250";
        soupRestaurant[3][0] = "Special Corn Soup";
        soupRestaurant[3][1] = "300";
        soupRestaurant[4][0] = "Vegetable Corn Soup";
        soupRestaurant[4][1] = "270";
        soupRestaurant[5][0] = "Something Special";
        soupRestaurant[5][1] = "300";
        return soupRestaurant;
    }

    public static void pizzaRestaurantMenu() {
        System.out.println("---------- Pizza Restaurant --------");
        System.out.println("    Pizzas                   Price       ");
        System.out.println("------------------------------------ ");
    }

    public static String[][] pizzaRestaurant() {


        pizzaRestaurant[0][0] = "Italian Pizza";
        pizzaRestaurant[0][1] = "1700";
        pizzaRestaurant[1][0] = "Pepperoni Pizza";
        pizzaRestaurant[1][1] = "1500";
        pizzaRestaurant[2][0] = "Tikka Pizza";
        pizzaRestaurant[2][1] = "1300";
        pizzaRestaurant[3][0] = "Fajita Pizza";
        pizzaRestaurant[3][1] = "1800";
        pizzaRestaurant[4][0] = "Vegetable Pizza";
        pizzaRestaurant[4][1] = "1600";
        return pizzaRestaurant;
    }

    public static void desiRestaurantMenu() {
        System.out.println("---------- Desi Restaurant ---------");
        System.out.println("    Food                     Price       ");
        System.out.println("------------------------------------ ");
    }

    public static String[][] desiRestaurant() {

        desiRestaurant[0][0] = "Chicken Karahi";
        desiRestaurant[0][1] = "1000";
        desiRestaurant[1][0] = "Chicken Chest Piece";
        desiRestaurant[1][1] = "220";
        desiRestaurant[2][0] = "Chicken Leg Piece";
        desiRestaurant[2][1] = "200";
        desiRestaurant[3][0] = "Chicken Tikka";
        desiRestaurant[3][1] = "150";
        desiRestaurant[4][0] = "Chicken Seekh Kabab";
        desiRestaurant[4][1] = "130";
        return desiRestaurant;
    }

    public static void soupRestaurantDashMenu() {
        System.out.println("----- Soup Restaurant Dashboard -----");
        System.out.println("    Data                  Items       ");
        System.out.println("------------------------------------ ");
    }

    public static String[][] soupRestaurantDash() {
        String[][] soupRestaurantDash = new String[10][2];
        soupRestaurantDash[0][0] = "[0] Orders Today    ";
        soupRestaurantDash[0][1] = "0";
        soupRestaurantDash[1][0] = "[1] Orders Cancelled";
        soupRestaurantDash[1][1] = "0";
        soupRestaurantDash[2][0] = "[2] Total Revenue   ";
        soupRestaurantDash[2][1] = "0";

        return soupRestaurantDash;
    }

    public static void pizzaRestaurantDashMenu() {
        System.out.println("----- Pizza Restaurant Dashboard -----");
        System.out.println("    Data                 Items       ");
        System.out.println("------------------------------------ ");
    }

    public static String[][] pizzaRestaurantDash() {
        String[][] pizzaRestaurantDash = new String[10][2];
        pizzaRestaurantDash[0][0] = "[0] Orders Today    ";
        pizzaRestaurantDash[0][1] = "0";
        pizzaRestaurantDash[1][0] = "[1] Orders Cancelled";
        pizzaRestaurantDash[1][1] = "0";
        pizzaRestaurantDash[2][0] = "[2] Total Revenue   ";
        pizzaRestaurantDash[2][1] = "0";
        return pizzaRestaurantDash;
    }

    public static void desiRestaurantDashMenu() {
        System.out.println("----- Desi Restaurant Dashboard -----");
        System.out.println("    Data                 Items       ");
        System.out.println("------------------------------------ ");
    }
    public static void randomRestaurantMenu() {
        System.out.println("    Items                    Price       ");
        System.out.println("------------------------------------ ");
    }


    public static String[][] desiRestaurantDash() {
        String[][] desiRestaurantDash = new String[10][2];
        desiRestaurantDash[0][0] = "[0] Orders Today    ";
        desiRestaurantDash[0][1] = "0";
        desiRestaurantDash[1][0] = "[1] Orders Cancelled";
        desiRestaurantDash[1][1] = "0";
        desiRestaurantDash[2][0] = "[2] Total Revenue   ";
        desiRestaurantDash[2][1] = "0";
        return desiRestaurantDash;
    }

    public static void orderGenerationMenu() {
        String items = "Items";
        String quantity = "Quantity";
        String price = "Price";
        System.out.println("----------------- Order -------------------");
        System.out.printf("%-1s%29s%52s", items, quantity, price + "\n------------------------------------------- ");
    }

    public static String[][] orderGeneration() {
        String[][] orderGeneration = new String[10][3];
        return orderGeneration;
    }

    public static String[][] generatingReceipt(String[][] raw, String[][] rawRes) {
        int price = 0;
        int user = 0;
        int amount = 0;
        int count = 0;
        int max = matrixLength(rawRes) - 1;
        while (true) {
            // System.out.println();
            int productPrice = 0;
            for (int row = 0; row < raw.length; row++) {
                try {
                    System.out.println("Enter your choice (Input ends with any negative number)");
                    user = input.nextInt();
                    if (user < 0) {
                        break;
                    }
                    if (user > max) {
                        System.out.println("Item not available. Try again!");
                        row = row - 1;
                        break;
                    }
                    System.out.println("Enter its quantity");
                    amount = input.nextInt();
                    if (amount < 0) {
                        System.out.println("Amount can never be -ve");
                        break;
                    }

                } catch (Exception ex) {
                    String str = input.next();
                    System.out.println("Input is in-valid. Try Again!");
                    if (row == 0) {
                        break;
                    } else {
                        row--;
                        count--;
                    }
                }
                if (user == 0) {
                    raw[row][0] = rawRes[0][0];
                    raw[row][1] = String.valueOf(amount);
                    raw[row][2] = String.valueOf(Integer.parseInt(rawRes[0][1]) * amount);
                    price += Integer.parseInt(rawRes[0][1]) * amount;
                    count++;
                } else if (user == 1) {
                    raw[row][0] = rawRes[1][0];
                    raw[row][1] = String.valueOf(amount);
                    raw[row][2] = String.valueOf(Integer.parseInt(rawRes[1][1]) * amount);
                    price += Integer.parseInt(rawRes[1][1]) * amount;
                    count++;
                } else if (user == 2) {
                    raw[row][0] = rawRes[2][0];
                    raw[row][1] = String.valueOf(amount);
                    raw[row][2] = String.valueOf(Integer.parseInt(rawRes[2][1]) * amount);
                    price += Integer.parseInt(rawRes[2][1]) * amount;
                    count++;
                } else if (user == 3) {
                    raw[row][0] = rawRes[3][0];
                    raw[row][1] = String.valueOf(amount);
                    raw[row][2] = String.valueOf(Integer.parseInt(rawRes[3][1]) * amount);
                    price += Integer.parseInt(rawRes[3][1]) * amount;
                    count++;
                } else if (user == 4) {
                    raw[row][0] = rawRes[4][0];
                    raw[row][1] = String.valueOf(amount);
                    raw[row][2] = String.valueOf(Integer.parseInt(rawRes[4][1]) * amount);
                    price += Integer.parseInt(rawRes[4][1]) * amount;
                    count++;
                } else if (user == 5) {
                    raw[row][0] = rawRes[5][0];
                    raw[row][1] = String.valueOf(amount);
                    raw[row][2] = String.valueOf(Integer.parseInt(rawRes[5][1]) * amount);
                    price += Integer.parseInt(rawRes[5][1]) * amount;
                    count++;
                } else if (user == 6) {
                    raw[row][0] = rawRes[6][0];
                    raw[row][1] = String.valueOf(amount);
                    raw[row][2] = String.valueOf(Integer.parseInt(rawRes[6][1]) * amount);
                    price += Integer.parseInt(rawRes[6][1]) * amount;
                    count++;
                } else if (user == 7) {
                    raw[row][0] = rawRes[7][0];
                    raw[row][1] = String.valueOf(amount);
                    raw[row][2] = String.valueOf(Integer.parseInt(rawRes[7][1]) * amount);
                    price += Integer.parseInt(rawRes[7][1]) * amount;
                    count++;
                } else if (user == 8) {
                    raw[row][0] = rawRes[8][0];
                    raw[row][1] = String.valueOf(amount);
                    raw[row][2] = String.valueOf(Integer.parseInt(rawRes[8][1]) * amount);
                    price += Integer.parseInt(rawRes[4][1]) * amount;
                    count++;
                } else if (user == 9) {
                    raw[row][0] = rawRes[9][0];
                    raw[row][1] = String.valueOf(amount);
                    raw[row][2] = String.valueOf(Integer.parseInt(rawRes[9][1]) * amount);
                    price += Integer.parseInt(rawRes[9][1]) * amount;
                    count++;
                }
                // System.out.println("counter is: "+ count);
            }
            if (user < 0) {
                break;
            }
        }

        System.out.println();
        if (count > 10) {
            count = 10;
        }
        do {
            try {
                System.out.println("Enter a credit card number as a long integer: ");
                long number = input.nextLong();

                // Checking for validity

                if (Static.isValid(number)) {
                    System.out.println(number + " is valid!");
                    break;
                } else
                    System.out.println(number + " is invalid!. Re-enter Card no.");
            } catch (InputMismatchException e) {
                System.out.println("Credit-card only consists of numbers!!!");
                input.nextLine();
            }
        } while (true);

        orderGenerationMenu();
        System.out.println("  ");
        printMatrix(raw, count);
        System.out.println();
        System.out.printf("Total price of your items is: %11d", price);
        orderID = Static.orderID();
        System.out.println("\nYour Order ID is: " + orderID);



        return raw;
    }

    public static int matrixLength(String[][] array) {
        int length = 0;
        for (int row = 0; row < array.length; row++) {
            for (int col = 0; col < array[row].length; col++) {
                if (array[row][col] == null) {
                    continue;
                } else {
                    length++;
                }
            }
        }
        length = length / 2;
        // System.out.println("length is: "+length);
        return length;
    }

    public static String[][] newItems(String[][] check) {
        if(check == soupRestaurant){
            availableSpace = (10 - matrixLength(Main.soupRestaurant));
        }
        else if(check == desiRestaurant){
            availableSpace = (10 - matrixLength(Main.desiRestaurant));
        }
        else if(check == pizzaRestaurant){
            availableSpace = (10 - matrixLength(Main.pizzaRestaurant));
        }
        else if(check == randomRestaurant4){
            availableSpace = (10 - matrixLength(Main.randomRestaurant4));
        }
        else if(check == randomRestaurant5){
            availableSpace = (10 - matrixLength(Main.randomRestaurant5));
        }
        else if(check == randomRestaurant6){
            availableSpace = (10 - matrixLength(Main.randomRestaurant6));
        }
        else if(check == randomRestaurant7){
            availableSpace = (10 - matrixLength(Main.randomRestaurant7));
        }
        while (true) {
            try {
                System.out.println("Would you like to add new items to your menu?\nPress [1] for YES and Press [2] for NO");
                int user = input.nextInt();
                if (user == 1) {
                    System.out.println("How many items would you like to add in the menu?");
                    int itemsLength = input.nextInt();
                    if (itemsLength > availableSpace) {
                        System.out.println("You cannot add " + itemsLength + " items in the menu!");
                        continue;
                    } else {
                        int count = 0;
                        int index = matrixLength(check);
                        System.out.println("---------- Current Menu ----------");
                        if(check == soupRestaurant){
                            printMatrix(Main.soupRestaurant, matrixLength(Main.soupRestaurant));
                        }
                        else if(check == desiRestaurant){
                            printMatrix(Main.desiRestaurant, matrixLength(Main.desiRestaurant));
                        }
                        else if(check == pizzaRestaurant){
                            printMatrix(Main.pizzaRestaurant, matrixLength(Main.pizzaRestaurant));
                        }
                        else if(check == randomRestaurant4){
                            printMatrix(Main.randomRestaurant4, matrixLength(Main.randomRestaurant4));
                        }
                        else if(check == randomRestaurant5){
                            printMatrix(Main.randomRestaurant5, matrixLength(Main.randomRestaurant5));
                        }
                        else if(check == randomRestaurant6){
                            printMatrix(Main.randomRestaurant6, matrixLength(Main.randomRestaurant6));
                        }
                        else if(check == randomRestaurant7){
                            printMatrix(Main.randomRestaurant7, matrixLength(Main.randomRestaurant7));
                        }
                        System.out.println();
                        while (count < itemsLength) {
                            for (int row = 0; row < check.length; row++) {
                                if (row >= index && row < (index + itemsLength)) {
                                    input.nextLine();
                                    System.out.println("Enter the item");
                                    String item = input.nextLine();
                                    if (item.equals(" ") || item.isEmpty()) {
                                        System.out.println("Input invalid. Try Again!");
                                        // gotta fix it!
                                        row = 11;
                                        break;
                                    }
                                    check[row][0] = item;
                                    try {
                                        System.out.println("Enter its price");
                                        int price = input.nextInt();
                                        check[row][1] = price + "";
                                        count++;
                                    } catch (Exception ex2) {
                                        String str = input.next();
                                        System.out.println("Input invalid. Enter again!");
                                        continue;
                                    }
                                }
                            }
                        }
                    }
                } else if (user == 2) {
                    break;
                } else if (user > 2) {
                    System.out.println("Input invalid. Enter again!");
                    continue;
                }
            } catch (Exception ex) {
                String str = input.next();
                System.out.println("Input invalid. Enter again!");
            }
        }
        return check;
    }

    public static String[][] updateItems(String[][] check) {
        while (true) {
            try {
                System.out.println("Would you like to update items of your menu?\nPress [1] for YES\nPress [2] for NO");
                int user = input.nextInt();
                if (user == 1) {
                    System.out.println("Press [1] to update all menu items\nPress [2] to update selected menu items");
                    int user2 = input.nextInt();
                    input.nextLine();
                    System.out.println("---------- Current Menu ----------");
                    if(check == soupRestaurant){
                        printMatrix(Main.soupRestaurant, matrixLength(Main.soupRestaurant));
                    }
                    else if(check == desiRestaurant){
                        printMatrix(Main.desiRestaurant, matrixLength(Main.desiRestaurant));
                    }
                    else if(check == pizzaRestaurant){
                        printMatrix(Main.pizzaRestaurant, matrixLength(Main.pizzaRestaurant));
                    }
                    else if(check == randomRestaurant4){
                        printMatrix(Main.randomRestaurant4, matrixLength(Main.randomRestaurant4));
                    }
                    else if(check == randomRestaurant5){
                        printMatrix(Main.randomRestaurant5, matrixLength(Main.randomRestaurant5));
                    }
                    else if(check == randomRestaurant6){
                        printMatrix(Main.randomRestaurant6, matrixLength(Main.randomRestaurant6));
                    }
                    else if(check == randomRestaurant7){
                        printMatrix(Main.randomRestaurant7, matrixLength(Main.randomRestaurant7));
                    }
                    System.out.println();
                    if (user2 == 1) {
                        System.out.println("How many items would you like to add throughout the menu?");
                        int count = input.nextInt();
                        if (count > 10) {
                            System.out.println("You cannot add more than 10 items in the menu");
                            continue;
                        }
                    
                        for (int row = 0; row < count; row++) {
                            for (int col = 0; col < check[row].length; col++) {
                                if (col == 0) {
                                    input.nextLine();
                                    System.out.println("Enter the menu items");
                                    String items = input.nextLine();
                                    if (items.equals(" ") || items.isEmpty()) {
                                        System.out.println("Input invalid. Try Again!");
                                        count--;
                                        continue;
                                    }
                                    check[row][col] = items;
                                } else if (col == 1) {
                                    try {
                                        System.out.println("Enter its price");
                                        int useritems = input.nextInt();
                                        check[row][col] = useritems + "";
                                    } catch (Exception e) {
                                        String str = input.next();
                                        System.out.println("Invalid Input. Try Again!");
                                        continue;
                                    }
                                }
                            }
                        }
                    } else if (user2 == 2) {
                        System.out.println("How many items would you like to add in the menu?");
                        int count = input.nextInt();
                        if (count > 10) {
                            System.out.println("You cannot add more than 10 items in the menu");
                            continue;
                        }
                        int counter = 0;
                        while (counter < count) {
                            try {
                                System.out.println("Enter the index to update the current item");
                                int newItem = input.nextInt();
                                if (newItem == 0) {
                                    System.out.println("Enter the item to update");
                                    input.nextLine();
                                    String newItems = input.nextLine();
                                    if (newItems.equals(" ") || newItems.isEmpty()) {
                                        System.out.println("Input invalid. Try Again!");
                                        counter--;
                                        continue;
                                    }
                                    check[0][0] = newItems;
                                    System.out.println("Enter its price");
                                    int newPrice = input.nextInt();
                                    check[0][1] = (newPrice + "");
                                    counter++;
                                } else if (newItem == 1) {
                                    System.out.println("Enter the item to update");
                                    input.nextLine();
                                    String newItems = input.nextLine();
                                    if (newItems.equals(" ") || newItems.isEmpty()) {
                                        System.out.println("Input invalid. Try Again!");
                                        counter--;
                                        continue;
                                    }
                                    check[1][0] = newItems;
                                    System.out.println("Enter its price");
                                    int newPrice = input.nextInt();
                                    check[1][1] = (newPrice + "");
                                    counter++;
                                } else if (newItem == 2) {
                                    System.out.println("Enter the item to update");
                                    input.nextLine();
                                    String newItems = input.nextLine();
                                    if (newItems.equals(" ") || newItems.isEmpty()) {
                                        System.out.println("Input invalid. Try Again!");
                                        counter--;
                                        continue;
                                    }
                                    check[2][0] = newItems;
                                    System.out.println("Enter its price");
                                    int newPrice = input.nextInt();
                                    check[2][1] = (newPrice + "");
                                    counter++;
                                } else if (newItem == 3) {
                                    System.out.println("Enter the item to update");
                                    input.nextLine();
                                    String newItems = input.nextLine();
                                    if (newItems.equals(" ") || newItems.isEmpty()) {
                                        System.out.println("Input invalid. Try Again!");
                                        counter--;
                                        continue;
                                    }
                                    check[3][0] = newItems;
                                    System.out.println("Enter its price");
                                    int newPrice = input.nextInt();
                                    check[3][1] = (newPrice + "");
                                    counter++;
                                } else if (newItem == 4) {
                                    System.out.println("Enter the item to update");
                                    input.nextLine();
                                    String newItems = input.nextLine();
                                    if (newItems.equals(" ") || newItems.isEmpty()) {
                                        System.out.println("Input invalid. Try Again!");
                                        counter--;
                                        continue;
                                    }
                                    check[4][0] = newItems;
                                    System.out.println("Enter its price");
                                    int newPrice = input.nextInt();
                                    check[4][1] = (newPrice + "");
                                    counter++;
                                } else if (newItem == 5) {
                                    System.out.println("Enter the item to update");
                                    input.nextLine();
                                    String newItems = input.nextLine();
                                    if (newItems.equals(" ") || newItems.isEmpty()) {
                                        System.out.println("Input invalid. Try Again!");
                                        counter--;
                                        continue;
                                    }
                                    check[5][0] = newItems;
                                    System.out.println("Enter its price");
                                    int newPrice = input.nextInt();
                                    check[5][1] = (newPrice + "");
                                    counter++;
                                } else if (newItem == 6) {
                                    System.out.println("Enter the item to update");
                                    input.nextLine();
                                    String newItems = input.nextLine();
                                    if (newItems.equals(" ") || newItems.isEmpty()) {
                                        System.out.println("Input invalid. Try Again!");
                                        counter--;
                                        continue;
                                    }
                                    check[6][0] = newItems;
                                    System.out.println("Enter its price");
                                    int newPrice = input.nextInt();
                                    check[6][1] = (newPrice + "");
                                    counter++;
                                } else if (newItem == 7) {
                                    System.out.println("Enter the item to update");
                                    input.nextLine();
                                    String newItems = input.nextLine();
                                    if (newItems.equals(" ") || newItems.isEmpty()) {
                                        System.out.println("Input invalid. Try Again!");
                                        counter--;
                                        continue;
                                    }
                                    check[7][0] = newItems;
                                    System.out.println("Enter its price");
                                    int newPrice = input.nextInt();
                                    check[7][1] = (newPrice + "");
                                    counter++;
                                } else if (newItem == 8) {
                                    System.out.println("Enter the item to update");
                                    input.nextLine();
                                    String newItems = input.nextLine();
                                    if (newItems.equals(" ") || newItems.isEmpty()) {
                                        System.out.println("Input invalid. Try Again!");
                                        counter--;
                                        continue;
                                    }
                                    check[8][0] = newItems;
                                    System.out.println("Enter its price");
                                    int newPrice = input.nextInt();
                                    check[8][1] = (newPrice + "");
                                    counter++;
                                } else if (newItem == 9) {
                                    System.out.println("Enter the item to update");
                                    input.nextLine();
                                    String newItems = input.nextLine();
                                    if (newItems.equals(" ") || newItems.isEmpty()) {
                                        System.out.println("Input invalid. Try Again!");
                                        counter--;
                                        continue;
                                    }
                                    check[9][0] = newItems;
                                    System.out.println("Enter its price");
                                    int newPrice = input.nextInt();
                                    check[9][1] = (newPrice + "");
                                    counter++;
                                } else if (newItem > 9) {
                                    System.out.println("You cannot add more than 10 items in the menu");
                                    continue;
                                }
                            } catch (Exception ER) {
                                String str = input.next();
                                System.out.println("Input invalid. Enter again!");
                                continue;
                            }
                        }
                    }
                } else if (user == 2) {
                    break;
                } else if (user > 2) {
                    System.out.println("Input invalid. Enter again!");
                    continue;
                }
            } catch (Exception E) {
                String str = input.next();
                System.out.println("Input invalid. Enter again!");
                continue;
            }
        }
        return check;
    }

    public static String[][] removeArrayElements(String[][] check) {
        String newArray[][] = new String[check.length - 1][2];
        while (true) {
            System.out.println("Would you like to remove an item from your menu?\nPress[1] for YES\nPress[2] for NO");
            try {
                int choice = input.nextInt();
                if (choice == 1) {
                    try {
                        System.out.println("---------- Current Menu ----------");
                        if(check == soupRestaurant){
                            printMatrix(Main.soupRestaurant, matrixLength(Main.soupRestaurant));
                        }
                        else if(check == desiRestaurant){
                            printMatrix(Main.desiRestaurant, matrixLength(Main.desiRestaurant));
                        }
                        else if(check == pizzaRestaurant){
                            printMatrix(Main.pizzaRestaurant, matrixLength(Main.pizzaRestaurant));
                        }
                        else if(check == randomRestaurant4){
                            printMatrix(Main.randomRestaurant4, matrixLength(Main.randomRestaurant4));
                        }
                        else if(check == randomRestaurant5){
                            printMatrix(Main.randomRestaurant5, matrixLength(Main.randomRestaurant5));
                        }
                        else if(check == randomRestaurant6){
                            printMatrix(Main.randomRestaurant6, matrixLength(Main.randomRestaurant6));
                        }
                        else if(check == randomRestaurant7){
                            printMatrix(Main.randomRestaurant7, matrixLength(Main.randomRestaurant7));
                        }
                        System.out.println();
                        System.out.println("Enter the index of item you wish to remove!");
                        int index = input.nextInt();
                        for (int row = 0, k = 0; row < check.length; row++) {
                            if (row == index) {
                                continue;
                            } else {
                                newArray[k++] = check[row];

                            }
                        }
                        break;
                    } catch (Exception ex) {
                        String str = input.next();
                        System.out.println("Invalid Input. Try again!");
                        break;
                    }
                } else if (choice == 2) {
                    break;
                } else if (choice > 2) {
                    System.out.println("There are only 2 choices!\nThink about it aye'");
                    continue;
                }
            } catch (Exception E) {
                String str = input.next();
                System.out.println("Invalid Input. Try again!");
                continue;
            }
        }
        return newArray;
    }

    public static void printMatrix(String[][] array, int length){
        // printing sum-ed matrix
        for(int row = 0; row < length; row++){
            for(int col = 0; col < array[row].length; col++){
                if(array[row][col] == null){
                    continue;
                }
                if(row >= 0 && col == 0){
                    System.out.printf("[%d] %-23s" , row , (array[row][col]) );
                }
                if(row >= 0 && col > 0){
                    System.out.printf("%7s" , array[row][col]);
                }
            }
            System.out.println();
        }
        //System.out.println();
    }

}