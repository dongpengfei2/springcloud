package com.dpf.springcloud.bean;

import java.io.Serializable;

public abstract class BaseTreeNode implements Serializable{
	private static final long serialVersionUID = 1L;

	private Integer id;
	
	private String name;
	
	private Integer parentId;

	private Integer pId;

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public abstract void addNode(BaseTreeNode node);
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }
}
