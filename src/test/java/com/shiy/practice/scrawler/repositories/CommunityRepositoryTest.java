package com.shiy.practice.scrawler.repositories;

import com.shiy.practice.scrawler.AbstractServiceTest;
import com.shiy.practice.scrawler.entity.Community;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

public class CommunityRepositoryTest extends AbstractServiceTest {

    @Autowired
    private CommunityRepository repository;


    @Test
    public void testFindCommunityLike() {
        List<Community> communities = repository.findByTitleLike("%南湖%");
        assertTrue(communities.size() > 0);
    }

}
