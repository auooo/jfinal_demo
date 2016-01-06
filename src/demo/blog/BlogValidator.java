package demo.blog;

import com.jfinal.core.Controller;
import com.jfinal.validate.Validator;
import demo.common.model.Blog;

/**
 * BlogValidator
 * Created by Hong on 1/6/2016.
 */
public class BlogValidator extends Validator {

    @Override
    protected void validate(Controller c) {
        validateRequiredString("blog.title", "titleMsg", "请输入Blog标题");
        validateRequiredString("blog.content", "contentMsg", "请输入Blog内容");
    }

    @Override
    protected void handleError(Controller c) {
        controller.keepModel(Blog.class);

        String actionKey = getActionKey();
        if (actionKey.equals("/blog/save")) {
            controller.render("add.html");
        } else if (actionKey.equals("/blog/update")) {
                controller.render("edit.html");
        }
    }
}
