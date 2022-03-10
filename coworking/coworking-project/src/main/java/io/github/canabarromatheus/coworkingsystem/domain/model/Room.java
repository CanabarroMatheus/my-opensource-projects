package io.github.canabarromatheus.coworkingsystem.domain.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "rooms", schema = "public")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column(name = "maximum_capacity")
    private Integer maximumCapacity;

    @Column
    private BigDecimal price;

    @OneToMany(mappedBy = "room")
    private Set<RoomPack> roomPacks;
}
