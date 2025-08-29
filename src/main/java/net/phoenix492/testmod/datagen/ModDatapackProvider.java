package net.phoenix492.testmod.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import net.phoenix492.testmod.TestMod;
import net.phoenix492.trim.ModTrimMaterials;
import net.phoenix492.trim.ModTrimPatterns;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class ModDatapackProvider extends DatapackBuiltinEntriesProvider {
    private static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
        .add(Registries.TRIM_MATERIAL, ModTrimMaterials::bootstrap)
        .add(Registries.TRIM_PATTERN, ModTrimPatterns::bootstrap);

    public ModDatapackProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(TestMod.MODID));
    }
}
