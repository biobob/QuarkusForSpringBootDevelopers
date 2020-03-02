package sk.p8z.quarkus.resources;


import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sk.p8z.quarkus.apis.MovieApi;
import sk.p8z.quarkus.entities.Movie;
import sk.p8z.quarkus.repositories.MoviesRepository;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@RestController
@RequestMapping(value = "/movies", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
public class MoviesResource implements MovieApi {

    private MoviesRepository moviesRepository;

    public MoviesResource(MoviesRepository moviesRepository) {
        this.moviesRepository = moviesRepository;
    }

    @Override
    public ResponseEntity<List<Movie>> moviesGet(int offset, int limit) {
        return ResponseEntity.ok(moviesRepository.findAll(PageRequest.of(offset, limit)).getContent());
    }

    @Override
    public ResponseEntity<Movie> moviesMovieIdGet(@RequestParam int id) {
        return ResponseEntity.ok(moviesRepository.findById(id));
    }

    @Override
    public ResponseEntity<Movie> moviesMoviePost(@Valid @RequestBody Movie body) {
        body.setId(null);
        return ResponseEntity.ok(moviesRepository.save(body));
    }

    @Override
    public ResponseEntity<List<Movie>> moviesTitleGet(@Valid @NotEmpty @NotBlank @PathVariable String title) {
        return ResponseEntity.ok(moviesRepository.findMoviesByLowercaseTitleContaining(title.toLowerCase()));
    }
}
