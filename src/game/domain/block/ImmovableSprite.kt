package game.domain.block

import game.domain.sprite.Sprite

class ImmovableSprite(
        private val spriteDelegate: Sprite
) : Sprite by spriteDelegate {

}