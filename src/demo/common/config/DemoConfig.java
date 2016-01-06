package demo.common.config;

import com.jfinal.config.*;
import com.jfinal.core.JFinal;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.c3p0.C3p0Plugin;
import demo.blog.BlogController;
import demo.common.model._MappingKit;
import demo.index.IndexController;

/**
 *  API 引导式配置
 */
public class DemoConfig extends JFinalConfig {

    /**
     * 配置常量
     * @param me
     */
    public void configConstant(Constants me) {
        // 加载少量必要配置，随后可用PropKit.get(...)获取值
        PropKit.use("a_little_config.txt");
        me.setDevMode(PropKit.getBoolean("devMode", false));
    }

    /**
     * 配置路由
     * @param me
     */
    public void configRoute(Routes me) {
        me.add("/", IndexController.class, "/index");   // 第三个参数为该 Controller 的视图存放路径
        me.add("/blog", BlogController.class);   // 第三个参数省略时默认与第一个参数值相同，在此即为"/blog"
    }

    public static C3p0Plugin createC3p0Plugin() {
        return new C3p0Plugin(PropKit.get("jdbcUrl"), PropKit.get("user"), PropKit.get("password").trim());
    }

    /**
     * 配置插件
     * @param me
     */
    public void configPlugin(Plugins me) {
        // 配置 C3p0 数据库连接池插件
        C3p0Plugin c3p0Plugin = createC3p0Plugin();
        me.add(c3p0Plugin);

        // 配置 ActiveRecord 插件
        ActiveRecordPlugin arp = new ActiveRecordPlugin(c3p0Plugin);
        me.add(arp);

        // 所有配置在 MappingKit 中搞定
        _MappingKit.mapping(arp);
    }

    /**
     * 配置全局拦截器
     * @param me
     */
    public void configInterceptor(Interceptors me) {
    }

    /**
     * 配置处理器
     * @param me
     */
    public void configHandler(Handlers me) {
    }

    /**
     * 建议使用 JFinal 手册推荐的方式启动项目
     * 运行此 main 方法可以启动项目，此 main 方法可放置在任意的 Class 类定义中，不一定要放于此
     */
    public static void main(String[] args) {
        JFinal.start("web", 80, "/", 5);
    }
}