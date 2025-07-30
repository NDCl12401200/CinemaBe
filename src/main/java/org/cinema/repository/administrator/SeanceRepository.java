package org.cinema.repository.administrator;

import org.cinema.model.administrator.Seance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource
public interface SeanceRepository extends JpaRepository<Seance, Long> {
}
