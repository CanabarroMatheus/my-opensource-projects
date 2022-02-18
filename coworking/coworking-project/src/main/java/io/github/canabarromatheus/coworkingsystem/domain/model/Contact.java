package io.github.canabarromatheus.coworkingsystem.domain.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "contacts", schema = "public")
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String value;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "contact_types_id", referencedColumnName = "id")
    private ContactType contactType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    private Client client;
}
