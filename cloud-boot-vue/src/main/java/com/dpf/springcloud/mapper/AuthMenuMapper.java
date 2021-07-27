package com.dpf.springcloud.mapper;

import cn.hutool.json.JSONObject;
import com.dpf.springcloud.bean.AuthMenu;
import com.dpf.springcloud.bean.JsTreeNode;
import com.dpf.springcloud.bean.PageParam;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Mapper
public interface AuthMenuMapper {

    List<AuthMenu> findList(@Param("pageParam") PageParam pageParam, @Param("authMenu") AuthMenu authMenu);

    void save(AuthMenu authMenu);

    void saveForUpdate(AuthMenu authMenu);

    void update(AuthMenu authMenu);

    AuthMenu selectById(Integer id);

    Integer checkName(String menuName);

    Integer checkUnKey(String inUniqueKey);

    List<Map<String,Object>> customSql(Map<String,String> map);

    List<Map<String,Object>> customSqlPage(@Param("parMap")Map<String,String> map, @Param("pageParam") PageParam pageParam);

    List<JsTreeNode> allMenus();

    List<JsTreeNode> allDataMenus(Integer roleId);

    List<Integer> menusByRoleId(Integer roleId);

    List<Map<String,Integer>> dataMenusByRoleId(Integer roleId);

    void saveRoleMenu(@Param("roleId")Integer roleId, @Param("menuId")Integer menuId);

    void saveRoleMenuData(@Param("roleId")Integer roleId, @Param("menuId")Integer menuId, @Param("dataId")Integer dataId);

    void deleteRoleMenuByRoleId(Integer roleId);

    void deleteRoleMenuDataByRoleId(Integer roleId);

    List<AuthMenu> findModifyList();

    List<AuthMenu> findFixedList();

    List<AuthMenu> findSystemList();

    List<Integer> getUserMenus(@Param("userId") Integer userId, @Param("productId") Integer productId);

    List<String> getUserUrlMenus(@Param("userId") Integer userId, @Param("productId") Integer productId);

    List<AuthMenu> findListByParId(@Param("parId") Integer parId, @Param("userId") Integer userId, @Param("productId") Integer productId);

    List<AuthMenu> findThirdListByParId(@Param("parId") Integer parId, @Param("userId") Integer userId, @Param("productId") Integer productId);

    String geySqlBymenuId(Integer id);

    void deleteThirdMeunByParId(Integer pId);

    void deletTablesByMenuId(Integer id);

    void deletMenuSqlByMenuId(Integer id);

    void deletViewMenuSqlByMenuId(Integer id);

    Integer getLastKey();

    String getViewMenuSqlByMenuId(Integer id);

    List<AuthMenu> getSearchFileds(Integer id);

    List<AuthMenu> getGroupByFeild(Integer id);

    List<AuthMenu> findGroupByParId(@Param("id") Integer id, @Param("sqlName")String sqlName);

    String[] countForData(@Param("id") Integer id, @Param("sqlName") String sqlName);

    String[] countForUserData(@Param("id") Integer id, @Param("sqlName") String sqlName, @Param("userId") Integer userId, @Param("productId") Integer productId);

    List<AuthMenu> findSecounPageList(Integer level);

    List<AuthMenu> findAllByParentId(Integer parentId);

    void saveChilds(@Param("authMenus") List<AuthMenu> authMenus, @Param("parentId") Integer parentId);

    List<Map<String,String>> groupbyCharts();

    Integer getGroupByIdByParId(Integer parentId);

    List<JSONObject> allMenusJSON();
    List<JSONObject> roleMenusChildsObjects(@Param("roleId") Integer roleId, @Param("pId")String pId);

    void deleteRoleMenu(@Param("roleId") Integer roleId, @Param("cleanMenuArr")List<String> cleanMenuArr);
    void deleteRoleMenuData(@Param("roleId") Integer roleId, @Param("id")String id, @Param("pId")String pId);
    void deleteRoleMenuDataByPids(@Param("roleId")Integer roleId, @Param("levelThreePidsDel")List<String> levelThreePidsDel);

    void saveMenuRoles(@Param("roleId")Integer roleId, @Param("addMenuArr")List<HashMap> addMenuArr);
    void saveMenuRolesData(@Param("roleId")Integer roleId, @Param("addDataArr")List<HashMap> addDataArr);
    void saveMenuRolesDataByPids(@Param("roleId")Integer roleId, @Param("levelThreePidsAdd")List<String> levelThreePidsAdd);

    void batchDeleteByModelIds(@Param("modelIds")List<Integer> modelIds);

    List<AuthMenu> findMultiGroupByParId(@Param("id") Integer id, @Param("sqlName")String sqlName);

    void deleteMenuRolesDataByPids(@Param("roleId") Integer roleId, @Param("levelThreePids") Integer levelThreePids);

    //获取当前用户所能看到的菜单数据
    List<JSONObject> allDataReportMenus(@Param("userId") Integer userId, @Param("productId") Integer productId);

    //修改当前菜单下所有子菜单的状态进行逻辑删除
    void updateChildMenuStatus(@Param("menuId") Integer menuId, @Param("menuStatus") int menuStatus);

    List<AuthMenu> findFormIFrameMenuListByParId(@Param("parentId") Integer parentId, @Param("isOrder") boolean isOrder);

    void deleteMenu(@Param("menuId") Integer menuId);

    List<AuthMenu> findCustomerServiceTemplateByParId(@Param("parentMenuId") Integer parentMenuId);

}
