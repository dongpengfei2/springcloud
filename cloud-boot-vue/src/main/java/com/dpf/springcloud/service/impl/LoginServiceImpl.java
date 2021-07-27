package com.dpf.springcloud.service.impl;

import com.dpf.springcloud.bean.AuthMenu;
import com.dpf.springcloud.bean.JsTreeNode;
import com.dpf.springcloud.bean.TreeNodeBuilder;
import com.dpf.springcloud.mapper.AuthMenuMapper;
import com.dpf.springcloud.service.LoginService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

@Service
public class LoginServiceImpl implements LoginService {

    @Resource
    private AuthMenuMapper authMenuMapper;

    @Override
    public List<JsTreeNode> getMenus() {
        List<AuthMenu> menus = authMenuMapper.findModifyList();
        List<JsTreeNode> nodes = TreeNodeBuilder.buildTree(menus, new TreeNodeBuilder.TreeNodeObjectBuilder<JsTreeNode, AuthMenu>() {
            public JsTreeNode buildNode(AuthMenu authMenu) {
                //加载权限下菜单 admin加载所有
                JsTreeNode node = new JsTreeNode();
                node.setId(authMenu.getId());
                node.setMenuLevel(authMenu.getMenuLevel());
                node.setName(authMenu.getMenuName());
                node.setPageType(authMenu.getPageType());
                node.setParentId(authMenu.getParentId());
                node.setUuidName(authMenu.getInUniqueKey());
                node.setUrl(authMenu.getMenuUrl());
                return node;
            }
        });
        return nodes;
    }
}
