package org.cinema.service.administrator;

import org.cinema.model.administrator.Cinema;
import org.cinema.repository.administrator.CinemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class CinemaService {

    private final CinemaRepository cinemaRepository;

    @Autowired
    public CinemaService(CinemaRepository cinemaRepository) {
        this.cinemaRepository = cinemaRepository;
    }

    public List<Cinema> getCinemas(){
        return StreamSupport.stream(cinemaRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public Cinema addCinema(Cinema cinema) {
        return cinemaRepository.save(cinema);
    }

}
