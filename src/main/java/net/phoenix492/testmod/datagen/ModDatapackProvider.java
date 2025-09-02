package net.phoenix492.testmod.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.phoenix492.testmod.TestMod;
import net.phoenix492.testmod.datagen.bootstrappers.worldgen.ModBiomeModifiers;
import net.phoenix492.testmod.datagen.bootstrappers.worldgen.ModConfiguredFeatures;
import net.phoenix492.testmod.datagen.bootstrappers.ModEnchantments;
import net.phoenix492.testmod.datagen.bootstrappers.worldgen.ModPlacedFeatures;
import net.phoenix492.testmod.datagen.trim.ModTrimMaterials;
import net.phoenix492.testmod.datagen.trim.ModTrimPatterns;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class ModDatapackProvider extends DatapackBuiltinEntriesProvider {

    private static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
        .add(Registries.TRIM_MATERIAL, ModTrimMaterials::bootstrap)
        .add(Registries.TRIM_PATTERN, ModTrimPatterns::bootstrap)
        .add(Registries.ENCHANTMENT, ModEnchantments::bootstrap)
        .add(Registries.CONFIGURED_FEATURE, ModConfiguredFeatures::bootstrap)
        .add(Registries.PLACED_FEATURE, ModPlacedFeatures::bootstrap)
        .add(NeoForgeRegistries.Keys.BIOME_MODIFIERS, ModBiomeModifiers::bootstrap);

    public ModDatapackProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(TestMod.MODID));
    }
}
