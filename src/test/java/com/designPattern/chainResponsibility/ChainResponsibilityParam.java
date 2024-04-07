package com.designPattern.chainResponsibility;

import com.sun.deploy.util.StringUtils;
import org.junit.jupiter.api.Test;

import java.util.Optional;


public class ChainResponsibilityParam {

    private String name;

    public String getName() {
        return Optional.ofNullable(name).orElse("");
    }

    public void log() {
        System.out.println("========\n" + this.name + "\n=========\n");
    }

    public ChainResponsibilityParam assertParam(String val) {
        assert this.name.equals(val);
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }
}
