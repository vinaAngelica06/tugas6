import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.*;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.inject.Inject;


@Path("/product")
@ApplicationScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProductResource {

    @Inject
    Product entity ;

    @GET
    public List<PanacheEntityBase> getAll() {
        return Product.listAll();
    }

    @GET
    @Path("/{id}")
    public Product get(@PathParam("id") Long id) {
        return Product.findById(id);
    }
    @POST
    @Transactional
    public Response create(Product product) {
        Product.persist(product);
        return Response.ok(product).status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Response update(@PathParam("id") Long id, Product product){
        Product p = Product.findById(id);
        if (p == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        Product.persist(product);
        return Response.ok(product).build();
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response delete(@PathParam("id") Long id) {
        Product p = Product.findById(id);
        if (p == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        entity.delete();
        return Response.noContent().build();
    }

}