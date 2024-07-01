package com.bancodedados.atividadeindividual.utils;

public class CpfValidator {

    public static boolean isValid(String cpf) {
        if (cpf == null || cpf.length() != 11 || cpf.matches(cpf.charAt(0) + "{11}")) {
            return false;
        }

        try {
            int[] cpfArray = cpf.chars().map(c -> c - '0').toArray();
            int sum1 = 0, sum2 = 0;

            for (int i = 0; i < 9; i++) {
                sum1 += cpfArray[i] * (10 - i);
                sum2 += cpfArray[i] * (11 - i);
            }

            int digit1 = sum1 % 11 < 2 ? 0 : 11 - sum1 % 11;
            sum2 += digit1 * 2;
            int digit2 = sum2 % 11 < 2 ? 0 : 11 - sum2 % 11;

            return digit1 == cpfArray[9] && digit2 == cpfArray[10];
        } catch (Exception e) {
            return false;
        }
    }
}

