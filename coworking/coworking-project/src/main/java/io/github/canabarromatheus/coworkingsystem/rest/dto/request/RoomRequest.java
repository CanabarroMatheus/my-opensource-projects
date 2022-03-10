package io.github.canabarromatheus.coworkingsystem.rest.dto.request;

import lombok.Data;

@Data
public class RoomRequest {
    private String name;
    private Integer maximumCapacity;
    private String price;
}
