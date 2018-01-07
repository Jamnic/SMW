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
                imageSize.size.width * xPosition,
                imageSize.size.height * yPosition,
                imageSize.size.width,
                imageSize.size.height))
    }
}