package by.itsm.patients.console.menu.reports;

import by.itsm.patients.console.menu.IMenuItem;
import by.itsm.patients.elasticmq.ReportTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
@ReportMenuItem
public class ReportCreateMenuItem implements IMenuItem {

    @Autowired
    private ReportConsoleFactory factory;

    @Value("${queue.reports}")
    private String queueReports;

    @Autowired
    private QueueMessagingTemplate messagingTemplate;


    @Override
    public String getTitle() {
        return "Add Report";
    }

    @Override
    public int doAction() {
        ReportTask reportTask = factory.create();

        try {
            messagingTemplate.convertAndSend(queueReports, reportTask);
        } catch (RuntimeException ex) {
            System.err.println(ex);
        }

        return 0;
    }
}
