package io.github.canabarromatheus.coworkingsystem.rest.dto.request;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class ClientRequest {
    private String name;
    private String cpf;
    private LocalDate birthdate;
    private List<ContactRequest> contacts;
}
