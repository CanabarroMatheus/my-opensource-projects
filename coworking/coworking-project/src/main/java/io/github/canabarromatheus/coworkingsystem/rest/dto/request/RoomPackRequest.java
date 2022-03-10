package io.github.canabarromatheus.coworkingsystem.rest.dto.request;

import io.github.canabarromatheus.coworkingsystem.domain.enumeration.HiringType;
import lombok.Data;

@Data
public class RoomPackRequest {
    private Long idRoom;
    private HiringType hiringType;
    private Integer quantity;
    private Integer expiration;
}
