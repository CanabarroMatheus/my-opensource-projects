package io.github.canabarromatheus.coworkingsystem.rest.dto.response;

import lombok.*;

import javax.json.bind.annotation.JsonbPropertyOrder;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonbPropertyOrder({ "id", "title", "price", "roomsPack" })
public class PackResponse {
    private Long id;
    private String title;
    private String price;
    private List<RoomPackResponse> roomsPack;
}
