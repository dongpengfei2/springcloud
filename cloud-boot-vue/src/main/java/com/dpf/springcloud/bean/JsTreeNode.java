package com.dpf.springcloud.bean;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class JsTreeNode extends BaseTreeNode {
	private static final long serialVersionUID = 1L;

	private Integer menuLevel;

	private String url;

    private Integer pageType;

	private String uuidName;

	private boolean checked;

    private List<JsTreeNode> nodes;

    public boolean isChecked() {
        return checked;
    }

    public JsTreeNode() {
        nodes = new ArrayList<JsTreeNode>();
    }

    @Override
    public void addNode(BaseTreeNode node) {
        nodes.add((JsTreeNode)node);
    }
}
