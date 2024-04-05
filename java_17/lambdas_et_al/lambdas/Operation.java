package java_17.lambdas_et_al.lambdas;

@FunctionalInterface
public interface Operation<T> {
    
    T operate(T value1, T value2);
}
