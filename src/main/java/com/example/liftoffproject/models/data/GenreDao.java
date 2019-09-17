package com.example.liftoffproject.models.data;

import com.example.liftoffproject.models.forms.Genre;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;

@Repository
@Transactional
public interface GenreDao extends CrudRepository<Genre, Integer> {
}