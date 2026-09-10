package life;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;

public class BeanLife implements BeanNameAware, BeanFactoryAware, DisposableBean, InitializingBean {

    private int id;

    public BeanLife() {
        System.out.println("无参构造");
    }

    public BeanLife(int id) {
        this.id = id;
        System.out.println("有参构造");
    }

    public void setId(int id) {
        this.id = id;
        System.out.println("setting");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("Aware:setBeanName");
    }
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("Aware:setBeanFactory");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean");
    }

    public void initBean(){
        System.out.println("@PostConstruct");
    }

    public int getId() {
        return id;
    }
    @Override
    public void destroy() throws Exception {
        System.out.println("DisposableBean:destroy");
    }
    public void destroyBean(){
        System.out.println("@Predestroy");
    }




//    无参构造
//    setting
//    Aware:setBeanName Aware:setBeanFactory
//            postProcessBeforeInitialization
//    InitializingBean
//    预热
//    postProcessAfterInitialization
//    使用
//    pre:destroy
//    destroy
}
