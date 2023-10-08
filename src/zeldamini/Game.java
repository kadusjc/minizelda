package zeldamini;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

public class Game extends Canvas implements Runnable, KeyListener {

	private static final long serialVersionUID = -7967541290357472712L;
	
	public Player player;
	public World world;
	
	public static final int GAME_RESOLUTION_FPS = 60;
	public static final int WIDTH = 640;
	public static final int HEIGHT = 640;
	public static int SCALE = 3;
	
	public Game() {
		this.addKeyListener(this);
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		new Spritesheet();
		world = new World();
		player = new Player(32, 32);
	}
	
	public static void main(String[] args) {
		Game game = new Game();
		prepareFrame(game);
		new Thread(game).start();
		
	}
	
	public void tick() {
		player.tick();
	}
	
	public void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(3); //Otimizacao grafica para jogos em java
			return;
		}
		 		
		Graphics g = bs.getDrawGraphics();
		//Para evitar piscar - Limpar a tela sempre 
		g.setColor(new Color(0, 135, 13));
		g.fillRect(0, 0, WIDTH*SCALE, HEIGHT*SCALE);

		player.render(g);
		world.render(g);
		
		bs.show();
	}

	private static void prepareFrame(Game game) {
		JFrame frame = new JFrame();
		frame.add(game);
		
		frame.setTitle("Zelda Mini");
		frame.setLocationRelativeTo(null);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			tick();
			render();
			try {
				Thread.sleep(1000/GAME_RESOLUTION_FPS);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()) {
			case KeyEvent.VK_RIGHT: {
				player.right = true;
			}
			case KeyEvent.VK_LEFT: {
				player.left = true;
			}
			case KeyEvent.VK_UP: {
				player.up = true;
			}
			case KeyEvent.VK_DOWN: {
				player.down = true;
			}
			case KeyEvent.VK_Z: {
				player.shoot = true;
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		switch(e.getKeyCode()) {
			case KeyEvent.VK_RIGHT: {
				player.right = false;
			}
			case KeyEvent.VK_LEFT: {
				player.left = false;
			}
			case KeyEvent.VK_UP: {
				player.up = false;
			}
			case KeyEvent.VK_DOWN: {
				player.down = false;
			}
			case KeyEvent.VK_Z: {
				player.shoot = false;
			}
		}
		
	}
	

}
