package io.github.canabarromatheus.coworkingsystem.rest.dto.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ContactResponse {
    private Long id;
    private String value;
    private String type;
}
