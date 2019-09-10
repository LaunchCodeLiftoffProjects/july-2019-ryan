package org.launchcode.july2019ryan.models;


import org.launchcode.july2019ryan.forms.Venue;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface VenueDao extends CrudRepository<Venue, Integer> {
}

