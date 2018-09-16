package at.chaosfield.openradio.gui;

import at.chaosfield.openradio.OpenRadio;
import at.chaosfield.openradio.init.Blocks;
import at.chaosfield.openradio.init.Items;
//import net.minecraftforge.fml.common.Loader;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

/**
 * Created by Jakob Riepler (XDjackieXD)
 */
public class CreativeTab extends CreativeTabs{
    public static CreativeTab instance = new CreativeTab();
    private NonNullList<ItemStack> list;

    public CreativeTab(){
        super(OpenRadio.MODID);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void displayAllRelevantItems(NonNullList<ItemStack> list){
        this.list = list;

        this.addBlock(Blocks.LASER_BLOCK);
        this.addBlock(Blocks.LENS_BLOCK_1);
        this.addBlock(Blocks.LENS_BLOCK_2);
        this.addBlock(Blocks.LENS_BLOCK_3);
        this.addBlock(Blocks.MIRROR_BLOCK);

        //if(Loader.isModLoaded("appliedenergistics2"))
        //    this.addBlock(Blocks.aeencoderBlock);

        this.addItem(Items.LASER_SOCKET_ITEM);
        this.addItem(Items.DSP_ITEM);
        this.addItem(Items.ADC_ITEM);
        this.addItem(Items.LASER_ITEM);
        this.addItem(Items.PHOTO_RECEPTOR_ITEM);
        this.addItem(Items.MIRROR_ITEM);
    }

    @Override
    public ItemStack getTabIconItem(){
        return new ItemStack(Item.getItemFromBlock(Blocks.LASER_BLOCK));
    }

    @Override
    public ItemStack getIconItemStack(){
        return this.getTabIconItem();
    }

    private void addItem(Item item){
        item.getSubItems(this, list);
    }

    private void addBlock(Block block){
        block.getSubBlocks(this, list);
    }
}
