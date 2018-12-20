package by.itsm.patients.worker;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


class WorkerRun {

    public static void main(String[] args) {


        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(WorkerConfig.class)) {

            context.getBean(Worker.class).run();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
