package net.phoenix492.testmod.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.phoenix492.testmod.TestMod;
import net.phoenix492.testmod.block.ModBlocks;
import net.phoenix492.testmod.item.ModItems;
import net.phoenix492.testmod.util.ModTagKeys;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {
    public ModItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagLookup<Block>> blockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, TestMod.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(ModTagKeys.Items.TRANSFORMABLE_INTO_DIAMOND)
            .add(ModItems.BISMUTH.get())
            .add(ModItems.RAW_BISMUTH.get())
            .add(Items.COAL);
        
        tag(ItemTags.FENCES)
            .add(ModBlocks.BISMUTH_FENCE.asItem());

        tag(ItemTags.WALLS)
            .add(ModBlocks.BISMUTH_WALL.asItem());

        tag(ItemTags.FENCE_GATES)
            .add(ModBlocks.BISMUTH_FENCE_GATE.asItem());

        tag(ItemTags.STAIRS)
            .add(ModBlocks.BISMUTH_STAIRS.asItem());

        tag(ItemTags.SLABS)
            .add(ModBlocks.BISMUTH_SLAB.asItem());

        tag(ItemTags.BUTTONS)
            .add(ModBlocks.BISMUTH_BUTTON.asItem());

        tag(ItemTags.DOORS)
            .add(ModBlocks.BISMUTH_DOOR.asItem());

        tag(ItemTags.TRAPDOORS)
            .add(ModBlocks.BISMUTH_TRAPDOOR.asItem());
    }
}
