package smart.application.appoint.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import smart.application.appoint.filter.MyFilter;

@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(myFilter());
        filterRegistrationBean.addUrlPatterns("/*");
        //过滤器名称
        filterRegistrationBean.setName("crossFilter");
        //过滤器顺序
        filterRegistrationBean.setOrder(1);
        return filterRegistrationBean;
    }

    @Bean
    public MyFilter myFilter() {
        return new MyFilter();
    }
}
