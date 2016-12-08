package daos;

import com.skillmatch.daos.AddressDao;
import com.skillmatch.pojos.Address;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Created by agermenos on 5/15/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring/config/beanlocations.xml")
public class AddressDaoTest {
    @Autowired
    AddressDao addressDao;

    @Test
    public void testCRUD(){
        Address address = new Address();
        address.setStreet("Finnian Way");
        address.setNumber("3420");
        address.setLineExtra("Apt. 408");
        address.setPoBox("94568");

        addressDao.create(address);
        int returnId = address.getId();
        address = new Address();
        address.setId(returnId);
        address = addressDao.read(address).get(0);
        assertTrue(address != null);

        address.setStreet("Fonnian Way");
        addressDao.update(address);

        addressDao.delete(address);

        address = new Address();
        address.setId(returnId);
        List<Address> emptyList= addressDao.read(address);

        assertTrue (emptyList.size()==0);
    }

}
