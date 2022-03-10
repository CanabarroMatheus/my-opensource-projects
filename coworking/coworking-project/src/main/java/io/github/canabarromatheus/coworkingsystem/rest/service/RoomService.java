package io.github.canabarromatheus.coworkingsystem.rest.service;

import io.github.canabarromatheus.coworkingsystem.domain.repository.RoomRepository;
import io.github.canabarromatheus.coworkingsystem.rest.dto.request.RoomRequest;
import io.github.canabarromatheus.coworkingsystem.rest.dto.response.RoomResponse;
import io.github.canabarromatheus.coworkingsystem.rest.service.mapper.RoomMapper;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class RoomService {
    RoomRepository roomRepository;

    @Inject
    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public List<RoomResponse> findAll() {
        return this.roomRepository.findAll()
                .list()
                .stream()
                .map(RoomMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Transactional
    public void saveRoom(RoomRequest request) {
        this.roomRepository.persist(RoomMapper.toEntity(request));
    }
}
