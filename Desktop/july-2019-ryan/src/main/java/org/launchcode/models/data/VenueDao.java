package org.launchcode.models.data;


import org.launchcode.models.forms.Venue;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface VenueDao extends CrudRepository<Venue, Integer> {
}
