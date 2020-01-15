package com.shiy.practice.scrawler.rest;

import com.shiy.practice.scrawler.entity.Community;
import com.shiy.practice.scrawler.repositories.CommunityRepository;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Component
@Path("/communities")
@Api(value = "[Community] 执行相关接口")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CommunityResource {

    @Autowired
    private CommunityRepository repository;

    /**
     * 模糊查询小区名称
     * @param community
     * @return
     */
    @GET
    @Path("/like")
    public Response findByCommunityLike(@QueryParam("community") String community) {
        List<Community> communities = repository.findByTitleLike("%" + community + "%");
        return Response.status(200).entity(communities).build();
    }

    @POST
    @Path("/list")
    public Response listCommunity(List<String> names){
        List<Community> communities = repository.findByTitleIsIn(names);
        return Response.status(200).entity(communities).build();
    }

}
