package game.domain.block

import game.domain.sprite.BaseSprite
import game.domain.sprite.Sprite
import game.unit.Position
import game.unit.Size
import game.unit.Velocity

class BaseBlock(
        position: Position = Position(),
        size: Size = Size(),
        velocity: Velocity = Velocity(),
        private val spriteDelegate: Sprite = BaseSprite(size, position, velocity)
) : Block,
        Sprite by spriteDelegate