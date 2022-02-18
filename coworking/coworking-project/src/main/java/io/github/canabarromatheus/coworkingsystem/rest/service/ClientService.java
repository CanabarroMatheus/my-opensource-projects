package io.github.canabarromatheus.coworkingsystem.rest.service;

import io.github.canabarromatheus.coworkingsystem.domain.model.Client;
import io.github.canabarromatheus.coworkingsystem.domain.model.Contact;
import io.github.canabarromatheus.coworkingsystem.domain.model.ContactType;
import io.github.canabarromatheus.coworkingsystem.domain.repository.ClientRepository;
import io.github.canabarromatheus.coworkingsystem.domain.repository.ContactRepository;
import io.github.canabarromatheus.coworkingsystem.domain.repository.ContactTypeRepository;
import io.github.canabarromatheus.coworkingsystem.exception.InvalidCPFException;
import io.github.canabarromatheus.coworkingsystem.rest.dto.request.ClientRequest;
import io.github.canabarromatheus.coworkingsystem.rest.dto.request.ContactRequest;
import io.github.canabarromatheus.coworkingsystem.rest.dto.response.ClientResponse;
import io.github.canabarromatheus.coworkingsystem.rest.service.mapper.ClientMapper;
import io.github.canabarromatheus.coworkingsystem.util.CPFUtil;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.PersistenceException;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class ClientService {
    ClientRepository clientRepository;
    ContactRepository contactRepository;
    ContactTypeRepository contactTypeRepository;

    @Inject
    public ClientService(ClientRepository clientRepository, ContactTypeRepository contactTypeRepository, ContactRepository contactRepository) {
        this.clientRepository = clientRepository;
        this.contactRepository = contactRepository;
        this.contactTypeRepository = contactTypeRepository;
    }

    public List<ClientResponse> findAll() {
        return clientRepository.findAll()
                .list()
                .stream()
                .map(ClientMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Transactional
    public void save(ClientRequest request) throws InvalidCPFException {
        if (!havePhoneNumberAndEmail(request)) throw new PersistenceException("Cliente precisa informar um telefone e um e-mail para ser cadastrado.");
        CPFUtil.validCpf(request.getCpf());
        Client client = ClientMapper.toEntity(request);
        List<Contact> contacts = new ArrayList<>(client.getContacts());
        client.setContacts(null);
        clientRepository.persist(client);
        contacts.forEach(contact -> {
            contact.setClient(Client.builder().id(client.getId()).build());
            contactRepository.persist(contact);
        });
    }

    private boolean havePhoneNumberAndEmail(ClientRequest request) {
        var validTypes = contactTypeRepository.findAll().list().stream()
                .filter(type -> type.getTitle().equals("telefone") || type.getTitle().equals("e-mail"))
                .map(ContactType::getId);
        return validTypes.allMatch(type -> {
                    var contactsIds = request.getContacts()
                            .stream()
                            .map(ContactRequest::getIdType)
                            .collect(Collectors.toList());
                    return contactsIds.contains(type);
                });
    }
}
