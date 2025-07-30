package org.cinema.service.administrator;

import org.cinema.model.administrator.Film;
import org.cinema.repository.administrator.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class FilmServices {

    private final FilmRepository filmRepository;

    @Autowired
    public FilmServices(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    public List<Film> getFilm () {
        return StreamSupport.stream(filmRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
     }

}
