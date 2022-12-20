package com.mygdx.tanks;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Tank {
    private MyTanksGame game;
    private Texture texture;
    private float x;
    private float y;
    private float speed;
    private float angle;

    public Tank(MyTanksGame game) {
        this.game = game;
        this.texture = new Texture("player_tank_base.png");
        this.x = 100.0f;
        this.y = 100.0f;
        this.speed = 100.0f;
    }

    public void render(SpriteBatch batch) {
        batch.draw(texture, x - 20, y - 20, 20, 20, 40, 40, 1,
                1, angle, 0, 0, 40, 40, false, false );
    }

    public void update(float dt) {
        checkMovement(dt);
        if(Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
            fire();
        }
    }

    public void checkMovement(float dt) {
        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            x -= speed * dt;
            angle = 180.0f;
        } else if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            x += speed * dt;
            angle = 0.0f;
        } else if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            y += speed * dt;
            angle = 90.0f;
        } else if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            y -= speed * dt;
            angle = 270.0f;
        }
    }

    public void fire() {
        if(!game.getBullet().isActive()) {
            float angleRad = (float)Math.toRadians(angle);
            game.getBullet().activate(x, y, 320.0f * (float) Math.cos(angleRad), 320.0f * (float) Math.sin(angleRad));
        }

    }
}
