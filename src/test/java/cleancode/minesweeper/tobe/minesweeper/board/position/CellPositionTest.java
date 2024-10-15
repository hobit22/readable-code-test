package cleancode.minesweeper.tobe.minesweeper.board.position;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CellPositionTest {

    @DisplayName("열 또는 행이 0 미만으로 위치를 고르면 에러를 발생한다.")
    @ParameterizedTest
    @CsvSource(value = {"-1,0", "0, -1", "-1, -1"})
    void createCellPositionByMinus(int rowIndex, int colIndex) {
        // given

        // when
        // then
        assertThatThrownBy(()->CellPosition.of(rowIndex, colIndex))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("열 또는 행을 0 이상으로 고르면 CellPosition이 생성된다.")
    @Test
    void createCellPosition() {
        // given
        int rowIndex = 0;
        int colIndex = 0;

        // when
        CellPosition cellPosition = CellPosition.of(rowIndex, colIndex);

        // then
        assertThat(cellPosition).isNotNull();
        assertThat(cellPosition.getRowIndex()).isEqualTo(rowIndex);
        assertThat(cellPosition.getColIndex()).isEqualTo(colIndex);
    }

    @DisplayName("입력한 rowIndex 값이 현재 CellPosition의 rowIndex보다 크거나 같은지 알 수 있다.")
    @Test
    void isRowIndexMoreThanOrEqual() {
        // given
        int rowIndex = 0;
        CellPosition cellPosition = CellPosition.of(rowIndex, 0);

        int inputRowIndex = 0;
        // when
        boolean result = cellPosition.isRowIndexMoreThanOrEqual(inputRowIndex);

        // then
        assertThat(result).isTrue();
    }

    @DisplayName("입력한 colIndex 값이 현재 CellPosition의 colIndex보다 크거나 같은지 알 수 있다.")
    @Test
    void isColIndexMoreThanOrEqual() {
        // given
        int colIndex = 0;
        CellPosition cellPosition = CellPosition.of(0, colIndex);

        int inputColIndex = 0;
        // when
        boolean result = cellPosition.isColIndexMoreThanOrEqual(inputColIndex);

        // then
        assertThat(result).isTrue();
    }

    @DisplayName("입력한 rowIndex 값이 현재 CellPosition의 rowIndex 작은지 알 수 있다.")
    @Test
    void isRowIndexLessThan() {
        // given
        int rowIndex = 0;
        CellPosition cellPosition = CellPosition.of(rowIndex, 0);

        int inputRowIndex = -1;
        // when
        boolean result = cellPosition.isRowIndexLessThan(inputRowIndex);

        // then
        assertThat(result).isFalse();
    }

    @DisplayName("입력한 colIndex 값이 현재 CellPosition의 colIndex보다 작은지 알 수 있다.")
    @Test
    void isColIndexLessThan() {
        // given
        int colIndex = 0;
        CellPosition cellPosition = CellPosition.of(0, colIndex);

        int inputColIndex = -1;
        // when
        boolean result = cellPosition.isColIndexLessThan(inputColIndex);

        // then
        assertThat(result).isFalse();
    }

    @DisplayName("계산가능한 위치인지 확인할 수 있다.")
    @Test
    void canCalculatePositionBy() {
        // given

        // when

        // then
    }

    @DisplayName("게산가능한 위치가 아니라면 에러를 발생한다.")
    @Test
    void calculatePositionBy() {
        // given

        // when

        // then
    }

}
