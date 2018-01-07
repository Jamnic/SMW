package game.graphics

import game.unit.Size

enum class ImageSize(
        val size: Size
) {
    UNKNOWN(Size(1, 1)),
    MEDIUM_16(Size(16, 16)),
    THIN_16(Size(14, 16)),
    MEDIUM_32(Size(32, 32));
}