package racingcar.View;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import racingcar.Util.Exception.ErrorMessage;
import racingcar.Util.Message.IOMessage;
import racingcar.Validation.NameValidation;
import racingcar.Validation.TrialCountValidation;

public class InputView {
    public List<String> inputCarName() {
        System.out.println(IOMessage.INPUT_CAR_NAMES.getMessage());
        String names = Console.readLine();

        return splitCarNames(names);
    }

    public Integer inputTrialCount() {
        try {
            System.out.println(IOMessage.INPUT_TRIAL_COUNT.getMessage());
            String count = Console.readLine();

            if (TrialCountValidation.isNotInteger(count)) {
                throw new IllegalArgumentException(ErrorMessage.TRIAL_NOT_INTEGER.getMessage());
            }

            return Integer.parseInt(count);
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

    public List<String> splitCarNames(String names) {
        String[] splitNames = names.split(",");
        List<String> carNames = new ArrayList<>();

        for (String name : splitNames) {
            NameValidation.validateName(name);
            carNames.add(name.trim());
        }

        return carNames;
    }
}