package io.github.canabarromatheus.coworkingsystem.rest.resource;

import io.github.canabarromatheus.coworkingsystem.rest.dto.request.PackRequest;
import io.github.canabarromatheus.coworkingsystem.rest.service.PackService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/v1/packs")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PackResource {
    PackService service;

    @Inject
    public PackResource(PackService service) {
        this.service = service;
    }

    @POST
    public Response createPack(PackRequest request) {
        service.createPack(request);
        return Response.status(201).build();
    }

    @GET
    public Response listPacks() {
        return Response.ok(service.findAll()).build();
    }
}
