package br.vandersoncamp.resources;import br.vandersoncamp.eplants.data.PlantaFamiliaBusiness;import br.vandersoncamp.eplants.model.PlantaFamilia;import br.vandersoncamp.eplants.model.Usuario;import javax.enterprise.context.RequestScoped;import javax.inject.Inject;import javax.ws.rs.*;import javax.ws.rs.core.*;@Path("/plantasfamilia")@RequestScopedpublic class PlantaFamiliaResource {    @Inject    private PlantaFamiliaBusiness business;    @GET    @Path("{id:[0-9][0-9]*}")    @Produces(MediaType.APPLICATION_JSON)    public Response buscar(@PathParam("id") Long id) {        PlantaFamilia familia = business.buscar(id);        if (familia == null) {            return Response.status(Response.Status.NOT_FOUND).build();        }        return Response.ok(familia).build();    }    @GET    @Produces(MediaType.APPLICATION_JSON)    public Response pesquisar(@DefaultValue("0") @QueryParam("offset") Integer offset,                              @DefaultValue("50") @QueryParam("limit") int limit,                              @QueryParam("sort") String sort) {        return Response.ok(business.pesquisar()).build();    }    @POST    @Produces(MediaType.APPLICATION_JSON)    @Consumes(MediaType.APPLICATION_JSON)    public Response criar(PlantaFamilia familia) {        business.criar(familia);        return Response.status(Response.Status.CREATED).entity(familia).build();    }    @PUT    @Path("{id:[0-9][0-9]*}")    @Produces(MediaType.APPLICATION_JSON)    @Consumes(MediaType.APPLICATION_JSON)    public Response atualizar(PlantaFamilia familia, @PathParam("id") Long id) {        if (familia.getId().equals(id)) {            business.atualizar(familia);            return Response.status(Response.Status.CREATED).entity(familia).build();        } else {            return Response.status(Response.Status.BAD_REQUEST).entity("ID do objeto difere da URL").build();        }    }    @DELETE    @Path("{id:[0-9][0-9]*}")    public Response excluir(@PathParam("id") Long id) {        business.excluir(id);        return Response.ok().build();    }}