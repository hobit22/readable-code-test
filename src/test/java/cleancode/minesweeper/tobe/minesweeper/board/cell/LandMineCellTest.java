package cleancode.minesweeper.tobe.minesweeper.board.cell;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

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
