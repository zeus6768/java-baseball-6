package baseball.view.input;

import java.util.Arrays;

import baseball.model.Numbers;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public Numbers askNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String numberInput = Console.readLine();
        return new Numbers(Arrays.stream(numberInput.split(""))
                .mapToInt(Integer::parseInt)
                .boxed()
                .toList()
        );
    }
}
