package baseball;

import java.util.List;

import baseball.model.Numbers;
import baseball.model.Referee;
import baseball.view.input.InputView;
import camp.nextstep.edu.missionutils.Randoms;

public class BaseballGame {

    private final InputView inputView;

    public BaseballGame(InputView inputView) {
        this.inputView = inputView;
    }

    public void play() {
        Numbers numbers = new Numbers(generateRandomUniqueThreeDigitNumber());
        Numbers userNumbers = inputView.askNumber();
        Referee referee = new Referee(numbers);

    }

    private List<Integer> generateRandomUniqueThreeDigitNumber() {
        return Randoms.pickUniqueNumbersInRange(1, 9, 3);
    }
}
