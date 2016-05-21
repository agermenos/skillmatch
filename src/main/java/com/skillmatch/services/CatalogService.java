package com.skillmatch.services;

import com.skillmatch.daos.CatalogDao;
import com.skillmatch.pojos.Catalog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by agermenos on 5/20/16.
 */
@Service ("catalogService")
public class CatalogService {
    @Autowired
    CatalogDao catalogDao;

    private Catalog createOrGetCatalog (String catalogName) {
        Catalog catalog;
        catalog = getCatalogElement(catalogName);
        if (catalog==null) {
            catalog = new Catalog(catalogName);
            catalogDao.create(catalog);
        }
        return catalog;
    }

    private Catalog getCatalogElement(String name) {
        Catalog catalog = new Catalog(name);
        List<Catalog> singleElementCatalog = catalogDao.read(catalog);
        if (singleElementCatalog!=null && singleElementCatalog.size()>0) {
            assert singleElementCatalog.size() <= 1;
            return singleElementCatalog.get(0);
        }
        else return null;
    }

    public List<Catalog> getCatalog(String catalog){
        Catalog parent = new Catalog();
        parent.setText(catalog);
        List<Catalog> singleElementCatalog = catalogDao.read(parent);
        assert singleElementCatalog.size()<=1;
        Catalog children = new Catalog();
        children.setParentId(parent.getId());
        return catalogDao.read(children);
    }

    public void killCatalog (String catalogName) {
        Catalog catalog = createOrGetCatalog(catalogName);
        Catalog childDto = new Catalog();
        childDto.setParentId(catalog.getId());
        List<Catalog> catalogChildren = catalogDao.read(childDto);
        catalogChildren.stream().forEach(child -> catalogDao.delete(child));
        catalogDao.delete(catalog);
    }

    public void createCatalog(String catalogName, List<String>values) {
        Catalog catalog = createOrGetCatalog(catalogName);

        values.stream().forEach(value -> {
            Catalog child = new Catalog(value);
            child.setParentId(catalog.getId());
            child = createOrGetCatalog(value);
            child.setParentId(catalog.getId());
            catalogDao.update(child);
        });
    }

}
