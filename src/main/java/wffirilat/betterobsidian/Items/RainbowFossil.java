package wffirilat.betterobsidian.Items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityLargeFireball;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import wffirilat.betterobsidian.Mobs.Voidling;
import wffirilat.betterobsidian.lib.Constants;
import cpw.mods.fml.common.registry.GameRegistry;

public class RainbowFossil extends Item {
	
    private String name = "rainbowFossil";
    
    public RainbowFossil() {
        
        setUnlocalizedName(Constants.MODID + "_" + name);
        setTextureName(Constants.MODID + ":" + name);
        GameRegistry.registerItem(this, name);
        setCreativeTab(CreativeTabs.tabMaterials);
    }
    
    @Override
    public ItemStack onItemRightClick(ItemStack i , World w, EntityPlayer p){
    	EntityLargeFireball f = new EntityLargeFireball(w, p, 0, 0, 0);
    	w.spawnEntityInWorld(f);
    	f.motionX = f.motionY = f.motionZ = 0.0D;
    	i.stackSize -= 1;
    	return i;
    }
}
