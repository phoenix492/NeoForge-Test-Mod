package net.phoenix492.trim;

import net.minecraft.Util;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.network.chat.TextColor;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.armortrim.TrimMaterial;
import net.phoenix492.testmod.TestMod;
import net.phoenix492.testmod.item.ModItems;

import java.util.Map;

public class ModTrimMaterials {
    public static final ResourceKey<TrimMaterial> BISMUTH =
        ResourceKey.create(Registries.TRIM_MATERIAL, ResourceLocation.fromNamespaceAndPath(TestMod.MODID, "bismuth"));

    public static void bootstrap(BootstrapContext<TrimMaterial> context) {
        register(context, BISMUTH, ModItems.BISMUTH.get(), Style.EMPTY.withColor(TextColor.parseColor("#031cfc").getOrThrow()), 0.5f);
    }

    private static void register(BootstrapContext<TrimMaterial> context, ResourceKey<TrimMaterial> trimKey, Item item, Style style, float itemModelIndex) {
        TrimMaterial trimMaterial = TrimMaterial.create(trimKey.location().getPath(), item, itemModelIndex, Component.translatable(Util.makeDescriptionId("trim_material", trimKey.location())).withStyle(style), Map.of());
        context.register(trimKey, trimMaterial);
    }
}
