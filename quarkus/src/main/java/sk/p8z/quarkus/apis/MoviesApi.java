package sk.p8z.quarkus.apis;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sk.p8z.quarkus.entities.Movie;

import java.util.List;

@Tag(name = "movies")
public interface MoviesApi {
    @GetMapping(params = {"page", "size"})
    @Operation(summary = "Find all movies", description = "Find all movies")
    public Page<Movie> findAll(@RequestParam("page") int page, @RequestParam("size") int size);

    @GetMapping(path = "/movie/{id}")
    @Operation(summary = "Find movie by id")
    public Movie findById(@Parameter(name = "id", description = "Get a specific Todo by id", required = true) int id);

    @GetMapping(path = "/movie/{title}")
    @Operation(summary = "Find movie by title")
    public List<Movie> findByTitle(@Parameter(name = "title", description = "title", required = true) String title);
}
