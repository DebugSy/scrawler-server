package com.shiy.practice.scrawler.repositories;

import com.shiy.practice.scrawler.entity.Houseinfo;
import com.shiy.practice.scrawler.entity.response.HousePriceAvg;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HouseInfoRepository extends JpaRepository<Houseinfo, String> {

    @Query("select new com.shiy.practice.scrawler.entity.response.HousePriceAvg(" +
            "t.community,count(t.houseId),avg(t.unitPrice)) from Houseinfo t group by t.community")
    List<HousePriceAvg> findAvgPrice();

    @Query("select new com.shiy.practice.scrawler.entity.response.HousePriceAvg(" +
            "t.community,count(t.houseId),avg(t.unitPrice)) from Houseinfo t where t.community = ?1")
    List<HousePriceAvg> findByCommunity(String community);

    @Query("select new com.shiy.practice.scrawler.entity.response.HousePriceAvg(" +
            "t.community,count(t.houseId),avg(t.unitPrice)) from Houseinfo t GROUP BY t.community HAVING t.community in ?1")
    List<HousePriceAvg> findByCommunityIn(List<String> communities);
}
