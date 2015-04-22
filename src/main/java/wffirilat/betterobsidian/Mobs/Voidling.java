package wffirilat.betterobsidian.Mobs;

import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIFleeSun;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import wffirilat.betterobsidian.Items.ModItems;

public class Voidling extends EntityMob {

	public Voidling(World world) {
		super(world);
		this.experienceValue = 75;

		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(2, new EntityAIAttackOnCollide(this, 1.0D, false));
		this.tasks.addTask(4, new EntityAIWander(this, 0.8D));
		this.tasks.addTask(5, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(6, new EntityAILookIdle(this));
		this.tasks.addTask(3, new EntityAIFleeSun(this, 1.0D));
		this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
		this.targetTasks.addTask(2, new EntityAIHurtByTarget(this, false));
		this.stepHeight = 2;
	}

	protected void applyEntitityAttributes() {
		super.applyEntityAttributes();

		getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(100.0D);
		getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(1.0D);
		getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(1);

		getAttributeMap().registerAttribute(SharedMonsterAttributes.attackDamage);
		getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(100.0D);
		getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(100.0D);
	}

	public boolean isAIEnabled() {
		return true;
	}

	protected Item getDropItem() {
		return ModItems.voidOrb;
	}

	public boolean getCanSpawnHere() {
		return super.getCanSpawnHere() && this.posY <= 11;
	}

	public boolean attackEntityAsMob(Entity e) {
		int d = this.worldObj.difficultySetting.getDifficultyId();
		e.attackEntityFrom(DamageSource.magic, d * 5);
		return super.attackEntityAsMob(e);
	}

}
