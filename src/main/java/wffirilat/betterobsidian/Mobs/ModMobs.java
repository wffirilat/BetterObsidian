package wffirilat.betterobsidian.Mobs;

import net.minecraft.entity.EntityList;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;
import wffirilat.betterobsidian.BetterObsidian;
import cpw.mods.fml.common.registry.EntityRegistry;

public class ModMobs {
	public static void init() {
		registerEntities();
		EntityRegistry.addSpawn(Voidling.class, 2, 0, 2, EnumCreatureType.monster, BiomeGenBase.extremeHills, BiomeGenBase.plains, BiomeGenBase.forest, BiomeGenBase.desert, BiomeGenBase.jungle, BiomeGenBase.mesa, BiomeGenBase.swampland, BiomeGenBase.ocean);
	}

	public static void registerEntities() {

		createEntity(Voidling.class, "voidling", 0x000000, 0x000000);
		createEntity(FlameGhast.class, "flameGhast", 0x150a07, 0x4f271a);

	}

	public static void createEntity(Class entityClass, String entityName, int solidColor, int spotColor) {
		int randomID = EntityRegistry.findGlobalUniqueEntityId();
		EntityRegistry.registerGlobalEntityID(entityClass, entityName, randomID);
		EntityRegistry.registerModEntity(entityClass, entityName, randomID, BetterObsidian.modInstance, 64, 1, true);
		//EntityRegistry.addSpawn(entityClass, 2, 0, 2, EnumCreatureType.monster, BiomeGenBase.extremeHills, BiomeGenBase.plains, BiomeGenBase.forest, BiomeGenBase.desert, BiomeGenBase.jungle, BiomeGenBase.mesa, BiomeGenBase.swampland, BiomeGenBase.ocean);

		createEgg(randomID, solidColor, spotColor);

	}

	private static void createEgg(int randomID, int solidColor, int spotColor) {
		EntityList.entityEggs.put(randomID, new EntityList.EntityEggInfo(randomID, solidColor, spotColor));
	}

}
