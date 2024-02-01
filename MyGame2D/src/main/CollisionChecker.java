package main;

import entity.Entity;

public class CollisionChecker {

	GamePanel gp;

	public CollisionChecker(GamePanel gp) {
		this.gp = gp;
	}

	public void checkTile(Entity entity){

		int entityLeft   = entity.getPositionX() + entity.getSolidArea().x;
		int entityRight  = entityLeft + entity.getSolidArea().width;
		int entityTop    = entity.getPositionY() + entity.getSolidArea().y;
		int entityBottom = entityTop + entity.getSolidArea().height;

		int entityLeftCol   = entityLeft/gp.getTileSize();
		int entityRightCol  = entityRight/gp.getTileSize();
		int entityTopRow    = entityTop/gp.getTileSize();
		int entityBottomRow = entityBottom/gp.getTileSize();

		int tileNum1, tileNum2;

		switch (entity.getDirection()){

			case "up":
				/*
				entityTopRow = (entityTop - entity.getSpeed())/gp.getTileSize();

				tileNum1 = gp.getTileManager().getMapTileNumber(entityLeftCol, entityTopRow);
				tileNum2 = gp.getTileManager().getMapTileNumber(entityRightCol, entityTopRow);

				if (gp.getTileManager().getTile(tileNum1).isColisionable() || gp.getTileManager().getTile(tileNum2).isColisionable()){
					entity.turnOnCollision();
				}

				 */
				break;

			case "down":
				break;

			case "left":
				break;

			case "right":
				break;
		}

	}

}