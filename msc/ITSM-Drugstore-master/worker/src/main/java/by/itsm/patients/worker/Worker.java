package by.itsm.patients.worker;

import by.itsm.patients.common.entity.Sale;
import by.itsm.patients.elasticmq.ReportTask;
import by.itsm.patients.worker.service.Collector;
import by.itsm.patients.worker.service.Export;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope("prototype")
public class Worker implements Runnable {

    @Value("${waiting.time}")
    private int waitingTime;

    @Value("${queue.worker}")
    private String queueReports;

    @Autowired
    private Collector collector;

    @Autowired
    private Export export;

    @Autowired
    private QueueMessagingTemplate messagingTemplate;

    @Override
    public void run() {
        try {

            ReportTask task = null;

            do {
                task = messagingTemplate.receiveAndConvert(queueReports, ReportTask.class);

                if (task == null) {
                    Thread.sleep(waitingTime);
                    continue;
                }

                List<Sale> sales = collector.getSales(task.getDateFrom(), task.getDateTo());
                if (sales.size() > 0) {
                    export.export(task.getFileName(), sales);
                }

            }
            while (true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
