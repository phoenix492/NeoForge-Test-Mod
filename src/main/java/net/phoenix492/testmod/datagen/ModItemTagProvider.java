package net.phoenix492.testmod.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.BlockTags;
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

        tag(ItemTags.SWORDS)
            .add(ModItems.BISMUTH_SWORD.get());

        tag(ItemTags.PICKAXES)
            .add(ModItems.BISMUTH_PICKAXE.get());

        tag(ItemTags.SHOVELS)
            .add(ModItems.BISMUTH_SHOVEL.get());

        tag(ItemTags.AXES)
            .add(ModItems.BISMUTH_AXE.get());

        tag(ItemTags.HOES)
            .add(ModItems.BISMUTH_HOE.get());

        tag(ItemTags.HEAD_ARMOR)
            .add(ModItems.BISMUTH_HELMET.get());

        tag(ItemTags.CHEST_ARMOR)
            .add(ModItems.BISMUTH_CHESTPLATE.get());

        tag(ItemTags.LEG_ARMOR)
            .add(ModItems.BISMUTH_LEGGINGS.get());

        tag(ItemTags.FOOT_ARMOR)
            .add(ModItems.BISMUTH_BOOTS.get());

        tag(ItemTags.TRIM_MATERIALS)
            .add(ModItems.BISMUTH.get());

        tag(ItemTags.TRIM_TEMPLATES)
            .add(ModItems.PHOENIX_SMITHING_TEMPLATE.get());

        tag(ItemTags.LOGS_THAT_BURN)
            .add(ModBlocks.BLOODWOOD_LOG.asItem())
            .add(ModBlocks.BLOODWOOD_WOOD.asItem())
            .add(ModBlocks.STRIPPED_BLOODWOOD_LOG.asItem())
            .add(ModBlocks.STRIPPED_BLOODWOOD_WOOD.asItem());

        tag(ItemTags.PLANKS)
            .add(ModBlocks.BLOODWOOD_PLANKS.asItem());
    }
}
