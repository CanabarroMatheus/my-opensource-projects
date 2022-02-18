package io.github.canabarromatheus.coworkingsystem.domain.repository;

import io.github.canabarromatheus.coworkingsystem.domain.model.Client;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ClientRepository implements PanacheRepository<Client> {
}
