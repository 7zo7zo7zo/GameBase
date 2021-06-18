package game;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class AnimatedImageEntity extends ImageEntity {

    protected SpriteSheet sheet;

    protected int currentFrame = 0;

    protected ArrayList<BufferedImage> frames;

    public AnimatedImageEntity(Game game, float x, float y, int width, int height, int offset, String path,
                               int totalFrames) {
        super(game, x, y, width, height, offset, path);

        sheet = new SpriteSheet(image);

        frames = new ArrayList<BufferedImage>();

        for (int i = 0; i < totalFrames; i++) {
            frames.add(sheet.crop(width * i, 0, width, height));
        }
    }

    public void render(Graphics2D g2) {
        image = frames.get(currentFrame);
        super.render(g2);
    }

    public void cycle() {
        if (currentFrame + 1 >= frames.size()) {
            currentFrame = 0;
        } else {
            currentFrame++;
        }
    }
}
