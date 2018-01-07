package game.domain.world

import game.domain.sprite.Sprite
import game.time.Tickable

interface World : Tickable {
    fun putSprite(character: Sprite, coordinate: WorldCoordinate)
    fun sprites(): List<Sprite>
}