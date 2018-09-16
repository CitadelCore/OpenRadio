package at.chaosfield.openradio.proxy;

import at.chaosfield.openradio.OpenRadio;
import at.chaosfield.openradio.init.Blocks;
import at.chaosfield.openradio.init.Items;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * Created by Jakob Riepler (XDjackieXD)
 */
public class ClientProxy extends CommonProxy{

    @Override
    public void preInit(FMLPreInitializationEvent event){
        ModelBakery.registerItemVariants(Items.DSP_ITEM, new ResourceLocation(OpenRadio.MODID, "dspt1"), new ResourceLocation(OpenRadio.MODID, "dspt2"), new ResourceLocation(OpenRadio.MODID, "dspt3"));
        ModelBakery.registerItemVariants(Items.ADC_ITEM, new ResourceLocation(OpenRadio.MODID, "adct1"), new ResourceLocation(OpenRadio.MODID, "adct2"), new ResourceLocation(OpenRadio.MODID, "adct3"));
        ModelBakery.registerItemVariants(Items.LASER_ITEM, new ResourceLocation(OpenRadio.MODID, "lasert1"), new ResourceLocation(OpenRadio.MODID, "lasert2"), new ResourceLocation(OpenRadio.MODID, "lasert3"));
    }

    @Override
    public void init(FMLInitializationEvent event){
        super.init(event);

        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(Blocks.LASER_BLOCK), 0, new ModelResourceLocation("openradio:laser", "inventory"));
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(Blocks.LENS_BLOCK_1), 0, new ModelResourceLocation("openradio:lenst1", "inventory"));
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(Blocks.LENS_BLOCK_2), 0, new ModelResourceLocation("openradio:lenst2", "inventory"));
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(Blocks.LENS_BLOCK_3), 0, new ModelResourceLocation("openradio:lenst3", "inventory"));
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(Blocks.MIRROR_BLOCK), 0, new ModelResourceLocation("openradio:blockmirror", "inventory"));

        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Items.DSP_ITEM, 0, new ModelResourceLocation("openradio:dspt1", "inventory"));
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Items.DSP_ITEM, 1, new ModelResourceLocation("openradio:dspt2", "inventory"));
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Items.DSP_ITEM, 2, new ModelResourceLocation("openradio:dspt3", "inventory"));
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Items.ADC_ITEM, 0, new ModelResourceLocation("openradio:adct1", "inventory"));
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Items.ADC_ITEM, 1, new ModelResourceLocation("openradio:adct2", "inventory"));
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Items.ADC_ITEM, 2, new ModelResourceLocation("openradio:adct3", "inventory"));
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Items.LASER_ITEM, 0, new ModelResourceLocation("openradio:lasert1", "inventory"));
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Items.LASER_ITEM, 1, new ModelResourceLocation("openradio:lasert2", "inventory"));
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Items.LASER_ITEM, 2, new ModelResourceLocation("openradio:lasert3", "inventory"));
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Items.MIRROR_ITEM, 0, new ModelResourceLocation("openradio:mirror", "inventory"));
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Items.LASER_SOCKET_ITEM, 0, new ModelResourceLocation("openradio:lasersocket", "inventory"));
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Items.PHOTO_RECEPTOR_ITEM, 0, new ModelResourceLocation("openradio:photoreceptor", "inventory"));
    }

}
