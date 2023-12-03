package baseball;

import java.util.List;

import baseball.model.Numbers;
import camp.nextstep.edu.missionutils.Randoms;

public class BaseballGame {

    public void play() {
        Numbers numbers = new Numbers(generateRandomUniqueThreeDigitNumber());
    }

    private List<Integer> generateRandomUniqueThreeDigitNumber() {
        return Randoms.pickUniqueNumbersInRange(1, 9, 3);
    }
}
