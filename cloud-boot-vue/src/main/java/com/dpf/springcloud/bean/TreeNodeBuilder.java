package com.dpf.springcloud.bean;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class TreeNodeBuilder {

    public static <O,T extends BaseTreeNode> List<T> buildTree(List<O> objectList,TreeNodeObjectBuilder<T,O> builder){
        List<T> treeNodeList = new ArrayList<T>();
        Map<Integer,T> nodeMap = new LinkedHashMap<Integer, T>();
        for(O obj : objectList){
            T buildNode = builder.buildNode(obj);
            nodeMap.put(buildNode.getId(), buildNode);
        }
        for(T node : nodeMap.values()){
            T parentNode = nodeMap.get(node.getParentId());
            if(parentNode != null){
                parentNode.addNode(node);
            }else{
                treeNodeList.add(node);
            }
        }
        return treeNodeList;
    }

    public interface TreeNodeObjectBuilder<T extends BaseTreeNode,O>{

        public T buildNode(O obj);

    }
}