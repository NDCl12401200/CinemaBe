package org.cinema.service.administrator;

import jakarta.transaction.Transactional;
import org.cinema.model.administrator.*;
import org.cinema.repository.administrator.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

@Service
@Transactional

public class CinemaInitImpl implements IcinemaInitService{

    private final CinemaRepository cinemaRepositoty;
    private final CategorieRepository categorieRepository;
    private final FilmRepository filmRepository;
    private final PlaceRepository placeRepository;
    private final ProjectionRepository projectionRepository;
    private final SalleRepository salleRepository;
    private final SeanceRepository seanceRepository;
    private final TicketRepository ticketRepository;
    private final VilleRepository villeRepository;


    @Autowired
    public CinemaInitImpl(CinemaRepository cinemaRepository,
                          CategorieRepository categorieRepository,
                          FilmRepository filmRepository,
                          PlaceRepository placeRepository, ProjectionRepository projectionRepository, SalleRepository salleRepository, SeanceRepository seanceRepository,
                          TicketRepository ticketRepository, VilleRepository villeRepository) {
        this.categorieRepository = categorieRepository;
        this.cinemaRepositoty = cinemaRepository;
        this.filmRepository = filmRepository;
        this.placeRepository = placeRepository;
        this.projectionRepository = projectionRepository;
        this.salleRepository = salleRepository;
        this.seanceRepository = seanceRepository;
        this.ticketRepository = ticketRepository;
        this.villeRepository = villeRepository;
    }

    @Override
    public void initVilles() {
        Stream.of("Namur", "Bruxelle", "Anvers", "Charleroi").forEach(
                nomVille -> {
                    Ville ville = new Ville();
                    ville.setNom(nomVille);
                    villeRepository.save(ville);
                }
        );
    }

    @Override
    public void initCinemas() {
        villeRepository.findAll().forEach(ville -> {
            Stream.of("MegaRama", "IMAX", "FOUNOUN", "CHARAZ", "DAOULIZ")
                    .forEach(nameCinema -> {
                        Cinema cinema = new Cinema();
                        cinema.setName(nameCinema);
                        cinema.setNombreSalles(3+(int)(Math.random()*7));
                        cinema.setVille(ville);
                        cinemaRepositoty.save(cinema);
                    });
        });
    }

    @Override
    public void initSalles() {
        cinemaRepositoty.findAll().forEach(cinema -> {
            for(int i = 0; i<cinema.getNombreSalles(); i++) {
                Salle salle = new Salle();
                salle.setName("Salle "+(i+1));
                salle.setCinema(cinema);
                salle.setNombrePlaces(15+(int)(Math.random())*20);
                salleRepository.save(salle);
            }
        });
    }

    @Override
    public void initPlaces() {
        salleRepository.findAll().forEach(salle -> {
            for(int i=0; i<salle.getNombrePlaces();i++) {
                Place place = new Place();
                place.setNumero(i+1);
                place.setSalle(salle);
                placeRepository.save(place);
            }
        });
    }

    @Override
    public void initSeances() {
        DateFormat dateFormat = new SimpleDateFormat("HH:mm");
        Stream.of("12:00", "15:00", "17:00", "19:00", "21:00").forEach(s -> {
            Seance seance = new Seance();
            try {
                seance.setHeure(dateFormat.parse(s));
                seanceRepository.save(seance);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        });
    }

    @Override
    public void initCategories() {
        Stream.of("Histoire", "Actions", "Fiction", "Drama").forEach(cat -> {
            Categorie categorie = new Categorie();
            categorie.setName(cat);
            categorieRepository.save(categorie);
        });
    }

    @Override
    public void initFilms() {
        double[] durees = new double[] {1,1.5,2,2.5,3};
        List<Categorie> categories = categorieRepository.findAll();
        Stream.of("Game of trone", "Spider man", "Seigneur des anneaux", "Superman", "le roi lion", "Les 12 Hommes en coleres")
                .forEach(titreFilm -> {
                    Film film = new Film();
                    film.setTitre(titreFilm);
                    film.setDuree(durees[new Random().nextInt(durees.length)]);
                    film.setPhoto(titreFilm.replace(" ", ""));
                    film.setCategorie(categories.get(new Random().nextInt(categories.size())));
                    filmRepository.save(film);
                });
    }


    @Override
    public void initProjections() {
        double[] prices = new double[] {30,50,60,70,90,100};
        villeRepository.findAll().forEach(ville -> {
            ville.getCinemas().forEach(cinema -> {
                cinema.getSalles().forEach(salle -> {
                    filmRepository.findAll().forEach(film -> {
                        seanceRepository.findAll().forEach(seance -> {
                            Projection projection =new Projection();
                            projection.setDate(new Date());
                            projection.setFilm(film);
                            projection.setPrix(prices[new Random().nextInt(prices.length)]);
                            projection.setSalle(salle);
                            projection.setSeance(seance);
                            projectionRepository.save(projection);
                        });
                    });
                });
            });
        });
    }

    @Override
    public void initTickets() {
        projectionRepository.findAll().forEach(projection -> {
            projection.getSalle().getPlaces().forEach(place -> {
                Ticket ticket = new Ticket();
                ticket.setPlace(place);
                ticket.setPrix(projection.getPrix());
                ticket.setReserve(false);
                ticket.setProjection(projection);
                ticketRepository.save(ticket);
            });
        });
    }
}
