package io.github.canabarromatheus.coworkingsystem.rest.resource;

import io.github.canabarromatheus.coworkingsystem.rest.dto.request.RoomRequest;
import io.github.canabarromatheus.coworkingsystem.rest.service.RoomService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/v1/rooms")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class RoomResource {
    RoomService service;

    @Inject
    public RoomResource(RoomService service) {
        this.service = service;
    }

    @POST
    public Response addRoom(RoomRequest request) {
        service.saveRoom(request);
        return Response.status(201).build();
    }

    @GET
    public Response listRooms() {
        return Response.ok(service.findAll()).build();
    }
}
