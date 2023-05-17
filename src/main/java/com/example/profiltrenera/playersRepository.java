package com.example.profiltrenera;


import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;


@Repository
public interface playersRepository extends CrudRepository<Players, Long> {

}
