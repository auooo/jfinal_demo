package demo.blog;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;

/**
 * Created by Hong on 1/6/2016.
 * BlogInterceptor
 * 此拦截器仅作为示例展示，在本 demo 中并不需要
 */
public class BlogInterceptor implements Interceptor {

    @Override
    public void intercept(Invocation inv) {
        System.out.println("Before invoking" + inv.getActionKey());
        inv.invoke();
        System.out.println("After invoking" + inv.getActionKey());
    }
}
