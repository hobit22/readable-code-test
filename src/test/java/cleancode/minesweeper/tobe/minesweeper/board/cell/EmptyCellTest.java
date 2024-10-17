package cleancode.minesweeper.tobe.minesweeper.board.cell;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

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

