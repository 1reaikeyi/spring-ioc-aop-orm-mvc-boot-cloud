import life.BeanLife;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestBeanLife {

    @Test
    public void main() {
        System.out.println("开时");
        ApplicationContext context = new ClassPathXmlApplicationContext("life.xml");
        BeanLife beanLife = context.getBean("life", BeanLife.class);
        System.out.println(beanLife.getId());
        ClassPathXmlApplicationContext context1 = (ClassPathXmlApplicationContext)context;
        context1.close();
        System.out.println("结束");
    }
}
/**
 * 开时
 * 任务开始编写
 * 加墨，加纸
 * Aware:把任务装入打印机组
 * Aware:已连接打印机组
 * postProcessBeforeInitialization，管理员检查打印机组
 * InitializingBean，打印机开始自检
 * init-method，先试打一张
 * postProcessAfterInitialization，开始日志记录
 * 正式开始打印
 * DisposableBean关机
 * destroy-method关电源
 * 结束
 */
