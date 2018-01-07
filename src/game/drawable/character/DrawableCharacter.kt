package game.drawable.character

import game.domain.character.Character
import game.drawable.Drawable
import game.drawable.ImageSprite
import game.graphics.Image

class DrawableCharacter(
        image: Image,
        private val characterDelegate: Character,
        private val drawableDelegate: Drawable = ImageSprite(image, characterDelegate.position())
) : Character by characterDelegate,
        Drawable by drawableDelegate