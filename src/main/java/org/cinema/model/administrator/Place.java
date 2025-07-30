package org.cinema.model.administrator;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.cinema.model.dto.PlaceDto;
import org.cinema.model.dto.SalleDto;
import org.cinema.model.dto.TicketDto;

import java.util.Collection;
import java.util.stream.Collectors;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Place {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private double longitude;
    private double latitude;
    private double altitude;
    private int numero;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_salle")
    private Salle salle;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "place")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Collection<Ticket> tickets;

    public static Place from(PlaceDto placeDto){
        Place place = new Place();
        place.setId(placeDto.getId());
        place.setNom(placeDto.getNom());
        place.setLongitude(placeDto.getLongitude());
        place.setLatitude(placeDto.getLatitude());
        place.setAltitude(placeDto.getAltitude());
        place.setNumero(placeDto.getNumero());
        place.setSalle(Salle.from(placeDto.getSalleDto()));
        return place;
    }
}
