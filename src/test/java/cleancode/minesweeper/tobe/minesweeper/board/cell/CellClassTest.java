package cleancode.minesweeper.tobe.minesweeper.board.cell;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class CellClassTest {

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

    @DisplayName("Cell들이 지뢰인지 아닌지 알 수 있다.")
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
}
