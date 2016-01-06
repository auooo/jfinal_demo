package demo.common.model.base;

import com.jfinal.plugin.activerecord.IBean;
import com.jfinal.plugin.activerecord.Model;

/**
 * Created by Hong on 1/5/2016.
 */
@SuppressWarnings("serial")
public class BaseBlog<M extends BaseBlog<M>> extends Model<M> implements IBean {

    public void setId(java.lang.Integer id) {
        set("id", id);
    }

    public java.lang.Integer getId() {
        return get("id");
    }

    public void setTitle(java.lang.String title) {
        set("title", title);
    }

    public java.lang.String getTitle() {
        return get("title");
    }

    public void setContent(java.lang.String content) {
        set("content", content);
    }

    public java.lang.String getContent() {
        return get("content");
    }
}
