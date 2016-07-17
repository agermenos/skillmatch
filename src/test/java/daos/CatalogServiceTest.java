package daos;

import com.skillmatch.pojos.Catalog;
import com.skillmatch.services.CatalogService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Created by agermenos on 5/21/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring/config/beanlocations.xml")
public class CatalogServiceTest {
    @Autowired
    CatalogService catalogService;

    @Test
    public void test(){
        String[] countries = {"US", "UK", "Mexico", "Brazil", "India"};
        catalogService.createCatalog("Countries", Arrays.asList(countries));
        List<Catalog> countryCatalog = catalogService.getCatalog("Countries");
        assertTrue(countryCatalog.size()>0);
        catalogService.killCatalog("Countries");
        countryCatalog = catalogService.getCatalog("Countries");
        assertTrue(countryCatalog.size()==0);
    }
}
