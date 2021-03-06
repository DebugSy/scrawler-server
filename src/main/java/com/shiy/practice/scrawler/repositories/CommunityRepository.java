package com.shiy.practice.scrawler.repositories;

import com.shiy.practice.scrawler.entity.Community;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommunityRepository extends JpaRepository<Community, Long> {

    List<Community> findByTitleLike(String title);

    List<Community> findByTitleIn(List<String> communities);

    List<Community> findByTitleIsIn(List<String> communities);

}
