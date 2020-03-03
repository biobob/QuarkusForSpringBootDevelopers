package sk.p8z.quarkus.resources;


import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sk.p8z.quarkus.apis.MovieApi;
import sk.p8z.quarkus.entities.Movie;
import sk.p8z.quarkus.repositories.MoviesRepository;

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
    public ResponseEntity<Movie> moviesMovieIdGet(Integer id) {
        return ResponseEntity.ok(moviesRepository.findById(id.intValue()));
    }

    @Override
    public ResponseEntity<Movie> moviesMoviePost(Movie body) {
        body.setId(null);
        return ResponseEntity.ok(moviesRepository.save(body));
    }

    @Override
    public ResponseEntity<List<Movie>> moviesTitleGet(String title) {
        return ResponseEntity.ok(moviesRepository.findMoviesByLowercaseTitleContaining(title.toLowerCase()));
    }
}
