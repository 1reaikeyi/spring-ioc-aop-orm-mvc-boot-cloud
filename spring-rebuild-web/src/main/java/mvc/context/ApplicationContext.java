package mvc.context;

import mvc.annotion.Controller;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class ApplicationContext {
    private Map<String,Object> map = new HashMap<>();
    public ApplicationContext(String contextPath) {
        SAXReader reader = new SAXReader();
        Document document = null;
        try {
            reader.read(new File(contextPath));
        } catch (DocumentException e) {
            throw new RuntimeException(e);
        }
        Node root = document.getRootElement();
        Element element1 = (Element) root.selectSingleNode("/beans/comment-scan");
        try {
            componentScan(element1);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println("ioc加载的bean" + map);
        Element element2 = (Element) root.selectSingleNode("/beans/bean");
        createViewResolver(element2);
        Element element3 = (Element) root.selectSingleNode("/beans/interceptors");
        createInterceptor(element3);
        createHandlerMapping("mvc/controller");
        createHandlerAdapter("mvc/controller");
    }
    private void componentScan(Element element1) throws Exception {
        String basePackage = element1.attributeValue("base-package");
        String path = basePackage.replace(".","/");
        URL url = Thread.currentThread().getContextClassLoader().getResource(path);
        if(url == null){
            throw new RuntimeException("资源找不到：" + basePackage);
        }
        //解码，解决%xx乱码，指定UTF‑8编码
        String absolite = URLDecoder.decode(url.getPath(), StandardCharsets.UTF_8);
        File[] files = new File(absolite).listFiles();
        for (File file : files) {
            String className = file.getName().substring(0,file.getName().lastIndexOf("."));
            Class<?> clazz = Class.forName(className);
            if (clazz.isAnnotationPresent(Controller.class)) {
                Object object = clazz.newInstance();
                map.put(className.charAt(0) + "".toLowerCase()+className.substring(1), object);
            };
        }

    }
    private void createViewResolver(Element element2) {

    }
    private void createInterceptor(Element element3) {

    }
    private void createHandlerMapping(String s) {
    }

    private void createHandlerAdapter(String s) {

    }

    private Object getBean(String beanName) {
        return map.get(beanName);
    }
}
/**
 * <!--    组件扫描-->
 *     <component-scan base-package="use"/>
 * <!--    视图-->
 *     <bean class="mvc.view">
 *         <property name="prefix" value="web/"/>
 *         <property name="suffix" value=".html"/>
 *     </bean>
 * <!--    拦截器-->
 *     <interceptors>
 *         <bean class="mvc.interceptor.Interceptor1.java"/>
 *         <bean class="mvc.interceptor.Interceptor2.java"/>
 *     </interceptors>
 */
