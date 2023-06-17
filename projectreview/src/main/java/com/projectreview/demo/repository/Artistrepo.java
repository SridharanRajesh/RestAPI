package com.projectreview.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projectreview.demo.model.Artist;


@Repository
public interface Artistrepo extends JpaRepository<Artist, Integer> {

}
