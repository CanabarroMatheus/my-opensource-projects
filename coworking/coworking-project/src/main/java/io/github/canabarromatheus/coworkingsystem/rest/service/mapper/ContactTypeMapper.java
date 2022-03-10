package io.github.canabarromatheus.coworkingsystem.rest.service.mapper;

import io.github.canabarromatheus.coworkingsystem.domain.model.ContactType;
import io.github.canabarromatheus.coworkingsystem.rest.dto.response.ContactTypeResponse;

public class ContactTypeMapper {
    private ContactTypeMapper() {
    }

    public static ContactTypeResponse toResponse(ContactType entity) {
        return ContactTypeResponse.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .build();
    }
}
