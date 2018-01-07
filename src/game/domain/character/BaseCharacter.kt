package game.domain.character

import game.domain.sprite.Sprite
import game.unit.Direction
import game.unit.force.TemporaryMonoForce
import game.unit.value.Value

class BaseCharacter(
        private val spriteDelegate: Sprite
) : Character,
        Sprite by spriteDelegate {

    override fun jump() {
        addForce(TemporaryMonoForce(Value(50.0), Direction.UP))
    }
}