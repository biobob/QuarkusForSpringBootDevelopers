package sk.p8z.quarkus.entities.dto;


import javax.annotation.Nullable;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class MovieDTO {
    @NotNull
    @NotEmpty
    private String title;
    @Nullable
    @Min(1900)
    private Integer year;
    @Nullable
    @Min(0)
    private Integer length;
    @Nullable
    private String genres;

    public MovieDTO() {
    }

    public MovieDTO(@NotNull @NotEmpty String title, @Nullable @Min(1900) Integer year, @Nullable @Min(0)
            Integer length, @Nullable String genres) {
        this.title = title;
        this.year = year;
        this.length = length;
        this.genres = genres;
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
}
