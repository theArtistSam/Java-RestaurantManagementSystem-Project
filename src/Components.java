// package FoodPandaaExd;

import java.io.*;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Components extends Main{
    public static Scanner input = new Scanner(System.in);
    public static String[][] ipAddress = {

        {"Sector", "G-10"},
        {"Soup Restaurant", "123.456.001"},
        {"Pizza Restaurant", "123.456.002"},
        {"Desi Restaurant", "123.456.003"},
        {" ", "123.456.004"},
        {" ", "123.456.005"},
        {" ", "123.456.006"},
        {" ", "123.456.007"},
//              For House in Sectors

        {"House No 1", "Street 1", "321.654.001"},
        {"House No 2","Street 1", "321.654.002"},
        {"House No 3","Street 1", "321.654.003"},
        {"House No 4","Street 1", "321.654.004"},
        {"House No 5", "Street 1", "321.654.005"},
//              Street 2:
        {"House No 1","Street 2","321.654.006"},
        {"House No 2","Street 2","321.654.007"},
        {"House No 3","Street 2","321.654.008"},
        {"House No 4","Street 2", "321.654.009"},
        {"House No 5","Street 2","321.654.010"},

        //  Street 3:
        {"House No 1","Street 3","321.654.011"},
        {"House No 2","Street 3","321.654.012"},
        {"House No 3","Street 3","321.654.013"},
        {"House No 4","Street 3","321.654.014"},
        {"House No 5","Street 3","321.654.015"},

//              Street 4:
        {"House No 1","Street 4","321.654.016"},
        {"House No 2","Street 4","321.654.017"},
        {"House No 3","Street 4","321.654.018"},
        {"House No 4","Street 4","321.654.019"},
        {"House No 5","Street 4","321.654.020"},

//              Street 5:
        {"House No 1","Street 5","321.654.021"},
        {"House No 2","Street 5","321.654.022"},
        {"House No 3","Street 5","321.654.023"},
        {"House No 4","Street 5","321.654.024"},
        {"House No 5","Street 5","321.654.025"}
    };
    public static void main(String[] args){

    /*String[][] food = my_Ip();
    System.out.println("Enter your house no like (House No 1)");
    String user = input.nextLine();
    System.out.println("Enter your street no like (Street 1)");
    String user2 = input.nextLine();
    String ip = "";
    String ipRes = "";

    for(int row = 0; row < 8; row++) {
        if(user.equalsIgnoreCase(food[row][1])){
            ipRes += food[row][2];
        }
    }
    System.out.println(ipRes);
    //user.equalsIgnoreCase();
    for (int row1 = 8; row1 < food.length; row1++) {
        if(user.equalsIgnoreCase(food[row1][0]) && user2.equalsIgnoreCase(food[row1][1])){
            ip += food[row1][2];
        }
    }*/
    //System.out.println(my_Ip());
    // System.out.println(ipLocationRes());

    // String  a= ipLocationRes("abc");
    // System.out.println(a);
}


//	Defining IPs Address of Different Restorounts in The Sector
//    Access it Through Index or File Handling
//    Feedbackk>>>>>>>>>>
public  static void myFed() throws Exception {
        
    Scanner input = new Scanner(System.in);

    System.out.print("Please give your Valuable Feedback\n" +
            "Thank You For Buying \n" +
            "Please Enter Name First \n");

    String name= input.nextLine();

    System.out.println("Enter The Name of Resturant You Want to give Feedback...");
    String res= input.nextLine();

    System.out.println("What would you like to say about the Resstaraunt: ");
    String  fed= input.nextLine();



    System.out.println("Your feed back has been Forwarded. Thank You...");

    try{
        File xyz= new File("feedback.txt");


        FileWriter fileWriter = new FileWriter("feedback.txt",true);
        fileWriter.write("Name: "+name+ "\n");

        fileWriter.write("Restaraunt Name: " +res+"\n");
        fileWriter.write("FeedBack given: "+ fed);
        fileWriter.write("\n");
        fileWriter.close();

    }
    catch(Exception e){
        System.out.println(e.getStackTrace());
    }

}
    public static String ipLocationHouse() {
//             String[][] ipAddress = {

//             {"Sector", "G-10"},
//             {"Soup Restaurant", "123.456.001"},
//             {"Pizza Restaurant", "123.456.002"},
//             {"Desi Restaurant", "123.456.003"},
//             {"", "123.456.004"},
//             {"", "123.456.005"},
//             {"", "123.456.006"},
//             {"", "123.456.007"},
// //              For House in Sectors

//             {"House No 1", "Street 1", "321.654.001"},
//             {"House No 2","Street 1", "321.654.002"},
//             {"House No 3","Street 1", "321.654.003"},
//             {"House No 4","Street 1", "321.654.004"},
//             {"House No 5", "Street 1", "321.654.005"},
// //              Street 2:
//             {"House No 1","Street 2","321.654.006"},
//             {"House No 2","Street 2","321.654.007"},
//             {"House No 3","Street 2","321.654.008"},
//             {"House No 4","Street 2", "321.654.009"},
//             {"House No 5","Street 2","321.654.010"},

//             //  Street 3:
//             {"House No 1","Street 3","321.654.011"},
//             {"House No 2","Street 3","321.654.012"},
//             {"House No 3","Street 3","321.654.013"},
//             {"House No 4","Street 3","321.654.014"},
//             {"House No 5","Street 3","321.654.015"},

// //              Street 4:
//             {"House No 1","Street 4","321.654.016"},
//             {"House No 2","Street 4","321.654.017"},
//             {"House No 3","Street 4","321.654.018"},
//             {"House No 4","Street 4","321.654.019"},
//             {"House No 5","Street 4","321.654.020"},

// //              Street 5:
//             {"House No 1","Street 5","321.654.021"},
//             {"House No 2","Street 5","321.654.022"},
//             {"House No 3","Street 5","321.654.023"},
//             {"House No 4","Street 5","321.654.024"},
//             {"House No 5","Street 5","321.654.025"}
//         };

       
        while(true){
            System.out.println("Enter your house no like (House No 1)");
            String user = input.nextLine();
            System.out.println("Enter your street no like (Street 1)");
            String user2 = input.nextLine();
            String ip = "";
            boolean isFound = false;
            for (int row1 = 8; row1 < ipAddress.length; row1++) {
                if(user.equalsIgnoreCase(ipAddress[row1][0]) && user2.equalsIgnoreCase(ipAddress[row1][1])){
                    ip += ipAddress[row1][2];
                    return ip;
                }

            }
            if(isFound == false){
                System.out.println("Invalid House and Street No.");
            }    
        }
        
        //System.out.println(ip);
        

    }
    public static String ipLocationRes(String user) throws Exception {
            

       // boolean isEmpty = false;
       
            String ip = "";
            int temp1 = Main.get_lines("restauraunt_login_data.txt")/4;
            ipAddress[temp1+1][0]= user;
            return ipAddress[temp1+1][1];

            // for (int row1 = 1; row1 < 8; row1++) {
            //     // System.out.println(ipAddress[row1][0]);
                
            //     // if(ipAddress[row1][0].equals(" ")){
            //     //     temp1 = row1; 
            //     //     System.out.println(temp1);
            //     //     ipAddress[temp1][0]= user; 

            //     //     break;
            //     // }
                    
            //     // } 
                
            //     return ipAddress[temp1][1];

            }
                
        
    
}

