package game.unit

class Rect(
        private val position: Position,
        private val size: Size
) {

    fun intersects(rect: Rect): Boolean {
        val verticalIntersection = verticalIntersection(rect)
        val horizontalIntersection = horizontalIntersection(rect)
        return verticalIntersection && horizontalIntersection
    }

    private fun verticalIntersection(rect: Rect): Boolean {
        return upCollision(rect) || downCollision(rect)
    }

    private fun horizontalIntersection(rect: Rect): Boolean {
        return leftCollision(rect) || rightCollision(rect)
    }

    private fun rightCollision(rect: Rect): Boolean {
        val rectRightSide = rect.position.x() + rect.size.x()

        val thisLeftSide = position.x()
        val thisRightSide = thisLeftSide + size.x()

        return rectRightSide in thisLeftSide..thisRightSide
    }

    private fun leftCollision(rect: Rect): Boolean {
        val rectLeftSide = rect.position.x()

        val thisLeftSide = position.x()
        val thisRightSide = thisLeftSide + size.x()

        return rectLeftSide in thisLeftSide..thisRightSide
    }

    private fun upCollision(rect: Rect): Boolean {
        val rectUpSide = rect.position.y()

        val thisUpSide = position.y()
        val thisDownSide = thisUpSide + size.y()

        return rectUpSide in thisUpSide..thisDownSide
    }

    private fun downCollision(rect: Rect): Boolean {
        val rectDownSide = rect.position.y() + rect.size.y()

        val thisUpSide = position.y()
        val thisDownSide = thisUpSide + size.y()

        return rectDownSide in thisUpSide..thisDownSide
    }


    fun corner(rect: Rect): Direction {
        val upEdge = rect.position.y()
        val downEdge = rect.position.y() + rect.size.y()
        val leftEdge = rect.position.x()
        val rightEdge = rect.position.x() + rect.size.x()

        val leftTop = this.position
        val leftBottom = this.position + Position(0.0, this.size.y())
        val rightTop = this.position + Position(this.size.x(), 0.0)
        val rightBottom = this.position + Position(this.size.x(), this.size.y())

        if (rightBottom.x() == leftEdge && rightBottom.y() == upEdge) {
            return Direction.NONE
        } else if (rightBottom.x() == leftEdge) {
            return Direction.RIGHT
        } else if (rightBottom.y() == upEdge) {
            return Direction.DOWN
        }

        if (leftBottom.x() == rightEdge && leftBottom.y() == upEdge) {
            return Direction.NONE
        } else if (leftBottom.x() == rightEdge) {
            return Direction.LEFT
        } else if (leftBottom.y() == upEdge) {
            return Direction.DOWN
        }

        if (leftTop.x() == rightEdge && leftTop.y() == downEdge) {
            return Direction.NONE
        } else if (leftTop.x() == rightEdge) {
            return Direction.LEFT
        } else if (leftTop.y() == downEdge) {
            return Direction.UP
        }

        if (rightTop.x() == leftEdge && rightTop.y() == downEdge) {
            return Direction.NONE
        } else if (rightTop.x() == leftEdge) {
            return Direction.RIGHT
        } else if (rightTop.y() == downEdge) {
            return Direction.UP
        }

        return Direction.UP
    }

    override fun toString(): String {
        return "$position - $size"
    }
}