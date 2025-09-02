package net.phoenix492.testmod.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.phoenix492.testmod.TestMod;
import net.phoenix492.testmod.block.ModBlocks;
import net.phoenix492.testmod.util.ModTagKeys;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, TestMod.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.BISMUTH_BLOCK.get())
                .add(ModBlocks.BISMUTH_ORE.get())
                .add(ModBlocks.BISMUTH_DEEPSLATE_ORE.get())
                .add(ModBlocks.MAGIC_BLOCK.get())
                .add(ModBlocks.BISMUTH_FENCE.get())
                .add(ModBlocks.BISMUTH_LAMP.get())
                .add(ModBlocks.BISMUTH_WALL.get())
                .add(ModBlocks.BISMUTH_FENCE_GATE.get())
                .add(ModBlocks.BISMUTH_STAIRS.get())
                .add(ModBlocks.BISMUTH_SLAB.get())
                .add(ModBlocks.BISMUTH_BUTTON.get())
                .add(ModBlocks.BISMUTH_DOOR.get())
                .add(ModBlocks.BISMUTH_TRAPDOOR.get())
                .add(ModBlocks.BISMUTH_PRESSURE_PLATE.get());

        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.BISMUTH_BLOCK.get())
                .add(ModBlocks.BISMUTH_ORE.get())
                .add(ModBlocks.BISMUTH_FENCE.get())
                .add(ModBlocks.BISMUTH_LAMP.get())
                .add(ModBlocks.BISMUTH_WALL.get())
                .add(ModBlocks.BISMUTH_FENCE_GATE.get())
                .add(ModBlocks.BISMUTH_STAIRS.get())
                .add(ModBlocks.BISMUTH_SLAB.get())
                .add(ModBlocks.BISMUTH_BUTTON.get())
                .add(ModBlocks.BISMUTH_DOOR.get())
                .add(ModBlocks.BISMUTH_TRAPDOOR.get())
                .add(ModBlocks.BISMUTH_PRESSURE_PLATE.get());

        tag(BlockTags.NEEDS_DIAMOND_TOOL)
            .add(ModBlocks.BISMUTH_LAMP.get());

        tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.BISMUTH_DEEPSLATE_ORE.get());

        tag(BlockTags.FENCES)
            .add(ModBlocks.BISMUTH_FENCE.get());

        tag(BlockTags.WALLS)
            .add(ModBlocks.BISMUTH_WALL.get());

        tag(BlockTags.FENCE_GATES)
            .add(ModBlocks.BISMUTH_FENCE_GATE.get());

        tag(BlockTags.STAIRS)
            .add(ModBlocks.BISMUTH_STAIRS.get());

        tag(BlockTags.SLABS)
            .add(ModBlocks.BISMUTH_SLAB.get());

        tag(BlockTags.PRESSURE_PLATES)
            .add(ModBlocks.BISMUTH_PRESSURE_PLATE.get());

        tag(BlockTags.BUTTONS)
            .add(ModBlocks.BISMUTH_BUTTON.get());

        tag(BlockTags.DOORS)
            .add(ModBlocks.BISMUTH_DOOR.get());

        tag(BlockTags.TRAPDOORS)
            .add(ModBlocks.BISMUTH_TRAPDOOR.get());

        tag(ModTagKeys.Blocks.NEEDS_BISMUTH_TOOL)
            .add(ModBlocks.BISMUTH_LAMP.get())
            .addTag(BlockTags.NEEDS_IRON_TOOL);

        tag(ModTagKeys.Blocks.INCORRECT_FOR_BISMUTH_TOOL)
            .addTag(BlockTags.INCORRECT_FOR_IRON_TOOL)
            .remove(ModTagKeys.Blocks.NEEDS_BISMUTH_TOOL);

        tag(BlockTags.LOGS_THAT_BURN)
            .add(ModBlocks.BLOODWOOD_LOG.get())
            .add(ModBlocks.BLOODWOOD_WOOD.get())
            .add(ModBlocks.STRIPPED_BLOODWOOD_LOG.get())
            .add(ModBlocks.STRIPPED_BLOODWOOD_WOOD.get());
    }

}
