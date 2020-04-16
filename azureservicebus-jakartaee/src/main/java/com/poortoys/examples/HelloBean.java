package com.poortoys.examples;

import javax.ejb.Stateless;

@Stateless
public class HelloBean {
    
    public String getMessage() {
        return "Hello, world";
    }
    
}