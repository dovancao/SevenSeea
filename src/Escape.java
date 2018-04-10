import java.util.Scanner;

public class Escape {
    public static void main(String[] args) {
        SevenSeea sevenSeea = new SevenSeea();
        Scanner keyboard = new Scanner(System.in);

        while (!sevenSeea.gameEnd){
            sevenSeea.print();
            System.out.print("Your command, enter F to shoot(fw,fs,fa,fd): ");
            String command = keyboard.nextLine();
            sevenSeea.runCommand(command);
        }
    }


}
