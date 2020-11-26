package com.will.asgard.loki.model.concurrency.chapter2;

import java.io.IOException;
import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicLong;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2020-11-26 上午1:43
 * @Version 1.0
 */
public class CountingFactorizer implements Servlet {

    private final AtomicLong count = new AtomicLong(0);

    @Override
    public void init(ServletConfig config) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        BigInteger i = extractFromRequest(req);
        BigInteger[] factors = factor(i);
        count.incrementAndGet();
        encodeIntoResponse(res, factors);
    }

    private BigInteger extractFromRequest(ServletRequest req) {
        return new BigInteger("0");
    }

    private BigInteger[] factor(BigInteger factor) {
        return new BigInteger[]{factor};
    }

    private void encodeIntoResponse(ServletResponse res, BigInteger[] factors) {
        // do some thing here
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
