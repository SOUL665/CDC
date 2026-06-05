import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        if(sc.hasNextInt()){
            int temp = sc.nextInt();
            
            if(temp < 0){
                System.out.println("Freezing weather");
            }
            else if (temp >= 0 && temp <= 9){
                System.out.println("Very cold weather");
            }
            else if (temp >= 10 && temp <= 19){
                System.out.println("Cold weather");
            }
            else if (temp >= 20 && temp <= 29){
                System.out.println("Normal in temperature");
            }
            else if (temp >= 30 && temp <= 39){
                System.out.println("Its hot");
            }
            else{
                System.out.println("Its very hot");
            }
        }
    }
}
