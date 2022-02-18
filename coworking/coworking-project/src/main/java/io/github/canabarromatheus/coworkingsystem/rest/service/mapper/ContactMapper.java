package io.github.canabarromatheus.coworkingsystem.rest.service.mapper;

import io.github.canabarromatheus.coworkingsystem.domain.model.Contact;
import io.github.canabarromatheus.coworkingsystem.domain.model.ContactType;
import io.github.canabarromatheus.coworkingsystem.rest.dto.request.ContactRequest;
import io.github.canabarromatheus.coworkingsystem.rest.dto.response.ContactResponse;

public class ContactMapper {
    private ContactMapper() {
    }

    public static Contact toEntity(ContactRequest request) {
        return Contact.builder()
                .value(request.getValue())
                .contactType(ContactType.builder()
                        .id(request.getIdType())
                        .build())
                .build();
    }

    public static ContactResponse toResponse(Contact entity) {
        return ContactResponse.builder()
                .id(entity.getId())
                .type(entity.getContactType().getTitle())
                .value(entity.getValue())
                .build();
    }
}
