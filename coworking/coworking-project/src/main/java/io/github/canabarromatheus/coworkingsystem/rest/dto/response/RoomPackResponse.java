package io.github.canabarromatheus.coworkingsystem.rest.dto.response;

import io.github.canabarromatheus.coworkingsystem.domain.enumeration.HiringType;
import lombok.*;

import javax.json.bind.annotation.JsonbPropertyOrder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonbPropertyOrder({ "id", "hiringType", "quantity", "expiration", "room" })
public class RoomPackResponse {
    private Long id;
    private HiringType hiringType;
    private Integer quantity;
    private Integer expiration;
    private RoomResponse room;
}
