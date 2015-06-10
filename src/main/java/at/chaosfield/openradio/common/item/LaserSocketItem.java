package at.chaosfield.openradio.common.item;

import at.chaosfield.openradio.CreativeTab;
import at.chaosfield.openradio.OpenRadio;
import net.minecraft.item.Item;

/**
 * Created by Jakob Riepler (XDjackieXD)
 */
public class LaserSocketItem extends Item{
    public LaserSocketItem(){
        maxStackSize = 64;
        setUnlocalizedName(OpenRadio.MODID + ":lasersocket");
        setTextureName(OpenRadio.MODID + ":lasersocket");
        setCreativeTab(CreativeTab.instance);
    }
}
