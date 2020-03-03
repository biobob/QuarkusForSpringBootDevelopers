package sk.p8z.quarkus.apis;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sk.p8z.quarkus.entities.Movie;

import javax.validation.Valid;
import java.util.List;

public interface MovieApi {
    @GetMapping
    ResponseEntity<List<Movie>> moviesGet(
            @RequestParam(name = "offset", value = "0", required = false) int offset,
            @RequestParam(name = "limit", value = "20", required = false) int limit);

    @GetMapping(path = "/movie/{id}")
    ResponseEntity<Movie> moviesMovieIdGet(@PathVariable Integer id);

    @PostMapping(path = "/movie")
    ResponseEntity<Movie> moviesMoviePost(@Valid Movie body);

    @GetMapping(path = "/{title}")
    ResponseEntity<List<Movie>> moviesTitleGet(@PathVariable String title);
}
