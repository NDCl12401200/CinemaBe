package org.cinema.model.administrator;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.cinema.model.dto.TicketDto;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ticket {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomClient;
    private double prix ;
    @Column(length = 65,unique = false, nullable = true)
    private Integer codeDePayement;
    private boolean reserve;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_place")
    private Place place;
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @JoinColumn(name = "id_projection")
    private Projection projection;

    public static Ticket from(TicketDto ticketDto) {
        Ticket ticket = new Ticket();
        ticket.setId(ticketDto.getId());
        ticket.setNomClient(ticketDto.getNomClient());
        ticket.setCodeDePayement(ticketDto.getCodePayement());
        ticket.setPrix(ticketDto.getPrix());
        ticket.setReserve(ticketDto.isReserve());
        ticket.setPlace(Place.from(ticketDto.getPlaceDto()));
        ticket.setProjection(Projection.from(ticketDto.getProjectionDto()));
        return ticket;

    }
}
