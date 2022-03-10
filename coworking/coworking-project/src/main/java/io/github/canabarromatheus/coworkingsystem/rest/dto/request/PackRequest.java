package io.github.canabarromatheus.coworkingsystem.rest.dto.request;

import lombok.Data;

import java.util.Set;

@Data
public class PackRequest {
    private String title;
    private String price;
    private Set<RoomPackRequest> rooms;
}
