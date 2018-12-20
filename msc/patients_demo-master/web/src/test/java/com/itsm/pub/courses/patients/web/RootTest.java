package com.itsm.pub.courses.patients.web;

import com.itsm.pub.courses.patients.common.entities.State;
import com.itsm.pub.courses.patients.web.repository.StateRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
@DataJpaTest
public class RootTest {

    @Autowired
    private StateRepository stateRepository;

    @Test(expected = Exception.class)
    public void testUniqueCodeConstraint() {
        stateRepository.save(new State(null, "AL", "Alabama"));
    }

    @Test
    public void testSave() {
       stateRepository.save(new State(null, "AR", "Arkansas"));
    }

    @Test
    public void testFind() {
        State state = stateRepository.findByCode("AL");
        assertNotNull(state);
    }


}
