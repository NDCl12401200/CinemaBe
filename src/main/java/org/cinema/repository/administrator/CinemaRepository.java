package org.cinema.repository.administrator;

import org.cinema.model.administrator.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource
public interface CinemaRepository extends JpaRepository<Cinema, Long> {
    public Cinema findByName(String name);
}
