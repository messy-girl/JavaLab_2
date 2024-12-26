import java.util.regex.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[] testDates = {
                "29/02/2000",
                "30/04/2003",
                "01/01/2003",
                "29/02/2001",
                "30-04-2003",
                "1/1/1899"
        };

        // Регулярное выражение для проверки даты в формате dd/mm/yyyy
        // 1. Год от 1600 до 9999
        // 2. Месяцы от 01 до 12
        // 3. Дни от 01 до 31, в зависимости от месяца и года
        String regex = "^(0[1-9]|[12][0-9]|30)/(0[1-9]|1[0-2])/(\\d{4})$|" + // 30 дней
                "^(0[1-9]|1[0-9]|2[0-8])/(0[1-9]|1[0-2])/(\\d{4})$|" + // 28 дней
                "^29/02/(16|[2-9]\\d)0[48]$|29/02/(16|[2-9]\\d)([02468][048]|[13579][26])$"; // 29 февраля

        Pattern pattern = Pattern.compile(regex);

        for (String date : testDates) {
            Matcher matcher = pattern.matcher(date);
            if (matcher.matches()) {
                System.out.println(date + " - правильная дата");
            } else {
                System.out.println(date + " - неправильная дата");
            }
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите дату в формате dd/mm/yyyy: ");
        String userInput = scanner.nextLine();

        Matcher userMatcher = pattern.matcher(userInput);
        if (userMatcher.matches()) {
            System.out.println(userInput + " - правильная дата");
        } else {
            System.out.println(userInput + " - неправильная дата");
        }

        scanner.close();
    }
}