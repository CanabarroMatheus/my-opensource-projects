package io.github.canabarromatheus.coworkingsystem.rest.service;

import io.github.canabarromatheus.coworkingsystem.domain.repository.ContactTypeRepository;
import io.github.canabarromatheus.coworkingsystem.rest.dto.response.ContactTypeResponse;
import io.github.canabarromatheus.coworkingsystem.rest.service.mapper.ContactTypeMapper;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class ContactTypeService {
    ContactTypeRepository repository;

    @Inject
    public ContactTypeService(ContactTypeRepository repository) {
        this.repository = repository;
    }

    public List<ContactTypeResponse> findAll() {
        return repository.findAll()
                .list()
                .stream()
                .map(ContactTypeMapper::toResponse)
                .collect(Collectors.toList());
    }
}
