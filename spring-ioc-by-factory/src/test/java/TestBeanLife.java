import life.BeanLife;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestBeanLife {

    @Test
    public void main() {
        System.out.println("开始beanDefine");
        ApplicationContext context = new ClassPathXmlApplicationContext("life.xml");
        BeanLife beanLife = context.getBean("life", BeanLife.class);
        beanLife.getId();
        System.out.println("使用");
        ClassPathXmlApplicationContext context1 = (ClassPathXmlApplicationContext)context;
        context1.close();
    }
}
