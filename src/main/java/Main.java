import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int friendCount;
        while (true) {
            System.out.println("На сколько человек необходимо разделить счет?");
            friendCount = scanner.nextInt();

            if (friendCount > 1) {
                break;
            } else if (friendCount == 1) {
                System.out.println(
                        "Нет смысла делить сумму на одного человека. Давайте попробуем ввести другое значение, которое будет больше единицы.");
            } else {
                System.out.println("Неверное количество друзей. Значение должно быть болье единицы, давайте попробуем еще раз.");
            }
        }

        Calculator calculator = new Calculator(friendCount);

        while (true) {
            System.out.println("Введите название товара");
            String name = scanner.next();

            System.out.println("Введите стоимость товара в формате: 'рубли.копейки' [10.45, 11.40]");
            double price = scanner.nextDouble();

            calculator.addItem(new Item(name, price));

            System.out.println(
                    "Хотите добавить еще один товар? Введите любой символ для продолжения, либо 'Завершить' если больше нет товаров для добавления");
            String answer = scanner.next();

            if (answer.equalsIgnoreCase("Завершить")) {
                break;
            }
        }

        double result = calculator.divideSum();
        Formatter formatter = new Formatter();

        System.out.println(calculator.cart);
        System.out.println("Каждому человеку к оплате: " + formatter.roundResult(result) + " " + formatter.formatValue(result));
    }
}
