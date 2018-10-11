package exercise;

public class IllegalDivisionByZero extends Exception {
    public IllegalDivisionByZero(String message) {
        super(message);
    }
    public IllegalDivisionByZero() {
        super();
    }
}
