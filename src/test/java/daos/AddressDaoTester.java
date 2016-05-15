package daos;

import com.skillmatch.daos.AddressDao;
import com.skillmatch.pojos.Address;
import com.skillmatch.util.AbstractTest;

import java.util.List;

/**
 * Created by agermenos on 5/15/16.
 */
public class AddressDaoTester extends AbstractTest {
    AddressDao addressDao;

    public AddressDaoTester(){
        super("/spring/config/beanlocations.xml");
    }

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
        assert(address != null);

        address.setStreet("Fonnian Way");
        addressDao.update(address);

        addressDao.delete(address);

        address = new Address();
        address.setId(returnId);
        List<Address> emptyList= (List<Address>) addressDao.read(address);

        assert (emptyList==null);

    }

    public static void main(String args[]){
        AddressDaoTester addressDaoTester = new AddressDaoTester();
        addressDaoTester.addressDao = (AddressDao) addressDaoTester.getContext().getBean("addressDao");
        addressDaoTester.testCRUD();
    }
}
