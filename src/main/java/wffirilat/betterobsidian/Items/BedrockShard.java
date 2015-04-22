package wffirilat.betterobsidian.Items;

import wffirilat.betterobsidian.lib.Constants;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class BedrockShard extends Item {
	
    private String name = "bedrockShard";
    
    public BedrockShard() {
        
        setUnlocalizedName(Constants.MODID + "_" + name);
        setTextureName(Constants.MODID + ":" + name);
        GameRegistry.registerItem(this, name);
        setCreativeTab(CreativeTabs.tabMaterials);
    }
}
