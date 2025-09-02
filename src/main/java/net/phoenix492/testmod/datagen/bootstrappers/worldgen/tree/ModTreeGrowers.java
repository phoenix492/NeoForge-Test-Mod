package net.phoenix492.testmod.datagen.bootstrappers.worldgen.tree;

import net.minecraft.world.level.block.grower.TreeGrower;
import net.phoenix492.testmod.TestMod;
import net.phoenix492.testmod.datagen.bootstrappers.worldgen.ModConfiguredFeatures;

import java.util.Optional;

public class ModTreeGrowers {
    public static final TreeGrower BLOODWOOD = new TreeGrower(TestMod.MODID + ":bloodwood", Optional.empty(), Optional.of(ModConfiguredFeatures.BLOODWOOD_KEY), Optional.empty());
}
