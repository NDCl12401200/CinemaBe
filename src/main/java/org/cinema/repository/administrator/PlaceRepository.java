package org.cinema.repository.administrator;

import org.cinema.model.administrator.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource
public interface PlaceRepository extends JpaRepository<Place, Long> {
}
