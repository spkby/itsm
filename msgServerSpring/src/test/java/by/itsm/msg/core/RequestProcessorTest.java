package by.itsm.msg.core;

import by.itsm.msg.core.processors.BaseRequestProcessor;
import by.itsm.msg.dto.Request;
import by.itsm.msg.dto.Response;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class RequestProcessorTest {

    @Mock
    private BeanSleeper sleeper;

    @InjectMocks
    private BaseRequestProcessor testee;

    @Before
    public void init() {
        //when(sleeper.sleep(anyLong())).thenReturn("asd");
    }

    @Test
    public void process() {
        Response response =
                testee.process(new Request("someName", "message"));

        assertNotNull(response);
        assertEquals("Hello, someName", response.getMessage());

        verify(sleeper, times(2))
                .sleep(anyLong());
    }
}
