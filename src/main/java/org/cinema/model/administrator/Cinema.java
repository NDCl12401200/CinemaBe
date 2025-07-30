package org.cinema.model.administrator;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.cinema.model.dto.CinemaDto;
import org.cinema.model.dto.SalleDto;

import java.io.Serializable;
import java.util.Collection;
import java.util.stream.Collectors;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cinema /*implements Serializable*/ {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double longitude, altitude, latitude;
    private int nombreSalles;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "cinema")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Collection<Salle> salles;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ville")
    private Ville ville;

    public static Cinema from(CinemaDto cinemaDto) {
        Cinema cinema = new Cinema();
        cinema.setId(cinemaDto.getId());
        cinema.setName(cinemaDto.getName());
        cinema.setLongitude(cinemaDto.getLongitude());
        cinema.setAltitude(cinemaDto.getAltitude());
        cinema.setLatitude(cinemaDto.getLatitude());
        cinema.setNombreSalles(cinemaDto.getNombreSalles());
        return cinema;
    }
}
