package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.Gallery;

@Repository
public interface GalleryRepository extends JpaRepository<Gallery, Integer>{

}
