package org.cinema.model.administrator;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.cinema.model.dto.SeanceDto;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Seance {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Temporal(TemporalType.TIME)
    private Date heure;

    public static Seance from(SeanceDto seanceDto){
        Seance seance = new Seance();
        seance.setId(seanceDto.getId());
        seance.setHeure(seanceDto.getHeure());
        return seance;
    }
}
