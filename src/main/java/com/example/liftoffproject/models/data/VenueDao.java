package com.example.liftoffproject.models.data;

import com.example.liftoffproject.models.forms.Venue;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface VenueDao extends CrudRepository<Venue, Integer> {
}
