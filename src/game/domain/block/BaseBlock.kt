package game.domain.block

import game.domain.sprite.BaseSprite
import game.domain.sprite.Sprite
import game.unit.Size

class BaseBlock(
        size: Size = Size(),
        private val spriteDelegate: Sprite = BaseSprite(size)
) : Block,
        Sprite by spriteDelegate