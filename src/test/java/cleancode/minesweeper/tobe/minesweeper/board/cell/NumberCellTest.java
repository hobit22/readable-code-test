package cleancode.minesweeper.tobe.minesweeper.board.cell;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

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

    /**
    @Override
    public void hasLandMineCountTest() {

    }

    @Override
    public void getSnapshotTest() {

    }

    @Override
    public void flagTest() {

    }

    @Override
    public void openTest() {

    }

    @Override
    public void isCheckedTest() {

    }

    @Override
    public void isOpenedTest() {

    }
    */
}
