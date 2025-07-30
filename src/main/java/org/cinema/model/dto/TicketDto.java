package org.cinema.model.dto;

import lombok.Data;
import org.cinema.model.administrator.Place;
import org.cinema.model.administrator.Projection;
import org.cinema.model.administrator.Ticket;

import java.util.ArrayList;
import java.util.List;

@Data
public class TicketDto {
    private Long id;
    private String nomClient;
    private int codePayement;
    private List<Long> tickets;
    private double prix ;
    private boolean reserve;
    private PlaceDto placeDto;
    private ProjectionDto projectionDto;

   public static TicketDto from(Ticket ticket) {
        if (ticket == null) return null;
        TicketDto ticketDto = new TicketDto();
        ticketDto.setId(ticket.getId());
        ticketDto.setNomClient(ticket.getNomClient());
        ticketDto.setCodePayement(ticket.getCodeDePayement());
        ticketDto.setPrix(ticket.getPrix());
        ticketDto.setReserve(ticket.isReserve());
        ticketDto.setPlaceDto(PlaceDto.from(ticket.getPlace()));
        ticketDto.setProjectionDto(ProjectionDto.from(ticket.getProjection()));
        return ticketDto;

    }
}
