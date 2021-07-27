package com.dpf.springcloud.bean;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public abstract class BaseEntity implements Serializable {

    public abstract Object getIdVal();

    public String getIdName() {
        return "id";
    }
    public Integer page;
    public Integer limit;
    public String order;
}
