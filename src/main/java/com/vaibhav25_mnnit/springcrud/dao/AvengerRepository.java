package com.vaibhav25_mnnit.springcrud.dao;

import com.vaibhav25_mnnit.springcrud.entity.Avenger;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AvengerRepository extends JpaRepository<Avenger,Integer> {
}
