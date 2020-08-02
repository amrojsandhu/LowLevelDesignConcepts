package oops.assignments.feature.gating.operands;

import oops.assignments.feature.gating.Token;

public class Operand<E extends Comparable<E>> extends Token<E> implements Comparable<E> {

    public Operand(E token) {
        super(token);
    }

    public E get() {
        return super.get();
    }

    @Override
    public int compareTo(E o) {
        E e = get();
        return o.compareTo(e);
    }
}
