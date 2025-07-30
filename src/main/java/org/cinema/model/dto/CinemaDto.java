package org.cinema.model.dto;
import lombok.Data;
import org.cinema.model.administrator.Cinema;
@Data
public class CinemaDto {
    private Long id;
    private String name;
    private double longitude, altitude, latitude;
    private int nombreSalles;
    public static CinemaDto from(Cinema cinema) {
        CinemaDto cinemaDto = new CinemaDto();
        cinemaDto.setId(cinema.getId());
        cinemaDto.setName(cinema.getName());
        cinemaDto.setLongitude(cinema.getLongitude());
        cinemaDto.setAltitude(cinema.getAltitude());
        cinemaDto.setLatitude(cinema.getLatitude());
        cinemaDto.setNombreSalles(cinema.getNombreSalles());
        return cinemaDto;
    }
}
