package io.github.canabarromatheus.coworkingsystem.domain.repository;

import io.github.canabarromatheus.coworkingsystem.domain.model.RoomPack;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class RoomPackRepository implements PanacheRepository<RoomPack> {
    public List<RoomPack> findAllById(Long idPack) {
        return find("pack.id", idPack).list();
    }
}
