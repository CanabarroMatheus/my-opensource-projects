package io.github.canabarromatheus.coworkingsystem.rest.dto.response;

import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClientResponse {
    private Long id;
    private String name;
    private String cpf;
    private LocalDate birthdate;
    private List<ContactResponse> contacts;
}
