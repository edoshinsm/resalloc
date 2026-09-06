package application.repositories;

import application.model.EntityReservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<EntityReservation, Long> {
}