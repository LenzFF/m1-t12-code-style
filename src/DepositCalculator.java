import java.util.Scanner;

public class DepositCalculator  {

    final double yearRate = 0.06d;
    double calculateComplexPercent(double money, int years) {
        double pay = money * Math.pow((1 + yearRate / 12), 12 * years);

        return getRandomValue(pay, 2);
    }

    double calculatorSimplePercent(double amount, int depositPeriod) {
        return getRandomValue(amount + amount * yearRate * depositPeriod, 2);
    }

    double getRandomValue(double value, int places) {
        double scale = Math.pow(10, places);

        return Math.round(value * scale) / scale;
    }

    void doImportantJob() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:");

        int amount = scanner.nextInt();

        System.out.println("Введите срок вклада в годах:");
        int period = scanner.nextInt();

        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        int action = scanner.nextInt();

        double out = 0;

        if (action == 1) out = calculatorSimplePercent(amount, period);
        else if (action == 2) {
            out = calculateComplexPercent(amount, period);
        }

        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + out);
    }

    public static void main(String[] args) {
        new DepositCalculator().doImportantJob();
    }
}
