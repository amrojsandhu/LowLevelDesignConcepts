package oops.assignments.feature.gating;

public abstract class Token<E extends Comparable<E>> {

    E token;

    public Token(E token) {
        this.token = token;
    }

    public E get() {
        return token;
    }

    @Override
    public String toString() {
        return "Token{" +
                "token=\"" + token +
                "\"}";
    }
}
