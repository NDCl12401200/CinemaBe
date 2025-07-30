package org.cinema.repository.administrator;

import org.cinema.model.administrator.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CategorieRepository extends JpaRepository <Categorie, Long> {
}
