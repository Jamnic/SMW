package game.domain.block

import game.domain.sprite.BaseSprite
import game.domain.sprite.Sprite
import game.unit.Position
import game.unit.Size

class BaseBlock(
        position: Position = Position(),
        size: Size = Size(),
        private val spriteDelegate: Sprite = BaseSprite(size, position)
) : Block,
        Sprite by spriteDelegate