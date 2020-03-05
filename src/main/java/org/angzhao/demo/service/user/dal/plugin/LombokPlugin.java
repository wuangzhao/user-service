package org.angzhao.demo.service.user.dal.plugin;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.Interface;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.TopLevelClass;
import org.mybatis.generator.internal.util.StringUtility;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class LombokPlugin extends PluginAdapter {

    @Override
    public boolean validate(List<String> list) {
        return true;
    }

    @Override
    public boolean modelBaseRecordClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        //添加domain的import
        topLevelClass.addImportedType("lombok.Data");

        //添加domain的注解
        topLevelClass.addAnnotation("@Data");

        //添加domain的注释
        topLevelClass.addJavaDocLine("/**");
        topLevelClass.addJavaDocLine("* @author Mybatis Generator");
        topLevelClass.addJavaDocLine("* @date " + date2Str(new Date()));
        topLevelClass.addJavaDocLine("* @tableName " + introspectedTable.getTableConfiguration().getTableName());
        String remarks = introspectedTable.getRemarks();
        //根据参数和备注信息判断是否添加备注信息
        if (StringUtility.stringHasValue(remarks)) {
            topLevelClass.addJavaDocLine("* @description " + remarks);
        }
        topLevelClass.addJavaDocLine("*/");
        return true;
    }

    @Override
    public boolean modelExampleClassGenerated(TopLevelClass topLevelClass,
                                              IntrospectedTable introspectedTable) {
        //添加Example的注释
        topLevelClass.addJavaDocLine("/**");
        topLevelClass.addJavaDocLine("* @author Mybatis Generator");
        topLevelClass.addJavaDocLine("* @date " + date2Str(new Date()));
        topLevelClass.addJavaDocLine("*/");
        return true;
    }

    @Override
    public boolean clientGenerated(Interface interfaze, TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        FullyQualifiedJavaType fullyQualifiedJavaType = new FullyQualifiedJavaType("org.apache.ibatis.annotations.Mapper");
        interfaze.addImportedType(fullyQualifiedJavaType);
        //Mapper文件的注释
        interfaze.addJavaDocLine("/**");
        interfaze.addJavaDocLine("* @author Mybatis Generator");
        interfaze.addJavaDocLine("* @date " + date2Str(new Date()));
        interfaze.addJavaDocLine("*/");
        interfaze.addJavaDocLine("@Mapper");
        return true;
    }

    @Override
    public boolean modelSetterMethodGenerated(Method method, TopLevelClass topLevelClass, IntrospectedColumn introspectedColumn, IntrospectedTable introspectedTable, ModelClassType modelClassType) {
        //不生成getter
        return false;
    }

    @Override
    public boolean modelGetterMethodGenerated(Method method, TopLevelClass topLevelClass, IntrospectedColumn introspectedColumn, IntrospectedTable introspectedTable, ModelClassType modelClassType) {
        //不生成setter
        return false;
    }

    private String date2Str(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        return sdf.format(date);
    }
}
