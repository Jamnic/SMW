package game.main

import game.domain.world.BaseWorld
import game.domain.world.WorldCoordinate
import game.drawable.world.DrawableWorld
import game.graphics.Image
import game.time.Timer
import game.unit.Direction
import game.unit.force.MonoForce
import game.unit.Value
import java.awt.Dimension
import javax.swing.JFrame

class GameWindow : JFrame() {

    init {
        defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        val dimension = Dimension(800, 600)
        size = dimension

        val world = DrawableWorld(
                Image("res/graphics/background.png"),
                BaseWorld())

        val spriteImages = Image("res/graphics/sprite.png")
        val charactersImages = Image("res/graphics/characters.png")

        val characterFactory = CharacterFactory(charactersImages)
        val blockFactory = BlockFactory(spriteImages)

        val character = characterFactory.createPlayer()
        world.putSprite(character, WorldCoordinate(5, 1))

        world.putSprite(blockFactory.create(), WorldCoordinate(6, 9))
        world.putSprite(blockFactory.create(), WorldCoordinate(7, 9))
        world.putSprite(blockFactory.create(), WorldCoordinate(9, 11))

        for (i in 1..48) {
            world.putSprite(blockFactory.create(), WorldCoordinate(i, 10))
        }

        character.addForce(MonoForce(Value.of(1.0), Direction.DOWN))

        val panel = GamePanel(character, world, dimension)
        add(panel)
        pack()
        isVisible = true

        panel.requestFocusInWindow()

        Thread(Timer(panel, world)).start()
    }
}