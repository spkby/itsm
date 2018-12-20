package by.itsm.msg.core.sleepers;

import by.itsm.msg.core.BeanSleeper;
import org.springframework.stereotype.Component;

@Component
public class BeanSleeperImpl implements BeanSleeper {

    @Override
    public void sleep(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
