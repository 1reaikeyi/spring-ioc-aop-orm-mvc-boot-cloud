package life;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;

public class BeanLife implements BeanNameAware, BeanFactoryAware, DisposableBean, InitializingBean {

    private String id;

    public BeanLife() {
        System.out.println("任务开始编写");
    }

    public BeanLife(String id) {
        this.id = id;
        System.out.println("任务开始编写");
    }

    public void setId(String id) {
        this.id = id;
        System.out.println("加墨，加纸");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("Aware:把任务装入打印机组");
    }
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("Aware:已连接打印机组");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean，打印机开始自检");
    }

    public void initBean(){
        System.out.println("init-method，先试打一张");
    }

    public String getId() {
        return "正式开始打印";
    }
    @Override
    public void destroy() throws Exception {
        System.out.println("DisposableBean关机");
    }
    public void destroyBean(){
        System.out.println("destroy-method关电源");
    }


/**
 * 实例化（构造器）
 * 属性赋值（setter/依赖注入）
 * Aware 接口：BeanNameAware.setBeanName -> BeanClassLoaderAware -> BeanFactoryAware.setBeanFactory（如果有 ApplicationContextAware 等，由 ApplicationContextAwareProcessor 在 BPP before 中调用）
 * BeanPostProcessor.postProcessBeforeInitialization
 * @PostConstruct
 * InitializingBean.afterPropertiesSet
 * 自定义 init-method
 * BeanPostProcessor.postProcessAfterInitialization
 * 使用
 * @PreDestroy
 * DisposableBean.destroy
 * 自定义 destroy-method
 */
}
