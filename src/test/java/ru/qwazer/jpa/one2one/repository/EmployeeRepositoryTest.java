package ru.qwazer.jpa.one2one.repository;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import ru.qwazer.jpa.one2one.config.PersistenceContext;
import ru.qwazer.jpa.one2one.domain.simple.Address;
import ru.qwazer.jpa.one2one.domain.simple.Employee;

import static org.junit.Assert.assertEquals;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {PersistenceContext.class})
//@ContextConfiguration(locations = {"classpath:exampleApplicationContext-persistence.xml"})
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class,
        DbUnitTestExecutionListener.class })
//@DatabaseSetup("todoData.xml")
public class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository repository;

    @Autowired AddressRepository addressRepository;


    @Test
    public void testSave() {
        Employee employee = new  Employee();

        employee.setDescription("dest");

        Address address = new  Address();

        address.setDescription("address");
        addressRepository.save(address);
        employee.setAddress(address);



        repository.save(employee);
        Employee saved = repository.findOne(employee.getId());

        assertEquals(employee.getDescription(), saved.getDescription());


    }
}