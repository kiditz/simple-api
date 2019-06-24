package com.homecredit.test.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
public class Module {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private int id;
    @NotNull
    @Column(name = "module_name", nullable = false)
    private String moduleName;

    @Column(name = "moduler_order")
    private int moduleOrder;

    public Module() {
    }

    public Module(@NotNull String moduleName, int moduleOrder) {
        this.moduleName = moduleName;
        this.moduleOrder = moduleOrder;
    }
}
