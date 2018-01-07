package game.main

import game.domain.character.Character
import game.drawable.world.DrawableWorld
import game.graphics.GameGraphics
import game.player.Keyboard
import game.player.PlayerCharacter
import java.awt.Dimension
import java.awt.Graphics
import javax.swing.JPanel

class GamePanel(
        player: Character,
        private val world: DrawableWorld,
        private val panelSize: Dimension
) : JPanel() {

    init {
        addKeyListener(Keyboard(player))
    }

    override fun paint(g: Graphics) {
        super.paint(g)
        val gameGraphics = GameGraphics(g)

        world.draw(gameGraphics)
    }

    override fun getPreferredSize(): Dimension {
        return panelSize
    }
}