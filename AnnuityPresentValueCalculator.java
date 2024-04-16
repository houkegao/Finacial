package com.jovision.mix.event.api.constant;

import java.util.Scanner;

public class AnnuityPresentValueCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 输入每月支付额
        System.out.print("请输入每月支付额: ");
        double monthlyPayout = scanner.nextDouble();

        // 输入预期年利率
        System.out.print("请输入预期年利率（例如2.5%表示为0.025）: ");
        double interestRate = scanner.nextDouble();

        // 输入支付年数
        System.out.print("请输入支付年数: ");
        int years = scanner.nextInt();

        // 转换年利率为每月利率
        double monthlyInterestRate = interestRate / 12 / 100;

        // 计算年金现值
        double presentValue = calculatePresentValueOfAnnuity(monthlyPayout, monthlyInterestRate, years);

        // 显示结果
        System.out.printf("年金的现值: %.2f\n", presentValue);

        scanner.close();
    }

    // 计算年金现值
    private static double calculatePresentValueOfAnnuity(double monthlyPayout, double monthlyInterestRate, int years) {
        double periods = years * 12; // 年数转换为月数
        double presentValue = monthlyPayout * (1 - Math.pow(1 + monthlyInterestRate, -periods)) / monthlyInterestRate;
        return Math.round(presentValue * 100) / 100; // 保留两位小数
    }
}