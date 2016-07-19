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

    public Catalog getCatalogElement(String name) {
        Catalog catalog = new Catalog(name);
        List<Catalog> singleElementCatalog = catalogDao.read(catalog);
        if (singleElementCatalog!=null && singleElementCatalog.size()>0) {
            assert singleElementCatalog.size() <= 1;
            return singleElementCatalog.get(0);
        }
        else return null;
    }

    public List<Catalog> getCatalogByParent(String strParent){
        Catalog parent = new Catalog();
        parent.setText(strParent);
        List<Catalog> parentList = catalogDao.read(parent);
        if (parentList.size()==0) return parentList; //parentlist is empty... no need doing anything else
        if (parentList.size()>1) {
            System.out.println ("ERROR getCatalog: parentList is bigger than 1.");
        }
        Catalog child = new Catalog();
        child.setParentId(parentList.get(0).getId());
        return catalogDao.read(child);
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
