# step1

### 로또?
- 6/45, 1~45 번째 번호 중에서 6개 정수를 골라야한다.
- 이 정수는 서로 겹치지 않는다.

### 어떻게 짤까?
- 일단 6회 반복문이 필요하긴 할 듯.
- 근데 이전에 나온 정수는 배제해야하니까 기록을 해야할 것 같음. js map/set 같은걸 찾아보자.
- 배열을 사용하지 않아야하니까 리스트로 관리하는 편이 좋을 것 같다.

### 문자열을 파싱할 때 발생할 수 있는 에러는?
- 마이너스 에러
- NaN 에러
- 소수(float, double) 에러
- **구매 금액이 1000원 이하인 경우도 에러로 처리해야할까?**
  - 에러로 처리해보자. 그럼 마이너스 에러를 최소금액 에러로 처리하면 될 듯.

### final vs static final

- (just) final
  - 이 키워드가 붙은 상수는 객체의 상태와 관련이 깊다.
  - 객체가 복사될 때마다 독립적으로 상수를 보유하며, 메모리에 별도로 할당 된다.
- static final
  - 이 키워드가 붙은 상수는 클래스 변수로 선언된다.
  - 또한 모든 객체가 이 상수를 공유하며, 객체의 상태와 무관한 값 (공통 상수)로 적합하다.
  - 메모리를 한번만 사용한다.
- **결론**
  - final : 특정 객체마다 고유한 상수를 부여할 때 사용
  - static final : 물리 상수, 프로그램 내 공통 상수

### Domain
- 도메인은 앱 로직을 정의하는 곳이지 데이터를 가공할 수는 없다.
- 데이터 가공은 서비스에서 진행

# step2

### 당첨 번호 (1,2, 3, ...) 출력 방법
- nextLine 을 사용해야 중간에 space 되어도 안끊기는 전체 입력 문자열을 받을 수 있음
- 근데 그냥 쓰면 이전 버퍼에 남은 줄바꿈 문자가 문제가 될 수 있어서 제거하고 돌려야함.
  ```java
  public String getWinnerString() {
      scanner.nextLine();
      return scanner.nextLine();
  }
  ```
  
### 순서
- 현재 내 데이터 플로우를 생각해보자
  > 1. 사용자에게 로또를 얼마어치 구매할지 받는다
  > 2. 서비스로 보낸다.
  > 3. 서비스에 도메인 메서드를 활용해서 구매 가능한 로또 개수를 받는다.
  > 4. 구매 가능한 로또 개수만큼 LottoTicket을 만들고 LottoTickets로 포장하여 일급 컬렉션으로 만든다.
  > 5. 구매 가능한 로또 개수와 LottoTickets을 출력 가능한 형태로 변형하여 이들을 ResDTO에 담아 컨트롤러로 보낸다
  > 6. 뷰로 결과를 출력하도록 지시한다.
- 근데 문제가 뭐임
  - RM을 보면 로또 티켓을 받고, 그 후에 당첨 번호를 받는다. 그러니까 내 로직으로는 4-5 사이에 해당 행위가 벌어져야 하는것.
  - 근데 `LottoTickets을 출력 가능한 형태로 변형하여` 컨트롤러에 쏴주기 때문에 이걸 다시 도메인으로 당첨번호와 함께 보내서 분석하는게 좀 웃긴 꼴인듯 하다.
- 결론 
  - resDTO에 생짜 LottoTickets를 함께 보내고 당첨 번호를 받고 다시 서비스로 보내는건 어떨까.
  - 그래서 resDTO에는 `구매한 로또 개수, LottoTickets, 변형된 LottoTickets`가 있는거임
- 근데 이래도 되는지 모르겠긴함
  - 너무 비효율적인 것 같다. 데이터 흐름도 좀 복잡해지는것 같고. 일단 이것밖에 생각이 안나긴함.

### 등수
```
- 6개  : 1등 : 2억
- 5개+ : 2등 : 3천만 // step3
- 5개  : 3등 : 1.5천만
- 4개  : 4등 : 5만
- 3개  : 5등 : 5천
```
- 위 식을 표현하기 위한 가장 좋은 자료구조는 뭘까
- DBMS의 외래키처럼 사용되는게 `등수` 아닌가
- `Map<MatchCount, Rank>`, `Map<Rank, Winnings>`를 만들어서 1번 map의 value가 2번 map의 key가 되도록 하면 되지 않을까.

