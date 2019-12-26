package com.shiy.practice.scrawler.rest;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Component
@Path("/houses")
@Api(value = "[Execution] 执行相关接口")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class HouseInfoResource {

    @GET
    @Path("{id}")
    @ApiOperation(value = "查询Execution", response = String.class)
    public Response findOne(@ApiParam("Execution ID") @PathParam("id") String id) {
        return Response.status(200).entity(id).build();
    }


}
