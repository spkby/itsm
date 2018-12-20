package by.itsm.patients.elasticmq;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.sqs.AmazonSQSAsync;
import com.amazonaws.services.sqs.AmazonSQSAsyncClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("by.itsm.patients.elasticmq")
@PropertySource("classpath:elastic.properties")
public class ElasticConfig {

    @Value("${elastic.endpoint}")
    private String endpoint;

    @Value("${elastic.region}")
    private String region;

    @Value("${elastic.accessKey}")
    private String accessKey;

    @Value("${elastic.secretKey}")
    private String secretKey;

    @Value("${elastic.queueUrl}")
    private String queueUrl;

    @Value("${queue.reports}")
    private String queueReports;

    @Bean
    public AmazonSQSAsync client() {
        return AmazonSQSAsyncClientBuilder.standard()
                .withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials(accessKey, secretKey)))
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(endpoint, region))
                .build();
    }

    @Bean
    public String getQueueUrl() {
        return queueUrl;
    }

    @Bean
    public QueueMessagingTemplate template(AmazonSQSAsync client) {
        QueueMessagingTemplate queueMessagingTemplate = new QueueMessagingTemplate(client);
        return queueMessagingTemplate;
    }

    @Bean
    public String getQueueReports(){
        return queueReports;
    }

}
