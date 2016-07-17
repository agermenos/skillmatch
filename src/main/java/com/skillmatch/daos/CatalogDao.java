package com.skillmatch.daos;

import com.skillmatch.pojos.Catalog;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by agermenos on 5/16/16.
 */
@Repository("catalogDao")
public class CatalogDao extends GeneralDao<Catalog>{

}
