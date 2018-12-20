package by.itsm.patients.elasticmq;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ElasticApp {

    public static void main(String[] args) {

        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ElasticConfig.class)) {

            try {
                QueueMessagingTemplate queue1 = context.getBean(QueueMessagingTemplate.class);

                String msg = "test1";

//                queue1.convertAndSend(msg);

                queue1.convertAndSend("queue1", msg);
                Thread.sleep(5001);

//                msg = queue1.receiveAndConvert(String.class);
                msg = queue1.receiveAndConvert("queue1", String.class);

                System.out.println(msg);

            } catch (final AmazonServiceException ase) {
                System.out.println("Caught an AmazonServiceException, which means " +
                        "your request made it to Amazon SQS, but was " +
                        "rejected with an error response for some reason.");
                System.out.println("Error Message:    " + ase.getMessage());
                System.out.println("HTTP Status Code: " + ase.getStatusCode());
                System.out.println("AWS Error Code:   " + ase.getErrorCode());
                System.out.println("Error Type:       " + ase.getErrorType());
                System.out.println("Request ID:       " + ase.getRequestId());
            } catch (final AmazonClientException ace) {
                System.out.println("Caught an AmazonClientException, which means " +
                        "the client encountered a serious internal problem while " +
                        "trying to communicate with Amazon SQS, such as not " +
                        "being able to access the network.");
                System.out.println("Error Message: " + ace.getMessage());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
