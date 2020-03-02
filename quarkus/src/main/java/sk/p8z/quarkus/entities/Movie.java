package sk.p8z.quarkus.entities;

import org.hibernate.annotations.Formula;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "movies", schema = "public", catalog = "docker")
public class Movie {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Integer id;
    @NotEmpty
    @Column(name = "title")
    private String title;
    @Column(name = "year")
    private Integer year;
    @Column(name = "length")
    private Integer length;
    @Column(name = "genres")
    private String genres;
    @Formula("lower(title)")
    @JsonbTransient
    private String lowercaseTitle;

    public Movie() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }

    public String getLowercaseTitle() {
        return lowercaseTitle;
    }
}
