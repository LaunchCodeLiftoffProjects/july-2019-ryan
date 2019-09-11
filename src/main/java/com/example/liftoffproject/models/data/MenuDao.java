package com.example.liftoffproject.models.data;

import com.example.liftoffproject.models.forms.Menu;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public interface MenuDao extends CrudRepository <Menu, Integer>{
}
