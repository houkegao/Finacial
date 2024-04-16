package com.jovision.mix.event.api.constant;

import java.util.Scanner;

public class CompoundInterestCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 输入存款金额
        System.out.print("请输入存款金额: ");
        double deposit = scanner.nextDouble();

        // 输入年利率
        System.out.print("请输入年利率（例如1.75%表示为0.0175）: ");
        double interestRate = scanner.nextDouble();

        // 输入存款年数
        System.out.print("请输入存款年数: ");
        int years = scanner.nextInt();

        // 计算复利未来价值和总利息
        double futureValue = calculateFutureValue(deposit, interestRate, years);
        double totalInterestEarned = futureValue - deposit;

        // 显示结果
        System.out.printf("未来价值: %.2f\n", futureValue);
        System.out.printf("赚取的总利息: %.2f\n", totalInterestEarned);

        scanner.close();
    }

    // 计算复利未来价值
    private static double calculateFutureValue(double deposit, double interestRate, int years) {
        // 假设每年复利次数为365（对应每日复利）
        int compoundingPerYear = 365;
        double periods = years * compoundingPerYear;
        double futureValue = deposit * Math.pow(1 + interestRate / compoundingPerYear, periods);
        return Math.round(futureValue * 100) / 100; // 保留两位小数
    }
}