package minesweeper.model

class Board(val cells: Cells) {

    val width: Width = Width.valueOf(cells.maxColumnOrNull()?.value)

    val height: Height = Height.valueOf(cells.maxRowOrNull()?.value)

    fun mine(position: Position): Board = cells
        .mine(position)
        .incrementAll(position.asDirections())
        .let { Board(it) }

    companion object {
        val EMPTY = Board(Cells.EMPTY)

        fun create(width: Width, height: Height): Board {
            if (width == Width.ZERO || height == Height.ZERO) {
                return EMPTY
            }
            val positions = Position.list(width, height)
            val cells: List<Cell> = positions.map { position -> Cell.Zero(position) }
            return Board(Cells(cells))
        }
    }
}
