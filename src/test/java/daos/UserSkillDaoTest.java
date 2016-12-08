package daos;

import com.skillmatch.daos.*;
import com.skillmatch.pojos.*;
import com.skillmatch.services.CatalogService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.Date;

/**
 * Created by agermenos on 7/9/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring/config/beanlocations.xml")
public class UserSkillDaoTest {
    @Autowired
    CatalogService catalogService;
    @Autowired
    CatalogDao catalogDao;
    @Autowired
    UserDao userDao;
    @Autowired
    SkillDao skillDao;
    @Autowired
    UserSkillDao userSkillDao;
    @Autowired
    AddressDao addressDao;
    @Autowired
    SkillLevelDao skillLevelDao;

    @Test
    public void createUserSkill(){
        Address address = createAddress("3420 Finnian Way", "Apartment 408", "94568");
        User user = createUser("Alejandro", "Geremnos", address);
        SkillLevel skillLevel = createSkillLevel("programming", "java", "advanced");
        Catalog status = catalogService.getCatalogElement("live");
        UserSkill userSkill = new UserSkill();
        userSkill.setStatus(status);
        userSkill.setDateAdded(new Date());
        userSkill.setSkillLevel(skillLevel);
        userSkill.setUserId(user.getId());
        userSkillDao.create(userSkill);
        assert userSkill.getId()!=null;
    }

    private SkillLevel createSkillLevel(String type, String description, String level) {
        Skill skill = createSkll (description, type);
        catalogService.createCatalog("level", Arrays.asList(new String[] {"beginner", "intermediate", "advanced", "master"}));
        Catalog catalogLevel = catalogService.getCatalogElement(level);
        SkillLevel skillLevel = new SkillLevel();
        skillLevel.setLevel(catalogLevel);
        skillLevel.setSkill(skill);
        skillLevelDao.create(skillLevel);
        return skillLevel;
    }

    private Skill createSkll(String description, String type) {
        Skill skill = new Skill();
        catalogService.createCatalog("status", Arrays.asList(new String[]{"live", "created", "deleted"}));
        catalogService.createCatalog("skills", Arrays.asList(new String[]{description}));
        catalogService.createCatalog("skillType", Arrays.asList(new String[] {type}));
        Catalog skillCatalog = catalogService.getCatalogElement(description);
        Catalog skillTypeCatlog = catalogService.getCatalogElement(type);
        Catalog status = catalogService.getCatalogElement("live");
        skillTypeCatlog.setParentId(skillCatalog.getId());
        catalogDao.update(skillTypeCatlog);
        skill.setDescription(skillCatalog);
        skill.setType(skillTypeCatlog);
        skill.setDateAdded(new Date());
        skill.setStatus(status);
        skillDao.create(skill);
        return skill;
    }

    private User createUser(String name, String lastName, Address address) {
        User user = new User();
        user.setAddressId(address.getId());
        user.setName(name);
        user.setLastName(lastName);
        userDao.create(user);
        return user;
    }

    private Address createAddress(String street, String lineExtra, String poBox) {
        Address address = new Address();
        address.setStreet(street);
        address.setLineExtra(lineExtra);
        address.setPoBox(poBox);
        addressDao.create(address);
        return address;
    }
}
