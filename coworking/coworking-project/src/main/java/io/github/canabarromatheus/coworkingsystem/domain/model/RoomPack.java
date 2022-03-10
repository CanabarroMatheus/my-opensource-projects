package io.github.canabarromatheus.coworkingsystem.domain.model;

import io.github.canabarromatheus.coworkingsystem.domain.enumeration.HiringType;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "rooms_packs", schema = "public")
public class RoomPack {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "hiring_type")
    private HiringType hiringType;

    @Column
    private Integer quantity;

    @Column
    private Integer expiration;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

    @ManyToOne
    @JoinColumn(name = "pack_id")
    private Pack pack;
}
