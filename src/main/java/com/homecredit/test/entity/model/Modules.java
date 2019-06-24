package com.homecredit.test.entity.model;

import com.homecredit.test.entity.Module;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Modules {
    private List<Module> modules = new ArrayList<>();

    public Modules() {
    }

    public Modules(List<Module> modules) {
        this.modules = modules;
    }
}
