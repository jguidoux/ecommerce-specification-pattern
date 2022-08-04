package fr.slickteam.ecommerce.regles;


import java.util.Objects;


@FunctionalInterface
public interface Specification<T> {

    boolean isSatisfyBy(T t);

    default Specification<T> and(Specification<? super T> other) {
        Objects.requireNonNull(other);
        return (t) -> isSatisfyBy(t) && other.isSatisfyBy(t);
    }

    default Specification<T> or(Specification<? super T> other) {
        Objects.requireNonNull(other);
        return (t) -> isSatisfyBy(t) || other.isSatisfyBy(t);
    }

    @SuppressWarnings("unchecked")
    static <T> Specification<T> not(Specification<? super T> target) {
        Objects.requireNonNull(target);
        return (Specification<T>)target.negate();
    }

    default Specification<T> negate() {
        return (t) -> !isSatisfyBy(t);
    }

    static <T> Specification<T> isEqual(Object targetRef) {
        return (null == targetRef)
                ? Objects::isNull
                : object -> targetRef.equals(object);
    }
}
