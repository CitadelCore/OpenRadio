package at.chaosfield.openradio.init;

import at.chaosfield.openradio.item.*;
import at.chaosfield.openradio.OpenRadio;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

/**
 * Created by Jakob Riepler (XDjackieXD)
 */
@Mod.EventBusSubscriber(modid = OpenRadio.MODID)
public class Items{
    public static LaserSocketItem LASER_SOCKET_ITEM = new LaserSocketItem();
    public static DSPItem DSP_ITEM = new DSPItem();
    public static ADCItem ADC_ITEM = new ADCItem();
    public static PhotoReceptorItem PHOTO_RECEPTOR_ITEM = new PhotoReceptorItem();
    public static MirrorItem MIRROR_ITEM = new MirrorItem();
    public static LaserItem LASER_ITEM = new LaserItem();

    //Register all items (Has to be called during FML Init)
    @SubscribeEvent
	public static void registerItems(final RegistryEvent.Register<Item> event) {
    	final IForgeRegistry<Item> registry = event.getRegistry();
    	final Item[] items = {
    			LASER_SOCKET_ITEM,
    			DSP_ITEM,
    			PHOTO_RECEPTOR_ITEM,
    			MIRROR_ITEM,
    			LASER_ITEM,
    	};
    	
    	registry.registerAll(items);
    }
}