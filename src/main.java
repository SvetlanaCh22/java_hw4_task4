// Реализовать алгоритм перевода из инфиксной записи в постфиксную для арифметического выражения.
// Вычислить запись если это возможно.

// Чубченко Светлана

import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        // выводим все на английском, потому как не удалось победить
        // кракозябры в консоли windows
        // запросим у пользователя инфиксную запись
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter infix entry, for example 2 * ( 1 + 3 ) - ( 4 / 5 ): ");
        String infix = scanner.nextLine();
        // конвертируем в постфиксную
        String postfix = convert(infix);
        // выведем на экран
        System.out.println("Postfix entry: " + postfix);
        // пробуем вычислить постфиксный вариант
        System.out.println("Calculation: " + calc(postfix));
    }

    // вычисляем после конверсии
    private static String calc(String expression) {
        Calculator calc = new Calculator();
        try {
            // пробуем вычислить
            double result = calc.calculate(expression);
            return Double.toString(result);
        } catch (Exception e) {
            // выводим ошибку вычисления
            return e.getMessage();
        }

    }

    // конвертируем из инфиксной записи в постфиксную запись
    private static String convert(String expression) {
        Calculator calc = new Calculator();
        try {
            // пробуем конвертировать
            return calc.opn(expression.replaceAll(" ", ""));
        } catch (Exception e) {
            // выводим ошибку если она возникла
            return e.getMessage();
        }

    }
}

