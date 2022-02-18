package io.github.canabarromatheus.coworkingsystem.exception;

public class InvalidCPFException extends Exception {
    public InvalidCPFException() {
        super("CPF informado é inválido!");
    }
}
