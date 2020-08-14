package net.duxingzhe.luke.spring.readinglist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * @author yanlishuai
 * @SpringBootApplication 开启组件扫描和自动配置
 */
@SpringBootApplication
public class ReadingListApplication {

    public static void main(String[] args) {
        // 负责启动引导程序
        SpringApplication.run(ReadingListApplication.class, args);
    }

}
