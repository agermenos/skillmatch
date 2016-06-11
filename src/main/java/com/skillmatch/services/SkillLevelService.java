package com.skillmatch.services;

import com.skillmatch.daos.SkillLevelDao;
import com.skillmatch.pojos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by agermenos on 6/4/16.
 */
@Service("skillLevelService")
public class SkillLevelService {
    @Autowired
    SkillLevelDao skillLevelDao;
    @Autowired
    CatalogService catalogService;

    public void createSkillLevel(SkillLevel skillLevel){
        skillLevelDao.create(skillLevel);
    }

    public void createSkill(String strSkill, String[] levels){
        catalogService.createCatalog(Catalog.GENERAL_SKILL_LEVELS, Arrays.asList(new String[]{"basic","intermediate","advanced"}));
        List<Catalog> catalogList = catalogService.getCatalog(Catalog.SKILL_STATUS);
        Skill skill = new Skill();
        skill.setDateAdded(new Date());
        skill.setStatus(catalogList.get(0));
    }
}
