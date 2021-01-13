package pis.lab4.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.sql.Timestamp;

import static com.fasterxml.jackson.annotation.JsonProperty.Access.READ_ONLY;

@Data
public class FilmDto {

    @JsonProperty(access = READ_ONLY)
    private long id;
    private String title;
    private String description;
    private String director;
    private Boolean govermentFinance;
    private Timestamp releaseDate;
    private int runningTime;
    private String budget;
    private GenreDto genreDto;
}
