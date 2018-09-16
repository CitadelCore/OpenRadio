package at.chaosfield.openradio.init;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;

import at.chaosfield.openradio.OpenRadio;
//import at.chaosfield.openradio.block.AEEncoderBlock;
import at.chaosfield.openradio.block.LaserBlock;
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
    public static LaserBlock laserBlock = null;
    public static LensBlock lensBlock1 = null;
    public static LensBlock lensBlock2 = null;
    public static LensBlock lensBlock3 = null;
    public static MirrorBlock mirrorBlock = null;
    //public static AeEncoderBlock aeencoderBlock = null;
    
    public static void preInitBlocks() {
    	laserBlock = new LaserBlock();
    	lensBlock1 = new LensBlock(1);
    	lensBlock2 = new LensBlock(2);
    	lensBlock3 = new LensBlock(3);
    	mirrorBlock = new MirrorBlock();
    	//aeencoderBlock = new AEEncoderBlock();
    }
    
    @SubscribeEvent
    public static void registerBlocks(final RegistryEvent.Register<Block> event){
    	final IForgeRegistry<Block> registry = event.getRegistry();
    	
    	ImmutableList.of(
    			laserBlock,
    			lensBlock1,
    			lensBlock2,
    			lensBlock3,
    			mirrorBlock
    			//aeencoderBlock
    			).forEach(block -> registry.register(block));
    }
    
    @SubscribeEvent
    public static void registerItemBlocks(final RegistryEvent.Register<Item> event) {
    	final IForgeRegistry<Item> registry = event.getRegistry();
    	
    	final ItemBlock[] items = {
    			new ItemBlock(laserBlock),
    			new ItemBlock(lensBlock1),
    			new ItemBlock(lensBlock2),
    			new ItemBlock(lensBlock3),
    			new ItemBlock(mirrorBlock)
    	};
    	
    	for (final ItemBlock item : items) {
			final Block block = item.getBlock();
			final ResourceLocation registryName = Preconditions.checkNotNull(block.getRegistryName(), "Block %s has null registry name", block);
			registry.register(item.setRegistryName(registryName));
		}
    }
}
