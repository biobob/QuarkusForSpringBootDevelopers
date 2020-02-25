package sk.p8z.quarkus;


import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import sk.p8z.quarkus.entities.Movie;
import sk.p8z.quarkus.entities.dto.MovieDTO;
import sk.p8z.quarkus.repositories.MoviesRepository;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@RestController
@RequestMapping(value = "/movies", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
public class MoviesResource {
    private MoviesRepository moviesRepository;

    public MoviesResource(MoviesRepository moviesRepository) {
        this.moviesRepository = moviesRepository;
    }

//    @GetMapping(params = {"page", "size"})
//    public Page<Movie> findAll(@PathVariable(value = "5", required = false) int page,@PathVariable(value = "5", required = false) int size) {
//        return moviesRepository.findAll(PageRequest.of(page, size));
//    }

    @GetMapping(path = "/movie/{id}")
    public Movie findById(@PathVariable int id) {
        return moviesRepository.findById(id);
    }

    @GetMapping(path = "/{title}")
    public List<Movie> findByTitle(@Valid @NotEmpty @NotBlank @PathVariable String title) {
        return moviesRepository.findMoviesByLowercaseTitleContaining(title.toLowerCase());
    }

    @PostMapping(path = "/movie")
    public Movie saveMovie(@Valid @RequestBody MovieDTO movieDTO) {
        Movie movie = new Movie(movieDTO);
        return moviesRepository.save(movie);
    }
}
