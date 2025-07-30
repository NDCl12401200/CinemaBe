package org.cinema.model.dto;

import lombok.Data;
import org.cinema.model.administrator.*;
import java.util.Date;

@Data
public class ProjectionDto {
    private Long id;
    private Date date;
    private double prix;
    private FilmDto filmDto;

    public static ProjectionDto from(Projection projection){
        ProjectionDto projectionDto = new ProjectionDto();
        projectionDto.setId(projection.getId());
        projectionDto.setDate(projection.getDate());
        projectionDto.setPrix(projection.getPrix());
        projectionDto.setFilmDto(FilmDto.from(projection.getFilm()));
        return projectionDto;
    }
}
