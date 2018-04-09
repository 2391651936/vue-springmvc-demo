package smart.application.appoint.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

public class CorsFilter implements Filter {

    private String[] allowMethods = {"DELETE", "GET", "POST", "PUT"};

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    /*
    跨域 filter
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        response.setHeader("Access-Control-Request-Method", "GET, POST, DELETE, PUT");
        response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
        response.setHeader("Access-Control-Max-Age", "1728000");

        String method = request.getMethod();
        if (method.equals("OPTIONS")) {
            String requestMethod = request.getHeader("Access-Control-Request-Method");
            ServletOutputStream out = response.getOutputStream();
            if (Arrays.binarySearch(allowMethods, requestMethod) >= 0) {
                response.setHeader("Access-Control-Allow-Methods","GET, POST, PUT, DELETE");
                out.write(200);
            } else {
                out.write(("not allow" + requestMethod).getBytes());
                out.write(405);
            }
        } else {
            filterChain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {

    }
}
