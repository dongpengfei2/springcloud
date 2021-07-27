package com.dpf.springcloud.bean;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class AuthMenu extends BaseEntity  {
    private Integer id;
    private String menuName;
    private Integer menuLevel;
    private String menuDescription;
    private Integer parentId;
    private String inUniqueKey;
    private Integer conditionTypeThird;
    private Integer dataDictionaryType;
    private String sqlName;
    private Integer isTabled;
    private Integer tableHeadline;
    private Integer menuStatus;
    private Date createTime;
    private Integer createUerId;
    private Integer orderNum;
    private Integer categoryType; //数据字典数据权限类别
    private String categoryName;
    private Integer categoryOrder;
    private Integer pageType;
    private String tableName;
    private String menuUrl;
    private Integer isPaged;
    private String funnelOrderFiled;
    private String funnelOrderRole;
    private String yAxisName;
    private String xAxisName;
    private String functionColumn;
    private String viewFunctionColumn;
    private String viewFunctionColumnRow;
    private Integer datasource;
    private String groupDefaultValue;
    private Integer filedwidth;
    private String innerfunction;
    private Integer filedtype;
    private Integer groupbyCategory;
    private String groupbyDefaultValue;
    private String datetype;
    private Integer whickday;
    private String searchTypeValue;
    private String replaceValue;
    @Override
    public Object getIdVal() {
        return null;
    }
}
