package com.shiy.practice.scrawler.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shiy.practice.scrawler.rest.CommunityResource;
import com.shiy.practice.scrawler.rest.HouseInfoResource;
import io.swagger.jaxrs.listing.ApiListingResource;
import org.glassfish.jersey.server.ResourceConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

/**
 * Created by DebugSy on 2019/8/12.
 */
@Configuration
@ApplicationPath("/api/scrawler")
public class JerseyResourceConfig extends ResourceConfig {

    @PostConstruct
    public void initialize() {
        super
                .register(HouseInfoResource.class)
                .register(CommunityResource.class)
                .register(ObjectMapperContextResolver.class);

        //add swagger ui resource
        packages(ApiListingResource.class.getPackage().getName());
    }

}

@Provider
class ObjectMapperContextResolver implements ContextResolver<ObjectMapper> {

    public static boolean prettyJson = false;
    public static ObjectMapper mapper = JacksonConfig.buildObjectMapper(prettyJson);
    protected Logger logger = LoggerFactory.getLogger(ObjectMapperContextResolver.class);

    public ObjectMapper getContext(Class<?> arg0) {
        return mapper;
    }

}
