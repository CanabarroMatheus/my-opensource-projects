package io.github.canabarromatheus.coworkingsystem.rest.service.mapper;

import io.github.canabarromatheus.coworkingsystem.domain.model.Pack;
import io.github.canabarromatheus.coworkingsystem.domain.model.Room;
import io.github.canabarromatheus.coworkingsystem.domain.model.RoomPack;
import io.github.canabarromatheus.coworkingsystem.rest.dto.request.RoomPackRequest;
import io.github.canabarromatheus.coworkingsystem.rest.dto.response.RoomPackResponse;

public class RoomPackMapper {
    private RoomPackMapper() {
    }

    public static RoomPack toEntity(RoomPackRequest request, Long idPack) {
        return RoomPack.builder()
                .hiringType(request.getHiringType())
                .quantity(request.getQuantity())
                .expiration(request.getExpiration())
                .room(Room.builder().id(request.getIdRoom()).build())
                .pack(Pack.builder().id(idPack).build())
                .build();
    }

    public static RoomPackResponse toResponse(RoomPack entity) {
        return RoomPackResponse.builder()
                .id(entity.getId())
                .hiringType(entity.getHiringType())
                .quantity(entity.getQuantity())
                .expiration(entity.getExpiration())
                .room(RoomMapper.toResponse(entity.getRoom()))
                .build();
    }
}
