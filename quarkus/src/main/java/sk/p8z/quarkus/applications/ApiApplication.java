package sk.p8z.quarkus.applications;

import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Contact;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.info.License;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.ws.rs.core.Application;

@OpenAPIDefinition(
        tags = {@Tag(name = "movies", description = "Movies API.")},
        info = @Info(
                title = "MoviesAPI",
                version = "0.0.1",
                contact = @Contact(
                        name = "Who you gonna call",
                        email = "ghost@busters.com"),
                license = @License(
                        name = "Apache 2.0",
                        url = "http://www.apache.org/licenses/LICENSE-2.0.html"))
)
public class ApiApplication extends Application {
}
