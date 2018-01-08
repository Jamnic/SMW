package game.drawable.block

import game.domain.block.Block
import game.drawable.Drawable
import game.drawable.ImageSprite
import game.graphics.Image

class DrawableBlock(
        image: Image,
        private val blockDelegate: Block,
        private val drawableDelegate: Drawable = ImageSprite(image, blockDelegate.rect())
) : Block by blockDelegate,
        Drawable by drawableDelegate