package io.github.canabarromatheus.coworkingsystem.util;

import io.github.canabarromatheus.coworkingsystem.exception.InvalidCPFException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class CPFUtil {
    private CPFUtil() {
    }

    public static void validCpf(String cpf) throws InvalidCPFException {
        isNotSequenceCpf(cpf);
        validFirstDigit(cpf);
        validSecondDigit(cpf);
    }

    private static void validFirstDigit(String cpf) throws InvalidCPFException {
        char[] cpfChars = cpf.toCharArray();
        int sum = 0;
        for (int i = 0; i < 9; i++) sum = sum + (Integer.parseInt(String.valueOf(cpfChars[i])) * (10-i));
        int rest = (sum * 10) % 11 == 10 ? 0 : (sum * 10) % 11;
        if (rest != Integer.parseInt(String.valueOf(cpfChars[9]))) throw new InvalidCPFException();
    }

    private static void validSecondDigit(String cpf) throws InvalidCPFException {
        char[] cpfChars = cpf.toCharArray();
        int sum = 0;
        for (int i = 0; i < 10; i++) sum = sum + (Integer.parseInt(String.valueOf(cpfChars[i])) * (11-i));
        int rest = (sum * 10) % 11 == 10 ? 0 : (sum * 10) % 11;
        if (rest != Integer.parseInt(String.valueOf(cpfChars[10]))) throw new InvalidCPFException();
    }

    private static void isNotSequenceCpf(String cpf) throws InvalidCPFException {
        HashSet<Character> cpfChars = new HashSet<>(convertToObjectChar(cpf.toCharArray()));
        if (cpfChars.size() <= 1) throw new InvalidCPFException();
    }

    private static List<Character> convertToObjectChar(char[] cpfInChar) {
        ArrayList<Character> charObjectArray = new ArrayList<>();
        for (char c : cpfInChar) charObjectArray.add(c);
        return charObjectArray;
    }
}
