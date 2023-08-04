package com.manvendrask.rain.graphics;

import java.util.Arrays;
import java.util.Random;

public class Screen {
    private int width, height;
    public int[] pixels;
    public int[] tiles = new int[64 * 64];

    private Random random = new Random();

    public Screen(int width, int height) {
        this.width = width;
        this.height = height;

        pixels = new int[width * height];

        for (int i = 0; i < 64 * 64; i++) {
            tiles[i] = random.nextInt(0xffffff);
        }
    }

    public void clear() {
        Arrays.fill(pixels, 0);
    }

    public void render() {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
//                int tileIndex = (x >> 4) + (y >> 4) * 64;
                int tileIndex = (x / 16) + (y / 16) * 64;
                pixels[x + (y * width)] = tiles[tileIndex];
            }
        }
    }
}
