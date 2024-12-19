package com.a23plan.music;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

/**
 * @Author:  err
 * @Description: 测试类
 * @return:
 * @Date:  2024/6/11 13:49
 */
public class CodeGenerator {
    public static void main(String[] args) {
        int max = 5;
        // 上半部分
        for (int i = 1; i <= max; i++) {
            // 前面的空格
            for (int j = 1; j <= (max - i); j++) {
                System.out.print(" ");
            }
            // *
            for (int x = 1; x <= i; x++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        // 下半部分
        for (int i = max - 1; i >= 1; i--) {
            // 前面的空格
            for (int j = 1; j <= (max - i - 1); j++) {
                System.out.print(" ");
            }
            // *
            for (int k = 1; k <= i; k++) {
                System.out.print(" *");
            }
            System.out.println();
        }

        System.out.println("===========================");

        int rows = 9; //   行数
        for (int i = 1; i <= rows; i++) {
            if (i <= max) {
                // 上半部分：打印前面的空格
                for (int j = 1; j <= (max - i); j++) {
                    System.out.print(" ");
                }
                // *
                for (int x = 1; x <= i; x++) {
                    System.out.print("* ");
                }
            } else {
                // 下半部分：打印前面的空格
                for (int j = 1; j <= (i - max -1); j++) {
                    System.out.print(" ");
                }
                // *
                for (int k = 1; k <= (2 * max - i); k++) {
                    System.out.print(" *");
                }
            }
            System.out.println();
        }


        System.out.println("===========================");
        for (int i = 1; i <= rows; i++) {
            // 重置每行打印的空格数和*数
            int spaces = 0;
            int stars = 0;
            if (i <= max) {
                // 上半部分
                spaces = max - i;
                stars = i;
            } else {
                // 下半部分
                // spaces = (rows - i) + (max - (rows - i));
                spaces = (max + i) - rows -1;
                stars = (2 * max) - i;
            }
            for (int j = 0; j < spaces; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < stars; j++) {
                System.out.print("* ");
            }
            // 换行
            System.out.println();
        }
    }

    @Test
    void run(){
        final String projectPath = System.getProperty("user.dir");
        AutoGenerator autoGenerator = new AutoGenerator();

        GlobalConfig config = new GlobalConfig();
        config.setOutputDir(projectPath + "/src/main/java");
        config.setOpen(false);
        config.setAuthor("zyk");
        config.setServiceName("%sService");
        config.setIdType(IdType.AUTO);
        config.setDateType(DateType.ONLY_DATE);
        autoGenerator.setGlobalConfig(config);

        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setUrl("jdbc:mysql://127.0.0.1:3306/music");
        dataSourceConfig.setDriverName("com.mysql.jdbc.Driver");
        dataSourceConfig.setUsername("root");
        dataSourceConfig.setPassword("123456");
        autoGenerator.setDataSource(dataSourceConfig);

        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setParent("com.a23plan.music");
        packageConfig.setEntity("entity");
        packageConfig.setMapper("mapper");
        packageConfig.setController("controller");
        packageConfig.setService("service");
        packageConfig.setServiceImpl("service.Impl");
        autoGenerator.setPackageInfo(packageConfig);

        StrategyConfig strategy = new StrategyConfig();
        strategy.setCapitalMode(true);// 开启全局大写命名
        strategy.setNaming(NamingStrategy.underline_to_camel);// 实体类名驼峰
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);// 属性名驼峰
        strategy.setInclude(new String[] {"account","admin_user","collect","singer","song",
                "songmenu","songmenu_list","carousel"});// 设置要映射的表名
        strategy.setEntityLombokModel(true); // 使用 lombok
        strategy.setRestControllerStyle(true);// 开启 restful风格

        TableFill createTime = new TableFill("create_time", FieldFill.INSERT);
        TableFill updateTime = new TableFill("update_time",FieldFill.INSERT_UPDATE);
        ArrayList<TableFill> tableFills = new ArrayList<>();
        tableFills.add(createTime);
        tableFills.add(updateTime);
        strategy.setTableFillList(tableFills);

        strategy.setRestControllerStyle(true);
        strategy.setControllerMappingHyphenStyle(true);
        autoGenerator.setStrategy(strategy);

        autoGenerator.execute();
    }

    @Test
    void printImg(){
        int n = 5; // 棱形的行数，必须是奇数
        for (int i = 1; i <= n; i += 2) { // 打印上半部分
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for (int i = n - 2; i > 0; i -= 2) { // 打印下半部分
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
