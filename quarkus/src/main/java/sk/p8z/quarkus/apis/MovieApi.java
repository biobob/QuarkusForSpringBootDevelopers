package sk.p8z.quarkus.apis;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sk.p8z.quarkus.entities.Movie;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

public interface MovieApi {
    @GetMapping
    ResponseEntity<List<Movie>> moviesGet(
            @RequestParam(name = "offset", value = "0", required = false) int offset,
            @RequestParam(name = "limit", value = "20", required = false) int limit);

    @GetMapping(path = "/movie/{id}")
    ResponseEntity<Movie> moviesMovieIdGet(@PathVariable int id);

    @PostMapping(path = "/movie")
    ResponseEntity<Movie> moviesMoviePost(@Valid Movie body);

    @GetMapping(path = "/{title}")
    ResponseEntity<List<Movie>> moviesTitleGet(@Valid @NotEmpty @NotBlank @PathVariable String title);
}
