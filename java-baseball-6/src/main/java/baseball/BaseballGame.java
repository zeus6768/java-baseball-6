package baseball;

import java.util.List;

import baseball.model.BaseballNumber;
import baseball.model.CompareResult;
import baseball.model.ResultType;
import baseball.model.Referee;
import baseball.view.input.InputView;
import camp.nextstep.edu.missionutils.Randoms;

public class BaseballGame {

    private final InputView inputView;

    public BaseballGame(InputView inputView) {
        this.inputView = inputView;
    }

    public void play() {
        BaseballNumber computerNumber = new BaseballNumber(generateRandomUniqueThreeDigitNumber());
        Referee referee = new Referee(computerNumber);
        boolean gameStatus = true;
        while (gameStatus) {
            BaseballNumber userBaseballNumber = inputView.askNumber();
            CompareResult result = referee.compare(userBaseballNumber);
        }
    }

    private List<Integer> generateRandomUniqueThreeDigitNumber() {
        return Randoms.pickUniqueNumbersInRange(1, 9, 3);
    }
}
