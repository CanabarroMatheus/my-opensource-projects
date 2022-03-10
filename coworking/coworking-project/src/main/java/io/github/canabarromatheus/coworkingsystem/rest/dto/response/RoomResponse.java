package io.github.canabarromatheus.coworkingsystem.rest.dto.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoomResponse {
    private Long id;
    private String name;
    private Integer maximumCapacity;
    private String price;
}
