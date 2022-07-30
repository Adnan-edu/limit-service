package com.example.microservices.limitsservice.bean;

import lombok.Data;

@Data
public class Limits {
    private int minimum;
    private int maximum;

    public Limits() {
        super();
    }
    public Limits(int minimum, int maximum) {
        super();
        this.minimum = minimum;
        this.maximum = maximum;
    }
}
