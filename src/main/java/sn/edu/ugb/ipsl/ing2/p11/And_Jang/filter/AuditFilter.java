package sn.edu.ugb.ipsl.ing2.p11.And_Jang.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;

@Component
public class AuditFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//        logger.info("Interception de requete");
//        String requestURI = request.getRequestURI();
//        String queryString = request.getQueryString();
//        String ipAddress = request.getRemoteAddr();
//        String userAgent = request.getHeader("User-Agent");
//        Integer statutCode = response.getStatus();
//        logger.info("requestURI: " + requestURI);
//        logger.info("queryString: " + queryString);
//        logger.info("ipAddress: " + ipAddress);
//        logger.info("userAgent: " + userAgent);
//        logger.info("statutCode 1: " + statutCode);
//        filterChain.doFilter(request, response);
//        statutCode = response.getStatus();
//        logger.info("statutCode 2: " + statutCode);
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            String headerValue = request.getHeader(headerName);
            logger.error(headerName + ": " + headerValue);
        }
        filterChain.doFilter(request, response);

    }
}
