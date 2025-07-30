package org.cinema.model.dto;
import lombok.Data;
import org.cinema.model.administrator.Salle;
@Data
public class SalleDto {
    private Long id;
    private String name;
    private int nombrePlaces;
    private CinemaDto cinemaDto;

    public static SalleDto from(Salle salle){
        SalleDto salleDto = new SalleDto();
        salleDto.setId(salle.getId());
        salleDto.setName(salle.getName());
        salleDto.setNombrePlaces(salle.getNombrePlaces());
        salleDto.setCinemaDto(CinemaDto.from(salle.getCinema()));
        salleDto.setId(salle.getId());
        salleDto.setId(salle.getId());
        return salleDto;
    }

}
