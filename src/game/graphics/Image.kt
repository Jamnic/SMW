package game.graphics

import java.awt.image.BufferedImage
import java.io.File
import javax.imageio.ImageIO

open class Image(
        private val bufferedImage: BufferedImage
) {

    constructor(
            imageFileName: String
    ) : this(File(imageFileName))

    constructor(
            imageFile: File
    ) : this(ImageIO.read(imageFile))

    fun bufferedImage(): BufferedImage {
        return bufferedImage
    }

    fun subimage(xPosition: Int, yPosition: Int, imageSize: ImageSize): Image {
        return Image(bufferedImage.getSubimage(
                imageSize.width * xPosition,
                imageSize.height * yPosition,
                imageSize.width,
                imageSize.height))
    }
}