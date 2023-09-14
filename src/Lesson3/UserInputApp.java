import java.io.*;
import java.util.regex.*;
import java.util.*;

public class UserInputApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Введите данные (Фамилия Имя Отчество датарождения номертелефона пол):");
        String input = sc.nextLine();

        try {
            String[] parts = input.split(" ");
            if (parts.length != 6) {
                throw new DataFormatException("Вы ввели неправильное количество данных.");
            }

            String lastName = parts[0];
            String firstName = parts[1];
            String middleName = parts[2];
            String birthDate = parts[3];
            long phoneNumber = Long.parseLong(parts[4]);
            char gender = parts[5].charAt(0);

            if (!isValidDate(birthDate)) {
                throw new DataFormatException("Неверный формат даты рождения.");
            }

            if (gender != 'f' && gender != 'm') {
                throw new DataFormatException("Неверный формат пола.");
            }

            // Запись в файл
            File file = new File(lastName + ".txt");
            FileWriter fw = new FileWriter(file, true); // append mode
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write(lastName + firstName + middleName + birthDate + " " + phoneNumber + gender);
            bw.newLine();

            bw.close();
            fw.close();

            System.out.println("Данные успешно записаны.");

        } catch (NumberFormatException e) {
            System.out.println("Ошибка: неверный формат номера телефона.");
        } catch (DataFormatException e) {
            System.out.println("Ошибка: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Ошибка записи в файл:");
            e.printStackTrace();
        }
    }

    public static boolean isValidDate(String date) {
        Pattern pattern = Pattern.compile("^\\d{2}\\.\\d{2}\\.\\d{4}$");
        Matcher matcher = pattern.matcher(date);
        return matcher.matches();
    }
}
