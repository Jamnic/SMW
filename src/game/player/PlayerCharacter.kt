package game.player

import game.domain.character.Character
import game.drawable.Drawable
import game.drawable.character.DrawableCharacter

class PlayerCharacter(
        private val characterDelegate: DrawableCharacter
) : Character by characterDelegate,
        Drawable by characterDelegate