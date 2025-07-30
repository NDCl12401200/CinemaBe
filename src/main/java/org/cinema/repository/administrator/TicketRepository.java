package org.cinema.repository.administrator;

import org.cinema.model.administrator.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource
public interface TicketRepository extends JpaRepository<Ticket, Long> {
}
