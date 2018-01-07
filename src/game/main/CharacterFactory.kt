package game.main

import game.domain.block.SolidSprite
import game.domain.character.BaseCharacter
import game.domain.character.Character
import game.domain.sprite.BaseSprite
import game.drawable.character.DrawableCharacter
import game.graphics.Image
import game.graphics.ImageSize
import game.player.PlayerCharacter

class CharacterFactory(
        private val charactersImages: Image
) {

    fun createPlayer(): Character {
        return PlayerCharacter(createDrawable())
    }

    private fun createDrawable(): DrawableCharacter {
        return DrawableCharacter(charactersImages.subimage(
                0,
                0,
                ImageSize.THIN_16), createCharacter())
    }

    private fun createCharacter(): Character {
        return BaseCharacter(
                SolidSprite(
                        BaseSprite(ImageSize.THIN_16.size)))
    }
}