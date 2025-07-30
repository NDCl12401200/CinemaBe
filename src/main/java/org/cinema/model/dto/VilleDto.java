package org.cinema.model.dto;

import lombok.Data;
import org.cinema.model.administrator.Ville;

import java.util.List;

@Data
public class VilleDto {
    private Long id;
    private String nom;
    private double longitude;
    private double latitude;
    private double altitude;
    private List<CinemaDto> cinemaDtoList;

    public static VilleDto from(Ville ville){
        VilleDto villeDto = new VilleDto();
        villeDto.setId(ville.getId());
        villeDto.setNom(ville.getNom());
        villeDto.setLongitude(ville.getLongitude());
        villeDto.setLatitude(ville.getLatitude());
        villeDto.setAltitude(ville.getAltitude());
        return villeDto;
    }
}
