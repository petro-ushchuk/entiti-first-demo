package pis.lab4.demo.model;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@Table(name = "film")
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    @Column(length = 1024)
    private String description;
    private String director;
    //private String company;
    @Column(name = "goverment_finance")
    private Boolean govermentFinance;
    private Timestamp releaseDate;
    private int runningTime;
    private String budget;
    @ManyToMany
    @JoinTable(name = "film_actors", joinColumns = @JoinColumn(name = "film_id"),
                inverseJoinColumns = @JoinColumn(name = "actor_id"))
    private Set<Actor> actors = new HashSet<>();
    @ManyToMany
    @JoinTable(name = "film_genres", joinColumns = @JoinColumn(name = "film_id"),
        inverseJoinColumns = @JoinColumn(name = "genre_id"))
    private Set<Genre> genres = new HashSet<>();

    public Film(String title, String description, String director, String company, Timestamp releaseDate, int runningTime, String budget) {
        this.title = title;
        this.description = description;
        this.director = director;
    //    this.company = company;
        this.releaseDate = releaseDate;
        this.runningTime = runningTime;
        this.budget = budget;
    }

    @Override
    public String toString() {
        return "Film{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", director='" + director + '\'' +
               // ", company='" + company + '\'' +
                ", releaseDate=" + releaseDate +
                ", runningTime=" + runningTime +
                ", budget='" + budget + '\'' +
                '}';
    }


}
