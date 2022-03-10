package io.github.canabarromatheus.coworkingsystem.rest.service.mapper;

import io.github.canabarromatheus.coworkingsystem.domain.model.Room;
import io.github.canabarromatheus.coworkingsystem.rest.dto.request.RoomRequest;
import io.github.canabarromatheus.coworkingsystem.rest.dto.response.RoomResponse;
import io.github.canabarromatheus.coworkingsystem.util.MoneyUtil;

public class RoomMapper {
    private RoomMapper() {
    }

    public static Room toEntity(RoomRequest request) {
        return Room.builder()
                .name(request.getName())
                .maximumCapacity(request.getMaximumCapacity())
                .price(MoneyUtil.convertMoneyToBigDecimal(request.getPrice()))
                .build();
    }

    public static RoomResponse toResponse(Room room) {
        return RoomResponse.builder()
                .id(room.getId())
                .name(room.getName())
                .maximumCapacity(room.getMaximumCapacity())
                .price(MoneyUtil.convertBigDecimalToMoney(room.getPrice()))
                .build();
    }
}
