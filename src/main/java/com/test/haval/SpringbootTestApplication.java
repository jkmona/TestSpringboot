package com.test.haval;

import com.test.haval.Config.TestConfig;
import com.test.haval.Config.TestConfig1;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringbootTestApplication {
    @Bean
    public Runnable createRunnable(){
        return () -> System.out.println("create a runnable");
    }

    public static void main(String[] args){
        ConfigurableApplicationContext ctx = SpringApplication.run(SpringbootTestApplication.class, args);
        /*测试properties加载*/
        ctx.getBean(Runnable.class).run();
        TestConfig tc = ctx.getBean(TestConfig.class);
        tc.display();
        TestConfig1 tc1 = ctx.getBean(TestConfig1.class);
        tc1.display();

        //Runna
       /* String base64encodedString = null;
        try {
            //base64encodedString = Base64.getEncoder().encodeToString("runoob?java8".getBytes("utf-8"));
            base64encodedString = Base64.getUrlEncoder().encodeToString("TutorialsPoint?java8".getBytes("utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println("Base64 编码字符串 (基本) :" + base64encodedString);
        */
    }

}
