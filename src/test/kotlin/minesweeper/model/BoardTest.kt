package minesweeper.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

class BoardTest {

    @Test
    fun `보드는 Width와 Height를 가진다`() {
        val board = Board(width = 5, height = 10)
        assertAll(
            { assertThat(board.width).isEqualTo(Width.valueOf(5)) },
            { assertThat(board.height).isEqualTo(Height.valueOf(10)) },
        )
    }

    @Test
    fun `보드는 MineCount를 가진다`() {
        val board = Board(width = 2, height = 2, mineCount = 4)
        assertThat(board.mineCount).isEqualTo(MineCount.valueOf(4))
    }

    @Test
    fun `Width나 Height가 0이면 보드는 비어있다`() {
        val board = Board(width = 0, height = 2)
        assertThat(board).isEqualTo(Board.EMPTY)
    }
}
