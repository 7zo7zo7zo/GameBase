import java.awt.*;

public class Entity {

    protected double x;
    protected double y;

    protected int width;
    protected int height;

    protected double angle;

    protected int speed;

    protected int offset;

    protected Rectangle hitbox;

    public Entity(Game game, double x, double y, int width, int height, int offset) {
        super(game);
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.offset = offset;

        hitbox = new Rectangle((int) x + offset, (int) y + offset, width - 2 * offset, height - 2 * offset);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getCenterX() {
        return x + width / 2;
    }

    public double getCenterY() {
        return y + height / 2;
    }

    public boolean collides(Entity e) {
        if (hitbox.intersects(e.hitbox)) {
            return true;
        }
        return false;
    }

    public void setAngle(double xTarget, double yTarget) {
        angle = Math.atan2(yTarget - getCenterY(), xTarget - getCenterX());
    }

    public void linearMove() {
        x += speed * Math.cos(angle);
        y += speed * Math.sin(angle);
    }

    public void tick() {
        hitbox.setLocation((int) x + offset, (int) y + offset);
    }

    public void render(Graphics2D g2) {
        // g2.setColor(Color.YELLOW);
        // g2.fillRect(hitbox.x, hitbox.y, hitbox.width, hitbox.height);
    }
}
