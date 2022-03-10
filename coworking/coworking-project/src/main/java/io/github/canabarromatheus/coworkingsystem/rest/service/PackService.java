package io.github.canabarromatheus.coworkingsystem.rest.service;

import io.github.canabarromatheus.coworkingsystem.domain.model.Pack;
import io.github.canabarromatheus.coworkingsystem.domain.model.RoomPack;
import io.github.canabarromatheus.coworkingsystem.domain.repository.PackRepository;
import io.github.canabarromatheus.coworkingsystem.domain.repository.RoomPackRepository;
import io.github.canabarromatheus.coworkingsystem.rest.dto.request.PackRequest;
import io.github.canabarromatheus.coworkingsystem.rest.dto.response.PackResponse;
import io.github.canabarromatheus.coworkingsystem.rest.service.mapper.PackMapper;
import io.github.canabarromatheus.coworkingsystem.rest.service.mapper.RoomPackMapper;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class PackService {
    PackRepository packRepository;
    RoomPackRepository roomPackRepository;

    @Inject
    public PackService(PackRepository packRepository, RoomPackRepository roomPackRepository) {
        this.packRepository = packRepository;
        this.roomPackRepository = roomPackRepository;
    }

    @Transactional
    public void createPack(PackRequest request) {
        Pack pack = PackMapper.toEntity(request);
        packRepository.persist(pack);

        List<RoomPack> roomPacks = request.getRooms()
                .stream()
                .map(roomPack -> RoomPackMapper.toEntity(roomPack, pack.getId()))
                .collect(Collectors.toList());
        roomPacks.forEach(roomPack -> roomPackRepository.persist(roomPack));
    }

    public List<PackResponse> findAll() {
        return packRepository.findAll()
                .list()
                .stream()
                .map(pack -> {
                    List<RoomPack> roomPacks = roomPackRepository.findAllById(pack.getId());
                    return PackMapper.toResponse(pack, roomPacks);
                })
                .collect(Collectors.toList());
    }
}
