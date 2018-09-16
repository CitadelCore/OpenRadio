package at.chaosfield.openradio;

import at.chaosfield.openradio.init.Blocks;
import at.chaosfield.openradio.init.Crafting;
import at.chaosfield.openradio.init.Entities;
import at.chaosfield.openradio.init.Items;
import at.chaosfield.openradio.gui.GuiHandler;
import at.chaosfield.openradio.integration.Init;
import at.chaosfield.openradio.proxy.CommonProxy;
import at.chaosfield.openradio.util.Settings;
import net.minecraftforge.fml.common.*;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 * Created by Jakob Riepler (XDjackieXD)
 */

@Mod(name = "Open Radio", modid = OpenRadio.MODID, version = "0.9.6", modLanguage = "java", dependencies = "required-after:opencomputers@[1.7,)")
public class OpenRadio{

    public static final String MODID = "openradio";

    @Mod.Instance(MODID)
    public static OpenRadio instance;

    //Get the logger
    public static Logger logger = LogManager.getLogger(OpenRadio.MODID);

    //Get the right proxy (Client = ClientProxy, Server = CommonProxy)
    @SidedProxy(clientSide = "at.chaosfield.openradio.proxy.ClientProxy", serverSide = "at.chaosfield.openradio.proxy.CommonProxy")
    public static CommonProxy proxy;

    public Settings settings;

    //FML PreInit
    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event){
        settings = new Settings(event.getSuggestedConfigurationFile());

        for(ModContainer modAPI: ModAPIManager.INSTANCE.getAPIList()){
            if(modAPI.getModId().equals("actuallyadditionsapi") && Loader.isModLoaded("actuallyadditions")){
                Init.loadedActAddVersion = Integer.parseInt(modAPI.getVersion());
            }
        }
        
        proxy.preInit(event);           //Register Variants
        Init.preInitIntegration(event);
        
        Items.preInitItems();
        Blocks.preInitBlocks();
        
        // Tiered items
        proxy.registerItemModel(Items.dspItem, 0, "openradio:dspt1");
        proxy.registerItemModel(Items.dspItem, 1, "openradio:dspt2");
        proxy.registerItemModel(Items.dspItem, 2, "openradio:dspt3");
        
        proxy.registerItemModel(Items.adcItem, 0, "openradio:adct1");
        proxy.registerItemModel(Items.adcItem, 1, "openradio:adct2");
        proxy.registerItemModel(Items.adcItem, 2, "openradio:adct3");
        
        proxy.registerItemModel(Items.laserItem, 0, "openradio:lasert1");
        proxy.registerItemModel(Items.laserItem, 1, "openradio:lasert2");
        proxy.registerItemModel(Items.laserItem, 2, "openradio:lasert3");
        
        // Misc items
        proxy.registerItemModel(Items.mirrorItem, 0, "openradio:mirror");
        proxy.registerItemModel(Items.laserSocketItem, 0, "openradio:lasersocket");
        proxy.registerItemModel(Items.photoReceptorItem, 0, "openradio:photoreceptor");
        
        // Blocks
        proxy.registerItemModel(Blocks.laserBlock, 0, "openradio:laser");
        proxy.registerItemModel(Blocks.lensBlock1, 0, "openradio:lenst1");
        proxy.registerItemModel(Blocks.lensBlock2, 0, "openradio:lenst2");
        proxy.registerItemModel(Blocks.lensBlock3, 0, "openradio:lenst3");
        proxy.registerItemModel(Blocks.mirrorBlock, 0, "openradio:blockmirror");
        
        logger.info(MODID + " pre init complete.");
    }

    //FML Init
    @Mod.EventHandler
    public void init(FMLInitializationEvent event){
        GuiHandler.init();              //Register the GUIs
        Entities.init();                //Register the Entities
        Crafting.init();                //Register the crafting recipes
        proxy.init(event);              //Register TileEntities, Renders and other things

        Init.initIntegration(event);

        logger.info(MODID + " init complete.");
    }

    //FML Init
    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event){
        Init.postInitIntegration(event);
        logger.info(MODID + " post init complete.");
    }
}