package io.github.canabarromatheus.coworkingsystem.domain.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "contact_types", schema = "public")
public class ContactType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;

    @OneToMany(mappedBy = "contactType")
    private List<Contact> contacts;
}
