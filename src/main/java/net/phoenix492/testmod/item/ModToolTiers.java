package net.phoenix492.testmod.item;

import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;
import net.phoenix492.testmod.util.ModTagKeys;

public class ModToolTiers {
    public static final Tier BISMUTH = new SimpleTier(ModTagKeys.Blocks.INCORRECT_FOR_BISMUTH_TOOL, 1400, 4f, 3f, 28, () -> Ingredient.of(ModItems.BISMUTH));

}
