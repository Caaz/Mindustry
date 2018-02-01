package io.anuke.mindustry.world.blocks.types;
import io.anuke.mindustry.entities.TileEntity;
import io.anuke.mindustry.resource.Item;
import io.anuke.mindustry.world.Block;
import io.anuke.mindustry.world.Tile;
import io.anuke.ucore.graphics.Draw;
import static io.anuke.mindustry.Vars.tilesize;

public class AirBlock extends Block {
  private static final float itemSize = 4f;

  public AirBlock(String name) {
    super(name);
  }
  //no drawing here
  public void drawCache(Tile tile){}

  //update floor blocks for effects, if needed
	@Override
  public void draw(Tile tile){
    if(tile.entity == null) return;
    TileEntity entity = tile.entity;
    for(int i = 0; i < entity.items.length; i ++){
      if(entity.items[i] > 0) {
        Draw.rect("icon-" + Item.getByID(i).name,
        tile.x * tilesize,
        tile.y * tilesize, itemSize, itemSize);

      }
    }
  }

  public void handleItem(Item item, Tile tile, Tile source){
    System.out.println("Tried to accept an item into air!");
    tile.entity = new TileEntity();
    tile.entity.init(tile,true);
    tile.entity.addItem(item, 1);
    // if(tile.entity == null) return;
  }
}
