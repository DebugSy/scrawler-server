package com.shiy.practice.scrawler.repositories;

import com.shiy.practice.scrawler.AbstractServiceTest;
import com.shiy.practice.scrawler.entity.Houseinfo;
import com.shiy.practice.scrawler.entity.response.HousePriceAvg;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

public class HouseInfoRepositoryTest extends AbstractServiceTest {

    @Autowired
    private HouseInfoRepository houseInfoRepository;

    @Test
    public void findOne(){
        Optional<Houseinfo> optional = houseInfoRepository.findById("106092599941");
        assertTrue(optional.isPresent());
        Houseinfo houseinfo = optional.get();
        assertEquals("house community should be equal", "融创长滩壹号",
                houseinfo.getCommunity());
    }

    @Test
    public void avg() {
        List<HousePriceAvg> avgPrice = houseInfoRepository.findAvgPrice();
        for (HousePriceAvg housePriceAvg : avgPrice) {
            System.out.println(housePriceAvg);
        }
    }

    @Test
    public void avg1() {
        List<HousePriceAvg> avgPrice = houseInfoRepository.findByCommunity("南湖逸家二期");
        for (HousePriceAvg housePriceAvg : avgPrice) {
            System.out.println(housePriceAvg);
        }
    }

}
