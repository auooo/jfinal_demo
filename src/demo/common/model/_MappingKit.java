package demo.common.model;

import com.jfinal.plugin.activerecord.ActiveRecordPlugin;

/**
 * Created by Hong on 1/6/2016.
 */
public class _MappingKit {

    public static void mapping(ActiveRecordPlugin arp) {
        arp.addMapping("blog", "id", Blog.class);
    }
}