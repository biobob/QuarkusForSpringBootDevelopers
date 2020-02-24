package sk.p8z.quarkus;


import org.jboss.resteasy.annotations.jaxrs.PathParam;
import sk.p8z.quarkus.entities.Movie;
import sk.p8z.quarkus.repositories.MoviesRepository;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;

@Path("/movies")
public class MoviesResource {
    private MoviesRepository moviesRepository;

    public MoviesResource(MoviesRepository moviesRepository) {
        this.moviesRepository = moviesRepository;
    }

    @GET
    @Produces("application/json")
    public Iterable<Movie> findAll() {
        return moviesRepository.findAll();
    }

    @GET
    @Path("/movie/{id}")
    @Produces("application/json")
    public Movie findById(int id) {
        return moviesRepository.findById(id);
    }

    @GET
    @Path("/movie/{title}")
    @Produces("application/json")
    public List<Movie> findByTitle(@PathParam String title) {
        return moviesRepository.findByTitle(title);
    }
}
