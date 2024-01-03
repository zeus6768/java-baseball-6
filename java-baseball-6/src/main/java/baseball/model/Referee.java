package baseball.model;

public class Referee {

    private final BaseballNumber computerBaseballNumber;

    public Referee(BaseballNumber computerBaseballNumber) {
        this.computerBaseballNumber = computerBaseballNumber;
    }

    public CompareResult compare(BaseballNumber userNumber) {
        int ball = countBall(userNumber);
        int strike = countStrike(userNumber);
        ResultType resultType = ResultType.findByBallAndStrike(ball, strike);
        return new CompareResult(resultType, ball, strike);
    }

    private int countBall(BaseballNumber userBaseballNumber) {
        int result = 0;
        for (int index = 0; index < computerBaseballNumber.size(); index++) {
            int userNumber = userBaseballNumber.get(index);
            if (isBall(index, userNumber)) {
                result++;
            }
        }
        return result;
    }

    private boolean isBall(int index, int userNumber) {
        return computerBaseballNumber.get(index) != userNumber && computerBaseballNumber.contains(userNumber);
    }

    private int countStrike(BaseballNumber userBaseballNumber) {
        int result = 0;
        for (int index = 0; index < computerBaseballNumber.size(); index++) {
            int userNumber = userBaseballNumber.get(index);
            if (isStrike(index, userNumber)) {
                result++;
            }
        }
        return result;
    }

    private boolean isStrike(int index, int userNumber) {
        return computerBaseballNumber.get(index) == userNumber;
    }
}
