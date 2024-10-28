![image](https://github.com/user-attachments/assets/f37f95a7-7a5f-43ef-b3c8-cd8d76e1b618)
> 7기 프리코스 2주차 미션 - 자동차 경주
> ====================== 
> java-calculator-precourse
<br>

# **학습 목표**

- 여러 역할을 수행하는 큰 함수를 단일 역할을 수행하는 작은 함수로 분리한다.
- 테스트 도구를 사용하는 방법을 배우고 프로그램이 제대로 작동하는지 테스트한다.
- [1주 차 공통 피드백](https://docs.google.com/document/d/1MdiqBV5nhSfFB96-p5LlKrGM8uLopXslh1vEzwxR9Bo/edit?usp=sharing)을 최대한
  반영한다.

# **기능 요구 사항**

초간단 자동차 경주 게임을 구현한다.

- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.

---

- 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.

---

- 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.

---

- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
- 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.

---

- 사용자가 잘못된 값을 입력할 경우`IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료되어야 한다.

---

# **✏️ 프로그램의 흐름 정리**

<aside>

1. 사용자의 입력(몇 번의 이동을 할 것인지 = 주어진 횟수)을 받음
2. 주어진 횟수 동안 전진/멈춤을 처리

   → 전진은 0 ~ 9 사이에서 무작위 값을 선택해서 값이 4 이상이면 전진

   → 즉, 사용자의 입력과는 무관하고 랜덤으로 전진하는 방식

3. 매 차수마다 각 자동차가 전진했는지 멈춰있는지를 출력
4. 주어진 횟수가 끝나면 가장 많이 전진한 차량을 최종 우승자로 선정해서 출력

   → 다수가 우승했을 경우 쉼표를 이용해서 출력해야 함

**`잘못된 값`  정의**

- 시도할 횟수가 `음수` 일 경우
- 시도할 횟수가 `0` 일 경우
- 시도할 횟수에 `정수가 아닌 것` 이 입력되는 경우
- 이름이 `5글자` `이상`인 경우
- 이름 구분을 `쉼표` 로 하지 않은 경우

  → 자연스럽게 5글자 이상으로 인식되게끔 처리

- 이름을 입력할 때 이름 전후에 `공백`을 포함한 경우

  → 공백은 `trim()` 메서드를 이용해서 공백을 제거해주기

  → 이름 중간의 공백은 허용함, 5글자만 넘지 않으면

- 이름을 입력할 때 이름이 공백인 경우

  → 해당 상황은 `pobi, ,woni`  와 같은 경우인데, 공백은 이름이라고 볼 수 없음

- 이름을 입력할 때 이름이 없는 경우

  → 해당 상황은 `pobi,,woni` 와 같은 경우인데, 이름이 없는 상황은 잘못된 값

- 이름이 중복되는 경우

  → 이름은 다른 것과 구별되기 위한 것이기에, 중복은 허용하지 않는 것으로 함

- 아무런 이름을 입력하지 않는 경우

  → 해당 상황은 `,` , `\n` 와 같은 경우인데, 인식할 이름이 없는 경우는 잘못된 값

</aside>

--- 

# **기능 구현 목록**

## 1. 사용자 입력 처리

- [x] **자동차 이름 입력받기**
    - [x] 쉼표(,)로 구분된 이름 입력
    - [x] 각 이름은 5자 이하로 제한
    - [x] 중복된 이름 없는지 검증
    - [x] 이름 앞뒤의 공백 제거(`trim()`)
    - [x] 비어있는 이름 입력 시 예외 처리

- [x] **시도 횟수 입력받기**
    - [x] 음수 입력 시 예외 처리
    - [x] 0 입력 시 예외 처리
    - [x] 정수가 아닌 값 입력 시 예외 처리

---

## 2. 자동차 객체 생성 및 초기화

- [x] **자동차 객체(CarInfo) 생성**
    - [x] 입력된 이름을 기반으로 객체 생성
    - [x] 각 자동차의 초기 이동 칸 수를 0으로 설정

---

## 3. 경주 진행 (RaceProcessService)

- [x] **경주를 시도 횟수만큼 반복**
    - [x] 각 시도마다 무작위 값 생성(RandomNumber)
        - [x] 4 이상일 경우 자동차가 전진

---

## 4. 자동차 상태 업데이트 및 이동 거리 출력

- [x] **자동차 이동 결과 출력**
    - [x] 매 시도 후 모든 자동차의 이동 거리 출력
        - 예시: `pobi : --, woni : ---`
    - [x] 자동차의 이름과 이동 칸 수를 RaceResultDTO로 관리

---

## 5. 우승자 선정 (RaceResultEvaluator)

- [x] **최종 우승자 선정**
    - [x] 경주 종료 후 가장 멀리 이동한 자동차를 선정
    - [x] 단독 우승자: `최종 우승자: pobi`
    - [x] 공동 우승자: `최종 우승자: pobi, jun`

---

## 6. 입력 및 예외 처리

- [x] **IllegalArgumentException 예외 처리**
    - [x] 잘못된 값 입력 시 예외 발생
    - [x] 예외 메시지 출력 후 프로그램 종료
    - [x] 에러 메시지 관리: ErrorMessage 상수화

---

## 7. MVC 패턴 구현

- [x] **RaceViewController**
    - [x] InputView와 OutputView를 사용해 사용자와 상호작용

- [x] **RaceProcessController**
    - [x] 비즈니스 로직 수행 및 결과 전달

- [x] **팩토리 패턴 적용**
    - [x] DomainFactory를 통해 도메인 객체 생성 위임
    - [x] RaceProcessService에서 직접 객체를 생성하지 않도록 설계

---

## 8. 테스트 코드 작성 및 검증

- [x] **테스트 항목**
    - [x] 이름 검증(NameValidation) 테스트
    - [x] 시행 횟수 검증(NumberOfTrialValidation) 테스트
    - [x] 경주 로직 테스트
    - [x] 우승자 선정 로직 테스트

---

## 9. 상수 및 메시지 관리

- [x] **ErrorMessage**: 에러 메시지 상수화
- [x] **IOMessage**: 입출력 메시지 상수화

# **프로젝트 구조**

- Controller
    - RaceProcessController // 로직 수행 관련 컨트롤러
    - RaceViewController // 입출력 관련 컨트롤러
- DTO
    - RaceFinalWinnerDTO // 최종 우승자 관련 DTO
    - RaceInfoDTO // 로직 수행 관련 DTO
    - RaceResultDTO // 레이스 결과 입출력 관련 DTO
- Domain
    - CarInfo // 자동차의 상태 객체 (이름, 현재 이동 칸수, 전진) 캡슐화
    - RandomNumber // 랜덤한 정수 생성
    - RaceResultEvaluator // 우승자 선정
- Service
    - RaceProcessService // 관련 도메인들 모아서 비즈니스 로직 처리
- Validation
    - NameValidation // 이름 관련 검증
    - NumberOfTrialValidation // 시행 횟수 관련 검증
- Factory
    - ControllerFactory // 컨트롤러 객체 생성 위임
    - DomainFactory // 도메인 객체 생성 위임
- Util
    - Constants // 전반적으로 사용되는 상수 관리
        - Constant
    - Exception
        - ErrorMessage // 에러 메시지 관련 문자열 상수화
        - ExceptionType // Enum 객체
    - Message // 문자열 관련 상수
        - IOMessage // 입출력 관련 문자열 상수화
- View
    - InputView // 사용자에게 보여질 화면 (입력)
    - OutputView // 사용자에게 보여질 화면 (출력)
- racingcar
    - Application // 진입점

---

