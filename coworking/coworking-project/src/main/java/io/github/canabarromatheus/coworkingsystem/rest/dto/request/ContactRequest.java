package io.github.canabarromatheus.coworkingsystem.rest.dto.request;

import lombok.Data;

@Data
public class ContactRequest {
    private Long idType;
    private String value;
}
