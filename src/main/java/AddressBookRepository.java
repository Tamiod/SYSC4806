import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface AddressBookRepository extends CrudRepository<AddressBook, Long> {

    List<AddressBook> findByLastName(String lastName);

    AddressBook findById(long id);
}
