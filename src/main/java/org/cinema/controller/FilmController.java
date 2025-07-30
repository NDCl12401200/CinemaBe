package org.cinema.controller;

import org.cinema.model.administrator.Film;
import org.cinema.model.dto.FilmDto;
import org.cinema.repository.administrator.FilmRepository;
import org.cinema.service.administrator.FilmServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequestMapping("/api")
public class FilmController {
    private final FilmServices filmServices;

    @Autowired
    private FilmRepository filmRepository;

    @Autowired
    public FilmController(FilmServices filmServices) {
        this.filmServices = filmServices;
    }

    @GetMapping("/listFilms")
    public ResponseEntity<List<FilmDto>> getFilms(){
        List<Film> films= filmServices.getFilm();
        List<FilmDto> filmDtos = films.stream().map(FilmDto::from).toList();
        return new ResponseEntity<>(filmDtos, HttpStatus.OK);
    }

    @GetMapping(path= "/imageFilm/{id}", produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] image(@PathVariable (name ="id")Long id) throws Exception{
        Film f= filmRepository.findById(id).get();
        String photoName = f.getPhoto();
        File file = new File(System.getProperty("user.home")+"/cinema/images/"+photoName+".jpeg");
        Path path = Paths.get(file.toURI());
        return Files.readAllBytes(path);

    }
}
