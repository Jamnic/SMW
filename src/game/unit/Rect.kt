package game.unit

class Rect(
        private val size: Size = Size(),
        private var position: Position = Position()
) {

    fun position(): Position {
        return position
    }

    fun intersects(rect: Rect) = verticalIntersection(rect) && horizontalIntersection(rect)

    private fun verticalIntersection(rect: Rect) = upCollision(rect) || downCollision(rect)
    private fun horizontalIntersection(rect: Rect) = leftCollision(rect) || rightCollision(rect)

    private fun upCollision(rect: Rect) = rect.upEdge() in this.upEdge()..this.downEdge()
    private fun downCollision(rect: Rect) = rect.downEdge() in this.upEdge()..this.downEdge()
    private fun leftCollision(rect: Rect) = rect.leftEdge() in this.leftEdge()..this.rightEdge()
    private fun rightCollision(rect: Rect) = rect.rightEdge() in this.leftEdge()..this.rightEdge()

    private fun upEdge(): Double = position.y()
    private fun downEdge(): Double = position.y() + size.height
    private fun leftEdge(): Double = position.x()
    private fun rightEdge(): Double = position.x() + size.width

    private fun leftUpCorner(): Position = this.position
    private fun leftDownCorner(): Position = this.position + Position(0.0, this.size.height)
    private fun rightUpCorner(): Position = this.position + Position(this.size.width, 0.0)
    private fun rightDownCorner(): Position = this.position + Position(this.size.width, this.size.height)

    private fun upCornerCollision(rect: Rect): Boolean = leftDownCorner().y() == rect.upEdge() || rightDownCorner().y() == rect.upEdge()
    private fun downCornerCollision(rect: Rect): Boolean = leftUpCorner().y() == rect.downEdge() || rightUpCorner().y() == rect.downEdge()

    private fun rightCornerCollision(rect: Rect): Boolean = leftDownCorner().x() == rect.rightEdge() || leftUpCorner().x() == rect.rightEdge()
    private fun leftCornerCollision(rect: Rect): Boolean = rightUpCorner().x() == rect.leftEdge() || rightDownCorner().x() == rect.leftEdge()

    fun cornerCollisionDirection(rect: Rect): Direction {
        return when {
            leftCornerCollision(rect) && upCornerCollision(rect) -> Direction.NONE
            rightCornerCollision(rect) && upCornerCollision(rect) -> Direction.NONE
            rightCornerCollision(rect) && downCornerCollision(rect) -> Direction.NONE
            leftCornerCollision(rect) && downCornerCollision(rect) -> Direction.NONE
            rightCornerCollision(rect) -> Direction.LEFT
            leftCornerCollision(rect) -> Direction.RIGHT
            upCornerCollision(rect) -> Direction.DOWN
            downCollision(rect) -> Direction.UP
            else -> Direction.NONE
        }
    }

    override fun toString(): String {
        return "$position - $size"
    }

    fun update(velocity: Velocity) {
        this.position = position + velocity
    }

    fun update(position: Position) {
        this.position = position
    }
}