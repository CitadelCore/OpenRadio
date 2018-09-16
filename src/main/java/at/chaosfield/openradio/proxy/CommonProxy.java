package at.chaosfield.openradio.proxy;


import at.chaosfield.openradio.OpenRadio;
import at.chaosfield.openradio.tileentity.LaserTileEntity;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by Jakob Riepler (XDjackieXD)
 */
public class CommonProxy{

    public void init(FMLInitializationEvent event){
        GameRegistry.registerTileEntity(LaserTileEntity.class, new ResourceLocation(OpenRadio.MODID + ":laser"));
        //if(Loader.isModLoaded("appliedenergistics2"))
        //    GameRegistry.registerTileEntity(AEEncoderTileEntity.class, new ResourceLocation(OpenRadio.MODID + ":aeencoder"));
    }
    public void preInit(FMLPreInitializationEvent event){}
	public void registerItemModel(Item item, int meta, String name) {
		// TODO Auto-generated method stub
	}
	
	public void registerItemModel(Block block, int meta, String name) {
		registerItemModel(Item.getItemFromBlock(block), meta, name);
	}

}
