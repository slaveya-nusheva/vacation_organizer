package edu.vacation.organiser.repository;

import edu.vacation.organiser.model.TripType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TripTypeRepository extends JpaRepository<TripType, Long> {
}
