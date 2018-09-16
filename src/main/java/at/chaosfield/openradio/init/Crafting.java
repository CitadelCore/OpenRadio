package at.chaosfield.openradio.init;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

/**
 * Created by Jakob Riepler (XDjackieXD)
 * Register all crafting recipes
 */
public class Crafting{
    public static void init(){

        //**************************************************************************************************************
        //Register Items
    	
    	ResourceLocation optionalGroup = new ResourceLocation("");

        GameRegistry.addShapedRecipe(new ResourceLocation("openradio:lasersocket"), optionalGroup, new ItemStack(Items.LASER_SOCKET_ITEM),       //Laser Socket
                "IDI", "I I", "IDI",
                'I', "ingotIron",
                'D', "gemDiamond");

        GameRegistry.addShapedRecipe(new ResourceLocation("openradio:adc1"), optionalGroup, new ItemStack(Items.ADC_ITEM, 1, 0),          //ADC Tier 1
                "III", "IMI", "ICI",
                'I', "ingotIron",
                'C', new ItemStack(net.minecraft.init.Items.COMPARATOR),
                'M', li.cil.oc.api.Items.get("chip1").createItemStack(1));
        GameRegistry.addShapedRecipe(new ResourceLocation("openradio:adc2"), optionalGroup, new ItemStack(Items.ADC_ITEM, 1, 1),          //ADC Tier 2
                "ICI", "IMI", "ICI",
                'I', "ingotIron",
                'C', new ItemStack(net.minecraft.init.Items.COMPARATOR),
                'M', li.cil.oc.api.Items.get("chip2").createItemStack(2));
        GameRegistry.addShapedRecipe(new ResourceLocation("openradio:adc3"), optionalGroup, new ItemStack(Items.ADC_ITEM, 1, 2),          //ADC Tier 3
                "ICI", "CMC", "ICI",
                'I', "ingotIron",
                'C', new ItemStack(net.minecraft.init.Items.COMPARATOR),
                'M', li.cil.oc.api.Items.get("chip3").createItemStack(1));

        GameRegistry.addShapedRecipe(new ResourceLocation("openradio:dsp1"), optionalGroup, new ItemStack(Items.DSP_ITEM, 1, 0),          //DSP Tier 1
                "IAI", "MCM", "IAI",
                'I', "ingotIron",
                'M', li.cil.oc.api.Items.get("chip1").createItemStack(1),
                'C', li.cil.oc.api.Items.get("cu").createItemStack(1),
                'A', new ItemStack(Items.ADC_ITEM, 1, 0));
        GameRegistry.addShapedRecipe(new ResourceLocation("openradio:dsp2"), optionalGroup, new ItemStack(Items.DSP_ITEM, 1, 1),          //DSP Tier 2
                "IAI", "MCM", "IAI",
                'I', "ingotIron",
                'M', li.cil.oc.api.Items.get("chip2").createItemStack(1),
                'C', li.cil.oc.api.Items.get("cu").createItemStack(1),
                'A', new ItemStack(Items.ADC_ITEM, 1, 1));
        GameRegistry.addShapedRecipe(new ResourceLocation("openradio:dsp3"), optionalGroup, new ItemStack(Items.DSP_ITEM, 1, 2),          //DSP Tier 3
                "IAI", "MCM", "IAI",
                'I', "ingotIron",
                'M', li.cil.oc.api.Items.get("chip3").createItemStack(1),
                'C', li.cil.oc.api.Items.get("cu").createItemStack(1),
                'A', new ItemStack(Items.ADC_ITEM, 1, 2));

        GameRegistry.addShapedRecipe(new ResourceLocation("openradio:photoreceptor"), optionalGroup, new ItemStack(Items.PHOTO_RECEPTOR_ITEM),      //Photo Receptor
                "IDI", "TGT", "IDI",
                'I', "ingotIron",
                'D', "gemDiamond",
                'G', "blockGlass",
                'T', li.cil.oc.api.Items.get("transistor").createItemStack(1));

        GameRegistry.addShapedRecipe(new ResourceLocation("openradio:semimirror"), optionalGroup, new ItemStack(Items.MIRROR_ITEM),             //Semi Reflective Mirror
                " IG", "IGD", "GD ",
                'I', "ingotIron",
                'D', "gemDiamond",
                'G', "blockGlass");

        GameRegistry.addShapedRecipe(new ResourceLocation("openradio:laser1"), optionalGroup, new ItemStack(Items.LASER_ITEM, 1, 0),        //Laser tier 1
                "IGI", "INI", "ITI",
                'I', "ingotIron",
                'G', "blockGlass",
                'N', "nuggetGold",
                'T', li.cil.oc.api.Items.get("transistor").createItemStack(1));

        GameRegistry.addShapedRecipe(new ResourceLocation("openradio:laser2"), optionalGroup, new ItemStack(Items.LASER_ITEM, 1, 1),        //Laser tier 2
                "GDG", "N N", "GDG",
                'D', "gemDiamond",
                'G', "blockGlass",
                'N', "ingotGold");

        GameRegistry.addShapedRecipe(new ResourceLocation("openradio:laser3"), optionalGroup, new ItemStack(Items.LASER_ITEM, 1, 2),        //Laser tier 3
                "IGI", "IEI", "INI",
                'I', "ingotIron",
                'G', "blockGlass",
                'N', "nuggetGold",
                'E', "gemEmerald");

        //**************************************************************************************************************
        //Register Blocks

        GameRegistry.addShapedRecipe(new ResourceLocation("openradio:laserblock"), optionalGroup, new ItemStack(Blocks.LASER_BLOCK),            //Laser Block
                "III", "NSL", "III",
                'I', "ingotIron",
                'N', li.cil.oc.api.Items.get("cable").createItemStack(1),
                'S', li.cil.oc.api.Items.get("relay").createItemStack(1),
                'L', new ItemStack(Items.LASER_SOCKET_ITEM));

        GameRegistry.addShapedRecipe(new ResourceLocation("openradio:glasslens"), optionalGroup, new ItemStack(Blocks.LENS_BLOCK_1),         //Glass Lens
                "IGI", "GGG", "IGI",
                'I', "ingotIron",
                'G', "blockGlass");
        GameRegistry.addShapedRecipe(new ResourceLocation("openradio:quartzlens"), optionalGroup, new ItemStack(Blocks.LENS_BLOCK_2),         //Quartz Infused Lens
                " Q ", "QLQ", " Q ",
                'L', new ItemStack(Blocks.LENS_BLOCK_1),
                'Q', "gemQuartz");
        GameRegistry.addShapedRecipe(new ResourceLocation("openradio:diamondlens"), optionalGroup, new ItemStack(Blocks.LENS_BLOCK_3),         //Shaped Diamond Lens
                "GDG", "DLD", "GDG",
                'L', new ItemStack(Blocks.LENS_BLOCK_2),
                'G', "ingotGold",
                'D', "gemDiamond");

        GameRegistry.addShapedRecipe(new ResourceLocation("openradio:laserblock1"), optionalGroup, new ItemStack(Blocks.MIRROR_BLOCK),            //Laser Block
                "IGI", "GMQ", "IQI",
                'I', "ingotIron",
                'M', new ItemStack(Items.MIRROR_ITEM),
                'G', "blockGlass",
                'Q', new ItemStack(Blocks.LENS_BLOCK_2));

        /*if(Loader.isModLoaded("appliedenergistics2")){
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Blocks.aeencoderBlock),
                    "INI", "CMC", "INI",
                    'I', "ingotIron",
                    'N', li.cil.oc.api.Items.get("cable").createItemStack(1),
                    'M', Item.itemRegistry.getObject("appliedenergistics2:tile.BlockController"),
                    'C', appeng.api.AEApi.instance().definitions().parts().cableSmart().stack(appeng.api.util.AEColor.Transparent, 1)));
        }*/
    }
}
