import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    public static String Red = "\u001B[31m";
    public static String Reset = "\u001B[0m";
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double salary, salaryToPay, taxPercentage, taxAmount;

        System.out.println("Monthly Salary Tax Rate for Residents (KHR)");
        System.out.println("============================================");

        while (true){
            System.out.print("Enter your monthly salary (Enter 0 to exit) : KHR ");
            try{
                salary=Double.parseDouble(scanner.nextLine());

                if(salary == 0){
                    System.out.println("Exited the progam. Good Bye!");
                    break;
                }

                if(salary<0){
                    System.out.println(Red+"Salary can not less than 0!"+Reset);
                    continue;
                }else {
                    if(salary<=1500000){
                        taxPercentage = 0;
                    } else if (salary<=2000000) {
                        taxPercentage = 5;
                    } else if (salary<=8500000) {
                        taxPercentage = 10;
                    } else if (salary<=12500000) {
                        taxPercentage = 15;
                    }else {
                        taxPercentage = 20;
                    }

                    taxAmount = salary*taxPercentage/100;
                    salaryToPay = salary - taxAmount;

                    DecimalFormat decimalFormat = new DecimalFormat("KHR #,##0.00");

                    System.out.println("============================================");
                    System.out.println("Tax on your salary is " + decimalFormat.format(taxAmount));
                    System.out.println("Your end salary is " + decimalFormat.format(salaryToPay));
                    System.out.println("============================================");

                }

            }catch (NumberFormatException e){
                System.err.println("Invalide input! Try Again!");
            }
        }
    }
}