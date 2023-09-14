import java.util.Scanner;
public class EmptyStringCheck {
    public static void main(String[] args) {
        try {
            String userInput = getUserInput();
            if (userInput.isEmpty()) {
                throw new Exception("Пустые строки вводить нельзя");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static String getUserInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите что-то: ");
        return scanner.nextLine();
    }
}
