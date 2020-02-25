package sk.p8z.quarkus.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import sk.p8z.quarkus.entities.Movie;

import java.util.List;

public interface MoviesRepository extends PagingAndSortingRepository<Movie, Integer> {
    Movie findById(int id);

    List<Movie> findMoviesByLowercaseTitleContaining(String title);
}
