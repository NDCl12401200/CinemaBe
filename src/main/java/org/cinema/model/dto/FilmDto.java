package org.cinema.model.dto;
import lombok.Data;
import org.cinema.model.administrator.Film;
import java.time.LocalDate;
@Data
public class FilmDto {
    private Long id;
    private String titre;
    private double duree;
    private String realisateur;
    private String description;
    private String photo;
    private LocalDate dateSortie;
    private CategorieDto categorie;

    public static FilmDto from(Film film) {
        if (film == null) return null;

        FilmDto filmDto = new FilmDto();
        filmDto.setId(film.getId());
        filmDto.setTitre(film.getTitre());
        filmDto.setDuree(film.getDuree());
        filmDto.setRealisateur(film.getRealisateur());
        filmDto.setDescription(film.getDescription());
        filmDto.setPhoto(film.getPhoto());
        filmDto.setDateSortie(film.getDateSortie());
        filmDto.setCategorie(CategorieDto.from(film.getCategorie()));
        return filmDto;
    }


}
