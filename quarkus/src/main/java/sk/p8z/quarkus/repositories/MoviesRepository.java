package sk.p8z.quarkus.repositories;

import org.springframework.data.repository.CrudRepository;
import sk.p8z.quarkus.entities.Movie;

import java.util.List;

public interface MoviesRepository extends CrudRepository<Movie, Integer> {
    Movie findById(int id);

    List<Movie> findByTitle(String title);
}
