package io.github.canabarromatheus.coworkingsystem.rest.resource;

import io.github.canabarromatheus.coworkingsystem.exception.InvalidCPFException;
import io.github.canabarromatheus.coworkingsystem.rest.dto.request.ClientRequest;
import io.github.canabarromatheus.coworkingsystem.rest.dto.response.ClientResponse;
import io.github.canabarromatheus.coworkingsystem.rest.service.ClientService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/v1/clients")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ClientResource {
    ClientService service;

    @Inject
    public ClientResource(ClientService service) {
        this.service = service;
    }

    @POST
    public Response addClient(ClientRequest request) throws InvalidCPFException {
        service.save(request);
        return Response.status(201).build();
    }

    @GET
    public Response listClients() {
        List<ClientResponse> responses = service.findAll();
        return Response.ok(responses).build();
    }
}
