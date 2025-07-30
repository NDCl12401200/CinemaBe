package org.cinema.controller;

import org.cinema.model.administrator.Ticket;
import org.cinema.model.dto.TicketDto;
import org.cinema.repository.administrator.TicketRepository;
import org.cinema.service.administrator.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class TicketController {

//    @Autowired
//    private TicketService ticketService;

    @Autowired
    private TicketRepository ticketRepository;

    @PostMapping("/payerTickets")
    public List<TicketDto> payerTickets(@RequestBody TicketDto ticketDto) {
        List<TicketDto> listTicketDtos = new ArrayList<>();
        List<Ticket> listTickets = new ArrayList<>();
        ticketDto.getTickets().forEach(idTicket -> {
            Ticket ticket = ticketRepository.findById(idTicket).get();
            ticket.setReserve(true);
            ticket.setCodeDePayement(ticketDto.getCodePayement());
            ticket.setNomClient(ticketDto.getNomClient());
            ticketRepository.save(ticket);
            listTickets.add(ticket);
        });
        listTicketDtos = listTickets.stream().map(TicketDto::from).toList();
        return listTicketDtos;
    }



}

