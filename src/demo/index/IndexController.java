package demo.index;

import com.jfinal.core.Controller;

/**
 * Created by Hong on 1/6/2016.
 */
public class IndexController extends Controller {
    public void index() {
        render("index.html");
    }
}
