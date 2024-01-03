package baseball.model;

public class Referee {

    private final Numbers computerNumbers;

    public Referee(Numbers computerNumbers) {
        this.computerNumbers = computerNumbers;
    }

    public CompareResult compare(Numbers userNumbers) {
        userNumbers.stream().forEach(number -> {

        });
        return CompareResult.NOTHING;
    }
}
