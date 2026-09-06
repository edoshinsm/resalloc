package application.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "resources")
@SequenceGenerator(name = "resource_seq", sequenceName = "resource_id_seq", allocationSize = 1)
@Getter
@Setter
public class EntityResource {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "resource_seq")
    private Long id;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "resource", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EntityReservation> reservations = new ArrayList<>();
}