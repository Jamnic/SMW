package game.graphics

import game.unit.Size

enum class ImageSize(
        val width: Int,
        val height: Int
) {

    UNKNOWN(1, 1),
    MEDIUM_16(16, 16),
    THIN_16(14, 16),
    MEDIUM_32(32, 32);

    fun size(): Size {
        return Size(width, height)
    }
}