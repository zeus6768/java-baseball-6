package baseball.model;

public enum ResultType {
    NOTHING,
    BALL,
    STRIKE,
    BALL_AND_STRIKE,
    THREE_STRIKE;

    static ResultType findByBallAndStrike(int ball, int strike) {
        if (ball == 0 && strike == 0) {
            return NOTHING;
        }
        if (ball != 0 && strike != 0) {
            return BALL_AND_STRIKE;
        }
        if (ball != 0) {
            return BALL;
        }
        if (strike == 3) {
            return THREE_STRIKE;
        }
        return STRIKE;
    }
}
