package baseball.model;

import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class BaseballNumber {

    private final List<Integer> numbers;

    public BaseballNumber(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateInRange(numbers);
        validateNotDuplicated(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 3) {
            throw new IllegalArgumentException();
        }
    }

    private void validateInRange(List<Integer> numbers) {
        if (numbers.stream().anyMatch(number -> number < 1 || number > 9)) {
            throw new IllegalArgumentException();
        }
    }

    private void validateNotDuplicated(List<Integer> numbers) {
        if (numbers.stream().distinct().toList().size() != numbers.size()) {
            throw new IllegalArgumentException();
        }
    }

    public int get(int index) {
        return numbers.get(index);
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }

    public int size() {
        return numbers.size();
    }

    public Stream<Integer> stream() {
        return numbers.stream();
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        return object instanceof BaseballNumber other && numbers.equals(other.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }
}