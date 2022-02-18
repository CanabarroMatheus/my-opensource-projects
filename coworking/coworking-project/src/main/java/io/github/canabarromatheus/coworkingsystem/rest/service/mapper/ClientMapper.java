package io.github.canabarromatheus.coworkingsystem.rest.service.mapper;

import io.github.canabarromatheus.coworkingsystem.domain.model.Client;
import io.github.canabarromatheus.coworkingsystem.rest.dto.request.ClientRequest;
import io.github.canabarromatheus.coworkingsystem.rest.dto.response.ClientResponse;

import java.util.stream.Collectors;

public class ClientMapper {
    private ClientMapper() {
    }

    public static Client toEntity(ClientRequest request) {
        return Client.builder()
                .name(request.getName())
                .cpf(request.getCpf())
                .birthdate(request.getBirthdate())
                .contacts(request.getContacts()
                        .stream()
                        .map(ContactMapper::toEntity)
                        .collect(Collectors.toList()))
                .build();
    }

    public static ClientResponse toResponse(Client entity) {
        return ClientResponse.builder()
                .id(entity.getId())
                .name(entity.getName())
                .cpf(entity.getCpf())
                .birthdate(entity.getBirthdate())
                .contacts(entity.getContacts()
                        .stream()
                        .map(ContactMapper::toResponse)
                        .collect(Collectors.toList()))
                .build();
    }
}
