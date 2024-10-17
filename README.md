# Readable Code

[Readable Code: 읽기 좋은 코드를 작성하는 사고법](https://inf.run/kHiWM) 의 예제 코드입니다.

## 인프런 워밍업 클럽 2기 클린코드&백엔드 미션 Day12 

### 미션 내용
[Readable Code] 강의의 두 프로젝트(지뢰찾기, 스터디카페) 중 하나를 골라, 단위 테스트를 작성해 봅시다.
조건은 아래와 같습니다.

✔️각 프로젝트 모두 강의 중에 작성한 tobe 패키지 코드를 기준으로 함 (lesson 6-4 가 가장 마지막 버전)  
✔️3개 이상의 서로 다른 클래스 & 총 7개 이상의 테스트 작성 (시간이 된다면 더 많이 작성해보면 좋겠죠? 😉)
> ➡️ 단, 같은 인터페이스를 구현하고 있는 구현체들은 1개 클래스로 간주한다.   
> (ex. LandMineCell, NumberCell, EmptyCell에 각자 테스트를 작성했어도, 1개 클래스로 간주.)

✔️무엇을 테스트하고자 했는지를 잘 나타낸 @DisplayName 작성하기   
✔️BDD(given/when/then) 스타일 따르기 (주석으로 표기)    

## Minesweeper 에 대해 Test Code 작성하기

### 어떤 클래스를 테스트 해야할까?
테스트를 작성려고 하는 클래스는 다음과 같다.
1. Cell
    - LandMindCell
    - NumberCell
    - EmptyCell   
2. CellPosition
3. GameBoard

지뢰찾기를 하기 위해 최소한으로 필요한 도메인이 무엇일까? 라고 고민한 결과 위 3개의 도메인이 핵심이라고 판단하였다.


### interface 를 테스트 할 때...
`Cell` 을 테스트 하려고 할 때 어떻게 테스트 코드를 작성하는게 좋을까?

1. `CellClassTest` 를 작성하고 모든 구현체를 테스트한다.
   1. 한개의 클래스에 각 구현체 별로 테스트코드가 생성한다?
         ```java
           @DisplayName("LandMine은 지뢰다.")
           @Test
           void isLandMineTest1() {
           // given
           Cell cell = new LandMineCell();
        
                // when
                boolean result = cell.isLandMine();
        
                // then
                assertThat(result).isTrue();
           }
           @DisplayName("NumberCell은 지뢰가 아니다.")
           @Test
           void isLandMineTest() {
           // given
           Cell cell = new NumberCell(0);
        
                // when
                boolean result = cell.isLandMine();
        
                // then
                assertThat(result).isFalse();
           }
        
           @DisplayName("EmptyCell은 지뢰가 아니다.")
           @Test
           void isLandMineTest3() {
           // given
           Cell cell = new EmptyCell();
        
                // when
                boolean result = cell.isLandMine();
        
                // then
                assertThat(result).isFalse();
           }
            ```
   2.  코드는 거의 동일하니 parameterizedTest를 사용한다?
        ```java
        @DisplayName("Cell 이 지뢰인지 아닌지 알 수 있다.")
        @ParameterizedTest
        @MethodSource("provideCellData")
        void isLandMineTest4(Cell cell, boolean result) {
            // given
    
            // when
    
            // then
            assertThat(cell.isLandMine()).isEqualTo(result);
        }
    
        private static Stream<Arguments> provideCellData() {
            return Stream.of(
                Arguments.of(new LandMineCell(), true),
                Arguments.of(new EmptyCell(), false),
                Arguments.of(new NumberCell(1), false)
            );
        }
        ```
2. 구현체들을 테스트하는 코드는 거의 중복이니 테스트 인터페이스(`CellTest`)를 만든다?
   ```java
    public interface CellTest <T extends Cell> {
    
        void isLandMineTest();
    
    }
    ```
   ```java
    class EmptyCellTest implements CellTest<EmptyCell> {
    
        @DisplayName("EmptyCell은 자뢰가 아니다.")
        @Test
        @Override
        public void isLandMineTest() {
            // given
            EmptyCell cell = new EmptyCell();
    
            // when
            boolean isLandMine = cell.isLandMine();
    
            // then
            assertThat(isLandMine).isFalse();
        }
   }
    
    class LandMineCellTest implements CellTest<LandMineCell> {
    
        @Override
        @DisplayName("LandMineCell은 지뢰다.")
        @Test
        public void isLandMineTest() {
            // given
            Cell cell = new LandMineCell();
    
            // when
            boolean isLandMine = cell.isLandMine();
    
            // then
            assertThat(isLandMine).isTrue();
        }
    }


    class NumberCellTest implements CellTest<NumberCell>{
    
        @Override
        @DisplayName("NumberCell은 자뢰가 아니다.")
        @Test
        public void isLandMineTest() {
            // given
            Cell cell = new NumberCell(1);
    
            // when
            boolean isLandMine = cell.isLandMine();
    
            // then
            assertThat(isLandMine).isFalse();
    
        }
    }
    ```
