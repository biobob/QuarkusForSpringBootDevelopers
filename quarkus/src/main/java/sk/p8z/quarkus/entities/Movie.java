package sk.p8z.quarkus.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Movie {
    @Id
    @GeneratedValue
    private int id;
    private String title;
    private int year;
    private int length;
    private String genres;

    public Movie() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return id == movie.id &&
                year == movie.year &&
                length == movie.length &&
                Objects.equals(title, movie.title) &&
                Objects.equals(genres, movie.genres);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, year, length, genres);
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", year=" + year +
                ", length=" + length +
                ", genres='" + genres + '\'' +
                '}';
    }
}
