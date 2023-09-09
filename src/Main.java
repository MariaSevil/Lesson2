public class Main {
    public static void main(String[] args) {
        float userInput = getUserFloatInput();
        System.out.println("Вы ввели: " + userInput);
    }

    public static float getUserFloatInput() {
        Scanner scanner = new Scanner(System.in);
        float userInput = 0.0f;
        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.print("Введите дробное число: ");
                userInput = Float.parseFloat(scanner.nextLine());
                validInput = true;
            } catch (NumberFormatException e) {
                System.out.println("Некорректный ввод. Введите дробное число.");
            }
        }

        return userInput;
    }
}
