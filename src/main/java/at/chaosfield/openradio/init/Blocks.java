package at.chaosfield.openradio.init;

import com.google.common.base.Preconditions;

import at.chaosfield.openradio.OpenRadio;
//import at.chaosfield.openradio.block.AEEncoderBlock;
import at.chaosfield.openradio.block.LaserBlock;
//import net.minecraftforge.fml.common.Loader;
import at.chaosfield.openradio.block.LensBlock;
import at.chaosfield.openradio.block.MirrorBlock;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

/**
 * Created by Jakob Riepler (XDjackieXD)
 */
@Mod.EventBusSubscriber(modid = OpenRadio.MODID)
public class Blocks {
    public static LaserBlock LASER_BLOCK = new LaserBlock();
    public static LensBlock LENS_BLOCK_1 = new LensBlock(1);
    public static LensBlock LENS_BLOCK_2 = new LensBlock(2);
    public static LensBlock LENS_BLOCK_3 = new LensBlock(3);
    public static MirrorBlock MIRROR_BLOCK = new MirrorBlock();
    //public static AeEncoderBlock AE_ENCODER_BLOCK = new AEEncoderBlock();

    @SubscribeEvent
    public static void registerBlocks(final RegistryEvent.Register<Block> event){
    	final IForgeRegistry<Block> registry = event.getRegistry();
    	
    	final Block[] blocks = {
    			LASER_BLOCK,
    			LENS_BLOCK_1,
    			LENS_BLOCK_2,
    			LENS_BLOCK_3,
    			MIRROR_BLOCK,
    			//AE_ENCODER_BLOCK,
    	};
    	
    	registry.registerAll(blocks);
    }
    
    @SubscribeEvent
    public static void registerItemBlocks(final RegistryEvent.Register<Item> event) {
    	final IForgeRegistry<Item> registry = event.getRegistry();
    	
    	final ItemBlock[] items = {
    			new ItemBlock(LASER_BLOCK),
    			new ItemBlock(LENS_BLOCK_1),
    			new ItemBlock(LENS_BLOCK_2),
    			new ItemBlock(LENS_BLOCK_3),
    			new ItemBlock(MIRROR_BLOCK)
    	};
    	
    	for (final ItemBlock item : items) {
			final Block block = item.getBlock();
			final ResourceLocation registryName = Preconditions.checkNotNull(block.getRegistryName(), "Block %s has null registry name", block);
			registry.register(item.setRegistryName(registryName));
		}
    }
}
