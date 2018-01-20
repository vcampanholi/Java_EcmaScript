package br.vandersoncamp.resources;import br.vandersoncamp.eplants.data.UsuarioBusiness;import br.vandersoncamp.eplants.model.Usuario;import javax.enterprise.context.RequestScoped;import javax.inject.Inject;import javax.ws.rs.*;import javax.ws.rs.core.*;import java.util.List;@Path("usuarios")@RequestScopedpublic class UsuarioResource {    @Inject    private UsuarioBusiness business;    @GET    @Path("{id}")    @Produces(MediaType.APPLICATION_JSON)    public Response buscar(@PathParam("id") Long id) {        Usuario usuario = business.buscar(id);        if (usuario == null) {            return Response.status(Response.Status.NOT_FOUND).build();        }        return Response.ok(usuario).build();    }    @GET    @Path("all")    @Produces(MediaType.APPLICATION_JSON)    public Response pesquisar(            @QueryParam("filterField") String filterField,            @QueryParam("filterValue") String filterValue,            @QueryParam("order") String order) {        return Response.ok(business.pesquisar(filterField, filterValue, order)).build();    }    @POST    @Produces(MediaType.APPLICATION_JSON)    @Consumes(MediaType.APPLICATION_JSON)    public Response criar(Usuario usuario) {        business.criar(usuario);        return Response.status(Response.Status.CREATED).entity(usuario).build();    }    @PUT    @Path("{id}")    @Produces(MediaType.APPLICATION_JSON)    @Consumes(MediaType.APPLICATION_JSON)    public Response atualizar(Usuario usuario, @PathParam("id") Long id) {        if (!id.equals(usuario.getId())) {            return Response.status(Response.Status.BAD_REQUEST).entity("ID do objeto difere do ID da URL").build();        }        business.atualizar(usuario);        return Response.status(Response.Status.OK).entity(usuario).build();    }    @DELETE    @Path("{id}")    public Response excluir(@PathParam("id") Long id) {        business.excluir(id);        return Response.status(Response.Status.NO_CONTENT).build();    }}