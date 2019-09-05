package org.launchcode.models.data;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.awt.*;

@Repository
@Transactional
public interface MenuDao extends CrudRepository<Menu, Integer> {
}
