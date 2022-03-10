package io.github.canabarromatheus.coworkingsystem.rest.service.mapper;

import io.github.canabarromatheus.coworkingsystem.domain.model.Pack;
import io.github.canabarromatheus.coworkingsystem.domain.model.RoomPack;
import io.github.canabarromatheus.coworkingsystem.rest.dto.request.PackRequest;
import io.github.canabarromatheus.coworkingsystem.rest.dto.response.PackResponse;
import io.github.canabarromatheus.coworkingsystem.util.MoneyUtil;

import java.util.List;
import java.util.stream.Collectors;

public class PackMapper {
    private PackMapper() {
    }

    public static Pack toEntity(PackRequest request) {
        return Pack.builder()
                .title(request.getTitle())
                .price(MoneyUtil.convertMoneyToBigDecimal(request.getPrice()))
                .build();
    }

    public static PackResponse toResponse(Pack pack, List<RoomPack> roomPacks) {
        return PackResponse.builder()
                .id(pack.getId())
                .title(pack.getTitle())
                .price(MoneyUtil.convertBigDecimalToMoney(pack.getPrice()))
                .roomsPack(roomPacks.stream()
                        .map(RoomPackMapper::toResponse)
                        .collect(Collectors.toList()))
                .build();
    }
}
