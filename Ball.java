import java.awt.Color;
import java.awt.Graphics;

public class Ball {
    
    public static final int SIZE = 16;

    private int x, y;
    private int xVelocity, yVelocity; // Value either 1 or -1
    private int speed = 5;

    public Ball () {

        reset();

    }

    private void reset() {
        // inital Position

        x = Game.WIDTH/2 - SIZE/2;
        y = Game.HEIGHT/2 - SIZE/2;

        // Inital velocity
        xVelocity = Game.sign(Math.random() * 2.0 -1);
        yVelocity = Game.sign(Math.random() * 2.0 -1);
    }

    public void changeXDir() {
        xVelocity *= -1;
    }

    public void changeYDir() {
        yVelocity *= -1;
    }

	public void draw(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(x, y, SIZE, SIZE);
	}

	public void update(Paddle p1, Paddle p2) {
        // Update movement
        x += xVelocity * speed;
        y += yVelocity * speed;

        // collisions
        if (y + SIZE >= Game.HEIGHT || y <= 0 ) {
            changeYDir();
        }

        if(x + SIZE >= Game.WIDTH) {
            p1.addPoint();
            reset();
        }

        if(x <= 0 ) {
            p2.addPoint();
            reset();
        }

	}

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }

}