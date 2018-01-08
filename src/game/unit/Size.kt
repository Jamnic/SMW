package game.unit

data class Size(
        val width: Int = 0,
        val height: Int = 0
) {

    override fun toString(): String {
        return "[$width $height]"
    }
}