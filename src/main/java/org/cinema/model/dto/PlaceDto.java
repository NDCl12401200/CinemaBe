package org.cinema.model.dto;

import lombok.Data;
import org.cinema.model.administrator.Place;

@Data
public class PlaceDto {
    private Long id;
    private String nom;
    private double longitude;
    private double latitude;
    private double altitude;
    private int numero;
    private SalleDto salleDto;
    public static PlaceDto from(Place place){
        PlaceDto placeDto = new PlaceDto();
        placeDto.setId(place.getId());
        placeDto.setNom(place.getNom());
        placeDto.setLongitude(place.getLongitude());
        placeDto.setLatitude(place.getLatitude());
        placeDto.setAltitude(place.getAltitude());
        placeDto.setNumero(place.getNumero());
        placeDto.setSalleDto(SalleDto.from(place.getSalle()));
        return placeDto;
    }
}
