package game.main

import game.domain.block.BaseBlock
import game.domain.block.Block
import game.domain.block.ImmovableSprite
import game.domain.block.SolidSprite
import game.domain.sprite.BaseSprite
import game.drawable.block.DrawableBlock
import game.graphics.Image
import game.graphics.ImageSize

class BlockFactory(
        private val spriteImage: Image
) {

    fun create(): Block {
        return DrawableBlock(
                spriteImage.subimage(
                        0,
                        6,
                        ImageSize.MEDIUM_16),
                BaseBlock(
                        size = ImageSize.MEDIUM_16.size,
                        spriteDelegate = ImmovableSprite(
                                SolidSprite(
                                        BaseSprite(ImageSize.MEDIUM_16.size)))))
    }
}