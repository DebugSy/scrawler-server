package com.shiy.practice.scrawler.rest;


import com.shiy.practice.scrawler.entity.response.HousePriceAvg;
import com.shiy.practice.scrawler.repositories.HouseInfoRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Component
@Path("/houses")
@Api(value = "[House] 执行相关接口")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class HouseInfoResource {

    @Autowired
    private HouseInfoRepository repository;

    @GET
    @Path("{id}")
    @ApiOperation(value = "查询Execution", response = String.class)
    public Response findOne(@ApiParam("Execution ID") @PathParam("id") String id) {
        return Response.status(200).entity(id).build();
    }

    @GET
    @Path("/avg/name")
    public Response findByName(@QueryParam("community") String community) {
        List<HousePriceAvg> housePriceAvgs = repository.findByCommunity(community);
        return Response.status(200).entity(housePriceAvgs).build();
    }

    @GET
    @Path("/avg")
    public Response getAvg() {
        List<HousePriceAvg> avgPrice = repository.findAvgPrice();
        return Response.status(200).entity(avgPrice).build();
    }

    @POST
    @Path("/avg/compare")
    public Response getAvgCompare(List<String> communities) {
        List<HousePriceAvg> avgPrice = repository.findByCommunityIn(communities);
        return Response.status(200).entity(avgPrice).build();
    }


}
