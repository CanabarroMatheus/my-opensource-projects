package io.github.canabarromatheus.coworkingsystem.rest.resource;

import io.github.canabarromatheus.coworkingsystem.exception.InvalidCPFException;
import io.github.canabarromatheus.coworkingsystem.rest.dto.request.ClientRequest;
import io.github.canabarromatheus.coworkingsystem.rest.service.ClientService;
import io.github.canabarromatheus.coworkingsystem.rest.service.ContactTypeService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/v1/clients")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ClientResource {
    ClientService clientService;
    ContactTypeService contactTypeService;

    @Inject
    public ClientResource(ClientService clientService, ContactTypeService contactTypeService) {
        this.clientService = clientService;
        this.contactTypeService = contactTypeService;
    }

    @POST
    public Response addClient(ClientRequest request) throws InvalidCPFException {
        clientService.save(request);
        return Response.status(201).build();
    }

    @GET
    public Response listClients() {
        return Response.ok(clientService.findAll()).build();
    }

    @GET
    @Path("/contact-types")
    public Response listContactTypes() {
        return Response.ok(contactTypeService.findAll()).build();
    }
}
