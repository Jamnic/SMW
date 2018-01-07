package game.domain.character

import game.domain.sprite.Sprite

interface Character : Sprite {
    fun jump()
}