package cn.itcast.order;

import cn.itcast.feign.clients.UserClient;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@MapperScan("cn.itcast.order.mapper")
@SpringBootApplication
//@EnableFeignClients(basePackages = "cn.itcast.feign.clients")
@EnableFeignClients(clients = {UserClient.class})
public class OrderApplication {


    public static void main(String[] args) {SpringApplication.run(OrderApplication.class, args);}

    /**
     * 创建RestTemplate并注入容器
     * @return
     */
    @Bean
    @LoadBalanced//负载均衡注解
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

}