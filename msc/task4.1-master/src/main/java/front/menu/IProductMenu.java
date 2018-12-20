package front.menu;

public interface IProductMenu extends IMenu {
    //@Retention(RetentionPolicy.RUNTIME)
    //@Target(ElementType.FIELD)
    @interface RandomGeneratorValue {
        int min() default  1;
        int max() default  100;
    }
}
