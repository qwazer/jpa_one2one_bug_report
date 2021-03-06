package ru.qwazer.jpa.one2one.repository;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import junit.framework.TestCase;
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

import static org.junit.Assert.assertEquals;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {PersistenceContext.class})
//@ContextConfiguration(locations = {"classpath:exampleApplicationContext-persistence.xml"})
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class,
        DbUnitTestExecutionListener.class })
public class AddressRepositoryTest  {

    @Autowired
    private AddressRepository repository;


    @Test
    public void testSave() {
        Address todo = new  Address();

        todo.setDescription("dest");
        repository.save(todo);
        Address saved = repository.findOne(todo.getId());

        assertEquals(todo.getDescription(), saved.getDescription());


    }

}