### 등수 자료구조
- 다시 생각해보니까 확장성까지 고려하면 단순히 `Map<MatchCount, Rank>`를 사용할 수는 없겠다.
```
  교환권: <MatchCount : 5, Bounus : 0>
  ---> 교환 결과: <rank : 3, reward : 1.5천>
    
  교환권: <MatchCount : 5, Bounus : 1>
  ---> 교환 결과: <rank : 2, reward : 3천>
```
- 이렇게 구조를 짜는게 더 좋아보이는것 같기도 약간 toJSON 너낌띠로
- 일단 보너스는 나중에 생각하고 정의만 해놓자
- `교환권`을 받아서 MatchCount와 Bounus로 분리하고 그거에 맞게 결과를 반환하는 클래스, 메서드가 필요할 듯. 

### 빌더 패턴

- 메서드 체이닝을 통해 인스턴트 생성 가능
- 다양한 필드값 설정
- 확실히 직관적임
- 옵셔널한 필드를 사용할 때 특히 유용하지 않을까?

- #### 미션에서는 어디에 쓸수 있을까?

  - **1. 로또/당첨 티켓 클래스/인터페이스**
    - 로또 티켓과 당첨번호 티켓이 같은 인터페이스를 공유하니까 거기에 사용 가능할지도
    - 예를 들어 당첨번호에는 optional 한 보너스 번호 메서드를 추가한다거나 하는 식으로
    - 아예 랜덤 번호 생성도 여기서 해버릴까? => 나쁘지 않을지도 => 일단 가독성은 좋아질듯
  - **2. 로또 결과 담는 클래스**
    - 번호 맞힌 개수, 보너스 당첨 여부 등을 체이닝하면 괜찮을듯
    - 이 클래스를 List 에 담은 클래스를 일급 컬렉션으로 만들어도 괜찮은듯. 거기서 수익률, 당첨 번호 개수같은거 getter 메서드로 반환하기
  
- 예시)
  ```java
  public class Car {
      private String name;
      private String type;
      private Boolean oil;
      
      // private constructor
      private Car(Builder builder) {
          this.name = builder.name;
          this.type = builder.type;
          this.oil = builder.oil;
      }
      
      // 빌더 패턴은 독립적으로 동작해야하므로 static 으로 선언
      public static class Builder {
          private String name;
          // 기본값
          private String type = "oil";
          private Boolean oil = true;
        
          // 필수 매개변수
          public Builder(String name) {
              this.name = name;
          }
          
          public Builder withType(String type) {
              this.type = type;
              
              return this;
          }
          
          public Builder withOil(Boolean oil) {
              this.oil = oil;
              
              return this;
          }
          
          public Car build() {
              return new Car(this);
          }
      }
  }
  
  public class Main {
      Car bmwCar = new Car.Builder("bmw").build();
      
      Car bmwDieselCar = new Car.Builder("bmw")
              .withType("diesel")
              .build();
      
      Car bmwNoOilElectronicCar = new Car.Builder("bmw")
              .withType("electronic")
              .withOil(false)
              .build();
  }
  ```

### 정적 팩토리 메서드

- 객체를 생성하는 방식을 통제 및 간소화
- 단일 객체 생성, 캐싱
- 생성자 직접 호출 안함

- #### 미션에서는 어디에 쓸수 있을까?
  - 지금 로또 등수, 상금을 enum 으로 관리할건데 그걸 잘 반환하는 객체가 있었으면 좋겠음. 얘네는 상수니까 굳이 생성자가 필요없기도 하고 아무튼 괜찮을듯?


- 예시)
  ```java
  public class Car {
  
      private String name;
      private String type;
      private Boolean oil;
  
      private Car(String name, String type, Boolean oil) {
          this.name = name;
          this.type = type;
          this.oil = oil;
      }
  
      public static Car createWithOil(String name) {
          return new Car(name, "oil", true);
      }
  
      public static Car createWithDiesel(String name) {
          return new Car(name, "diesel", true);
      }
  
      public static Car createWithoutOil(String name) {
          return new Car(name, "electric", false);
      }
    
  }
  ```
  
### 도메인 그룹화 기준

- **model**
  - 도메인 엔티티 객체로, 시스템의 핵심 비즈니스 로직을 담당
- **vo**
  - 불변 객체이며 식별자가 없고, 값만을 표현
  - `식별자` : 객체를 고유하게 구분할 수 있는 값 (ex. userId)
- **domain service**
  - 도메인 모델 간의 협력 및 비즈니스 로직을 처리 
- **generator**
  - 객체 생성 로직을 캡슐화하고 생성 책임을 담당