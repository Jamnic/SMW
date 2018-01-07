package game.player

import game.domain.character.Character
import game.unit.Direction
import game.unit.force.TemporaryMonoForce
import game.unit.Value
import java.awt.event.KeyEvent
import java.awt.event.KeyEvent.*
import java.awt.event.KeyListener

class Keyboard(
        private val character: Character
) : KeyListener {

    override fun keyTyped(e: KeyEvent) {
        when (e.keyCode) {
            VK_SPACE -> character.jump()
            else -> {
            }
        }
    }

    override fun keyPressed(e: KeyEvent) {
        when (e.keyCode) {
            VK_SPACE -> character.jump()
            VK_D -> character.addForce(TemporaryMonoForce(Value.of(2.0), Direction.RIGHT))
            VK_A -> character.addForce(TemporaryMonoForce(Value.of(2.0), Direction.LEFT))
            else -> {
            }
        }
    }

    override fun keyReleased(e: KeyEvent?) {
    }
}