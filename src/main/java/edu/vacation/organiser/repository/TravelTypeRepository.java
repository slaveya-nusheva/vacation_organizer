package edu.vacation.organiser.repository;

import edu.vacation.organiser.model.TravelType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TravelTypeRepository extends JpaRepository<TravelType, Long> {
}
