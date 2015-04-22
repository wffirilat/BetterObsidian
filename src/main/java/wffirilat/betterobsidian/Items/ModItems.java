package wffirilat.betterobsidian.Items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

public final class ModItems {

	public static Item obsidianIngot;
	public static Item rainbowShard;
	public static Item rainbowFossil;
	public static Item voidOrb;
	public static Item bedrockShard;
	// public static Item sunShard;
	// public static Item TEST;
	// public static Item portableWorkbench;
	// public static Item teleporter;
	// public static Item falseEmerald;
	// public static Item fireSpell;
	// public static Item healSpell;
	// public static Item magic;
	// public static Item bigMagic;
	// public static Item hugeMagic;

	public static Item obsidianPick;
	public static Item obsidianAxe;
	public static Item obsidianShovel;
	public static Item obsidianSword;
	public static Item bedrockPick;
	public static Item bedrockAxe;
	public static Item bedrockShovel;
	public static Item bedrockSword;
	public static Item sharpBedrockPick;
	public static Item sharpBedrockAxe;
	public static Item sharpBedrockShovel;
	public static Item sharpBedrockSword;
	public static Item voidPick;
	public static Item voidAxe;
	public static Item voidShovel;
	public static Item rainbowPick;
	public static Item rainbowAxe;
	public static Item rainbowShovel;
	public static Item rainbowSword;

	public static Item obsidianHelmet;
	public static Item obsidianChestplate;
	public static Item obsidianLeggings;
	public static Item obsidianBoots;
	public static Item bedrockHelmet;
	public static Item bedrockChestplate;
	public static Item bedrockLeggings;
	public static Item bedrockBoots;

	// public static Item opuntiaSeed;
	// public static Item beefSandwich;

	public static Item.ToolMaterial ObsidianTool = EnumHelper.addToolMaterial("Obsidian", 4, 8192, 20.0f, 6, 50);

	public static ArmorMaterial ObsidianArmor = EnumHelper.addArmorMaterial("ObsidianArmor", 50, new int[] { 5, 8, 7, 5 }, 50);
	public static Item.ToolMaterial BedrockTool = EnumHelper.addToolMaterial("bedrock", 4, -1, 30, 10, 0);
	public static Item.ToolMaterial SharpBedrockTool = EnumHelper.addToolMaterial("bedrock", 4, -1, 50, 13, 0);
	public static ArmorMaterial BedrockArmor = EnumHelper.addArmorMaterial("BedrockArmor", 500000, new int[] { 6, 9, 8, 6 }, 0);
	public static Item.ToolMaterial VoidTool = EnumHelper.addToolMaterial("Void", 4, -1, 50, 10, 0);
	public static Item.ToolMaterial RainbowTool = EnumHelper.addToolMaterial("Rainbow", 4, 1024, 10.0f, 6, 100);
	public static Item snowMachine;
	public static Item flameGhastTear;
	public static Item mithril;
	public static Item rawMithril;

	// public static Item rope;

	public static void init() {

		obsidianIngot = new ObsidianIngot();
		rainbowShard = new RainbowShard();
		rainbowFossil = new RainbowFossil();
		voidOrb = new VoidOrb();
		bedrockShard = new BedrockShard();
		rawMithril = new ModItem("rawMithril");
		mithril = new ModItem("mithril");
		flameGhastTear = new ModItem("flameGhastTear");
		ObsidianTool.customCraftingMaterial = ModItems.obsidianIngot;
		ObsidianArmor.customCraftingMaterial = ModItems.obsidianIngot;
		// sunShard = new SunShard();
		// falseEmerald = new FalseEmerald();
		// fireSpell = new SpellFire();
		// healSpell = new SpellHeal();
		// magic = new MagicItem();
		// bigMagic = new BigMagicItem();
		// hugeMagic = new HugeMagicItem();
		// rope = new ModItem("rope");

		obsidianPick = new ToolModPick(ObsidianTool, "obsidianPick");
		obsidianAxe = new ToolModAxe(ObsidianTool, "obsidianAxe");
		obsidianShovel = new ToolModShovel(ObsidianTool, "obsidianShovel");
		obsidianSword = new ToolModSword(ObsidianTool, "obsidianSword");
		bedrockPick = new ToolModPick(BedrockTool, "bedrockPick");
		bedrockAxe = new ToolModAxe(BedrockTool, "bedrockAxe");
		bedrockShovel = new ToolModShovel(BedrockTool, "bedrockShovel");
		bedrockSword = new ToolModSword(BedrockTool, "bedrockSword");
		sharpBedrockPick = new ToolModPick(SharpBedrockTool, "sharpBedrockPick");
		sharpBedrockAxe = new ToolModAxe(SharpBedrockTool, "sharpBedrockAxe");
		sharpBedrockShovel = new ToolModShovel(SharpBedrockTool, "sharpBedrockShovel");
		sharpBedrockSword = new ToolModSword(SharpBedrockTool, "sharpBedrockSword");
		rainbowPick = new ToolModPick(RainbowTool, "rainbowPick");
		rainbowAxe = new ToolModAxe(RainbowTool, "rainbowAxe");
		rainbowShovel = new ToolModShovel(RainbowTool, "rainbowShovel");
		rainbowSword = new ToolModSword(RainbowTool, "rainbowSword");
		voidPick = new ToolVoidPick(VoidTool);
		voidAxe = new ToolVoidAxe(VoidTool);
		voidShovel = new ToolVoidShovel(VoidTool);
		

		snowMachine = new SnowMachine();

		obsidianHelmet = new ArmorObsidian(ObsidianArmor, 0, "obsidianHelmet");
		obsidianChestplate = new ArmorObsidian(ObsidianArmor, 1, "obsidianChestplate");
		obsidianLeggings = new ArmorObsidian(ObsidianArmor, 2, "obsidianLeggings");
		obsidianBoots = new ArmorObsidian(ObsidianArmor, 3, "obsidianBoots");
		bedrockHelmet = new ArmorBedrock(BedrockArmor, 0, "bedrockHelmet");
		bedrockChestplate = new ArmorBedrock(BedrockArmor, 1, "bedrockChestplate");
		bedrockLeggings = new ArmorBedrock(BedrockArmor, 2, "bedrockLeggings");
		bedrockBoots = new ArmorBedrock(BedrockArmor, 3, "bedrockBoots");

		// opuntiaSeed = new OpuntiaSeed(4, 1, false);
		// beefSandwich = new BeefSandwich(14, 1.6f, false);

		// TEST = new TESTITEM();
		// portableWorkbench = new PortableCraftingTable();
		// teleporter = new Teleporter();

	}
}
