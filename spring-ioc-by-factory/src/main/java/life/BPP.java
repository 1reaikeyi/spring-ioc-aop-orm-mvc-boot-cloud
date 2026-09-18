package life;

import org.springframework.beans.factory.config.BeanPostProcessor;

public class BPP implements BeanPostProcessor {


    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) {
        System.out.println("postProcessBeforeInitialization，管理员检查打印机组");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) {
        System.out.println("postProcessAfterInitialization，开始日志记录");
        return bean;
    }
}
