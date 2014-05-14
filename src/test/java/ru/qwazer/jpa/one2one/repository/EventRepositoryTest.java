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
import ru.qwazer.jpa.one2one.domain.inheritance.Event;

/**
 * @author Petri Kainulainen
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {PersistenceContext.class})
//@ContextConfiguration(locations = {"classpath:exampleApplicationContext-persistence.xml"})
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class,
        DbUnitTestExecutionListener.class})
//@DatabaseSetup("todoData.xml")
public class EventRepositoryTest {

    @Autowired
    private EventRepository repository;


    @Test
    public void testSave() {
        Event childEvent = new Event();
        childEvent.setDescription("childEvent");
        repository.save(childEvent);

        Event parentEvent = new Event();
        childEvent.setDescription("parentEvent");
        repository.save(parentEvent);

        childEvent.setParentId(parentEvent);

        repository.save(childEvent);


        Event saved = repository.findOne(childEvent.getId());

        // assertEquals(todo.getDescription(), saved.getDescription());


    }

}
