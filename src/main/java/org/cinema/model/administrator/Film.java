package org.cinema.model.administrator;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.cinema.model.dto.FilmDto;

import java.time.LocalDate;
import java.util.Collection;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titre;
    private double duree;
    private String realisateur;
    private String description;
    private String photo;
    private LocalDate dateSortie;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "film")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Collection<Projection> projections;

    @ManyToOne(fetch = FetchType.LAZY)
    private Categorie categorie;

    public static Film from(FilmDto filmDto){
        Film film = new Film();
        film.setId(filmDto.getId());
        film.setTitre(filmDto.getTitre());
        film.setDuree(filmDto.getDuree());
        film.setRealisateur(filmDto.getRealisateur());
        film.setDescription(filmDto.getDescription());
        film.setPhoto(filmDto.getPhoto());
        film.setDateSortie(filmDto.getDateSortie());
        film.setCategorie(Categorie.from(filmDto.getCategorie()));
        return film;

    }
}
