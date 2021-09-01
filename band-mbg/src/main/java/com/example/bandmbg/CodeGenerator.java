package com.example.bandmbg;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;


/**
 * @author faye
 * @create 2021-08-2021/8/27-15:50
 */
public class CodeGenerator {
    public static void main(String[] args) {
        AutoGenerator autoGenerator = new AutoGenerator();
        //全局设置
        GlobalConfig gc = new GlobalConfig();
        String path = "D:/DevSoft/band/band-mbg";
        gc.setOutputDir(path + "/src/main/java");
        gc.setAuthor("AutoGenerator");
        gc.setOpen(false);
        gc.setFileOverride(true);
        gc.setSwagger2(true);
        gc.setBaseResultMap(true);
        gc.setBaseColumnList(true);
        gc.setServiceName("%Service");
        gc.setServiceImplName("%ServiceImpl");
        autoGenerator.setGlobalConfig(gc);
        //数据库设置
        DataSourceConfig dc = new DataSourceConfig();
        dc.setUrl("jdbc:mysql://localhost:3306/band?characterEncoding=UTF-8&useSSL=false&useUnicode=true&serverTimezone=UTC");
        dc.setDriverName("com.mysql.cj.jdbc.Driver");
        dc.setUsername("root");
        dc.setPassword("123456");
        autoGenerator.setDataSource(dc);
        //包设置
        PackageConfig pc = new PackageConfig();
        pc.setParent("com.example.bandmbg.entity");
        autoGenerator.setPackageInfo(pc);


        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);

        TemplateConfig templateConfig = new TemplateConfig();
        templateConfig.setService("");
        templateConfig.setServiceImpl("");
        templateConfig.setController("");
        autoGenerator.setTemplate(templateConfig);
        // 公共父类
//        strategy.setSuperControllerClass("你自己的父类控制器,没有就不用设置!");
        // 写于父类中的公共字段
        strategy.setSuperEntityColumns("id");

        strategy.setControllerMappingHyphenStyle(true);
        strategy.setTablePrefix(pc.getModuleName() + "_");
        autoGenerator.setStrategy(strategy);
        autoGenerator.setTemplateEngine(new FreemarkerTemplateEngine());
        autoGenerator.execute();



    }
}
