import java.util.Scanner;

public class DepositCalculator  {

    final double yearRate = 0.06d;

    double calculateComplexPercent(double money, int years) {
        double pay = money * Math.pow((1 + yearRate / 12), 12 * years);

        return getValue(pay, 2);
    }

    double calculateSimplePercent(double money, int years) {
        double pay = money + money * yearRate * years;

        return getValue(pay, 2);
    }

    double getValue(double value, int places) {
        double scale = Math.pow(10, places);

        return Math.round(value * scale) / scale;

    }

    void runCalculator() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:");

        int amount = scanner.nextInt();

        System.out.println("Введите срок вклада в годах:");
        int period = scanner.nextInt();

        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        int type = scanner.nextInt();

        double result = 0;

        if (type == 1) result = calculateSimplePercent(amount, period);
        else if (type == 2) {
            result = calculateComplexPercent(amount, period);
        }

        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + result);
    }

    public static void main(String[] args) {
        new DepositCalculator().runCalculator();
    }
}
