package at.chaosfield.openradio.init;

import at.chaosfield.openradio.item.*;

import com.google.common.collect.ImmutableList;

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
    public static LaserSocketItem laserSocketItem;
    public static DSPItem dspItem;
    public static ADCItem adcItem;
    public static PhotoReceptorItem photoReceptorItem;
    public static MirrorItem mirrorItem;
    public static LaserItem laserItem;
    
    public static void preInitItems() {
    	laserSocketItem = new LaserSocketItem();
    	dspItem = new DSPItem();
    	adcItem = new ADCItem();
    	photoReceptorItem = new PhotoReceptorItem();
    	mirrorItem = new MirrorItem();
    	laserItem = new LaserItem();
    }

    //Register all items (Has to be called during FML Init)
    @SubscribeEvent
	public static void registerItems(final RegistryEvent.Register<Item> event) {
    	final IForgeRegistry<Item> registry = event.getRegistry();
    	
    	ImmutableList.of(
    			laserSocketItem,
    			dspItem,
    			adcItem,
    			photoReceptorItem,
    			mirrorItem,
    			laserItem
    			).forEach(item -> registry.register(item));
    }
}