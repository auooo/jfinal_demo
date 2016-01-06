package demo.blog;

import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import demo.common.model.Blog;

/**
 * BlogController
 * 所有 sql 与业务逻辑写在 Model 或 Service 中，不要写在 Controller 中。
 * Created by Hong on 1/5/2016.
 */
@Before(BlogInterceptor.class)
public class BlogController extends Controller {
    public void index() {
        setAttr("blogPage", Blog.me.paginate(getParaToInt(0, 1), 10));
        render("blog.html");
    }

    public void add() {
    }

    @Before(BlogValidator.class)
    public void save() {
        getModel(Blog.class).save();
        redirect("/blog");
    }

    public void edit() {
        setAttr("blog", Blog.me.findById(getParaToInt()));
        render("edit.html");
    }

    @Before(BlogValidator.class)
    public void update() {
        getModel(Blog.class).update();
        redirect("/blog");
    }

    public void delete() {
        Blog.me.deleteById(getParaToInt());
        redirect("/blog");
    }
}
