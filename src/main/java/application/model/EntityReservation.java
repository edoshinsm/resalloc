package application.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "reservations")
@SequenceGenerator(name = "reservation_seq", sequenceName="reservation_id_seq", allocationSize = 1)
@Getter
@Setter
public class EntityReservation {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reservation_seq")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "resource_id", nullable = false)
    private EntityResource resource;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private String status;
}
