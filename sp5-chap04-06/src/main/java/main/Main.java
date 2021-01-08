package main;

import config.AppCtx;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import spring.Client;

public class Main { //chap 6 example for test : check Initial,send, and destroy method
    public static void main(String[] args) throws Exception{
        AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);

        Client client = ctx.getBean(Client.class);

        client.send();

        ctx.close();
    }
}