/*



    static void callMe(String[][] arr) {
        //For Displaying Matrix

        for (int row = 0; row < arr.length; row++) {
//            System.out.println("Element at index " + i + " = " + arr[i]);
            for (int col = 0; col < arr[row].length; col++)
                System.out.printf("%-30s", arr[row][col] + " ");

            System.out.println();

        }

    }
    //FeedBack Module Final Step...

    static void feedBack(){
        Scanner input = new Scanner(System.in);

        System.out.print(">>>>>>>>>>>>>Give Your FeedBack<<<<<<<<<<<<<<<\n" +
                            "Thank You For Buying ***Happy Meal\n" +
                            "Please Give Us You Kind Feedback Here: \n");

        String fed= input.nextLine();
        System.out.println("Thank You...");



    }

//    Module For Cancelation of Any Order:
    public static int cancel(int var){
        Scanner input = new Scanner(System.in);
       String a1= " Want To Cancel Any Order?>>> Press 1 \n" +
                            "        Or Want to Confirm? >>> Press 2         ";

        System.out.println(a1);
        String var1 = input.next();
        if(var1.equals("1")) {
            System.out.println("Enter Name  or ID of Your Order Here");

            System.out.println(input.next());
            var=-1;

        }

        else if(a1.equals("2")){

            System.out.println("We are Confirming Your Order...ASAP");
            System.exit(Integer.parseInt(a1));

        }


return var;
    }
*/
