package smart.application.appoint.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import smart.application.appoint.filter.CorsFilter;

@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean corsFilterRegistrationBean() {
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
    public CorsFilter myFilter() {
        return new CorsFilter();
    }
}
