package baseball.view.input;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayInputStream;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import baseball.model.BaseballNumber;
import camp.nextstep.edu.missionutils.Console;

public class InputViewTest {

    InputView inputView;

    @BeforeEach
    void setUp() {
        inputView = new InputView();
    }

    @AfterEach
    void cleanUp() {
        Console.close();
    }

    @Nested
    class AskNumberTest {

        @DisplayName("사용자 수 입력")
        @ParameterizedTest
        @MethodSource
        void askNumberTest(String input, List<Integer> expectedList) {
            setIn(input);
            BaseballNumber actual = inputView.askNumber();
            assertThat(actual).isEqualTo(new BaseballNumber(expectedList));
        }

        private static Stream<Arguments> askNumberTest() {
            return Stream.of(
                    Arguments.of("123", List.of(1, 2, 3)),
                    Arguments.of("321", List.of(3, 2, 1)),
                    Arguments.of("987", List.of(9, 8, 7))
            );
        }

        @DisplayName("사용자 수 입력 예외")
        @ParameterizedTest
        @MethodSource
        void askNumberExceptionTest(String input) {
            setIn(input);
            assertThatThrownBy(() -> inputView.askNumber())
                    .isInstanceOf(IllegalArgumentException.class);
        }

        private static Stream<String> askNumberExceptionTest() {
            return Stream.of(
                    "woowacourse",
                    "1234",
                    "321w",
                    " "
            );
        }
    }

    void setIn(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }
}
