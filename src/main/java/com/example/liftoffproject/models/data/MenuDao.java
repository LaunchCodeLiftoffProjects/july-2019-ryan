package com.example.liftoffproject.models.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.awt.*;

@Repository
@Transactional
public interface MenuDao extends CrudRepository <Menu, Integer>{
}
