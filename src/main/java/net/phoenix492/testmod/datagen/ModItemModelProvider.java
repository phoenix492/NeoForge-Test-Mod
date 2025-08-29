package net.phoenix492.testmod.datagen;

import net.minecraft.client.renderer.block.model.ItemModelGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.models.ItemModelGenerators;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.phoenix492.testmod.TestMod;
import net.phoenix492.testmod.block.ModBlocks;
import net.phoenix492.testmod.item.ModItems;

public class ModItemModelProvider extends ItemModelProvider {

    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, TestMod.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.RAW_BISMUTH.get());
        basicItem(ModItems.BISMUTH.get());
        basicItem(ModItems.RADISH.get());
        basicItem(ModItems.STARLIGHT_ASHES.get());
        basicItem(ModItems.FROSTFIRE_ICE.get());
        basicItem(ModItems.CHISEL.get());
        basicItem(ModBlocks.BISMUTH_DOOR.asItem());

        basicItem(ModItems.BISMUTH_HELMET.get());
        basicItem(ModItems.BISMUTH_CHESTPLATE.get());
        basicItem(ModItems.BISMUTH_LEGGINGS.get());
        basicItem(ModItems.BISMUTH_BOOTS.get());

        buttonItem(ModBlocks.BISMUTH_BUTTON, ModBlocks.BISMUTH_BLOCK);
        fenceItem(ModBlocks.BISMUTH_FENCE, ModBlocks.BISMUTH_BLOCK);
        wallItem(ModBlocks.BISMUTH_WALL, ModBlocks.BISMUTH_BLOCK);

        handheldItem(ModItems.BISMUTH_SWORD.get());
        handheldItem(ModItems.BISMUTH_PICKAXE.get());
        handheldItem(ModItems.BISMUTH_SHOVEL.get());
        handheldItem(ModItems.BISMUTH_HOE.get());
        handheldItem(ModItems.BISMUTH_AXE.get());
        handheldItem(ModItems.BISMUTH_HAMMER.get());

    }

    public void buttonItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/button_inventory"))
            .texture(
                "texture",
                ResourceLocation.fromNamespaceAndPath(
                    TestMod.MODID,
                    "block/" + baseBlock.getId().getPath()
                )
            );
    }

    public void fenceItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/fence_inventory"))
            .texture(
                "texture",
                ResourceLocation.fromNamespaceAndPath(
                    TestMod.MODID,
                    "block/" + baseBlock.getId().getPath()
                )
            );
    }

    public void wallItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/wall_inventory"))
            .texture(
                "wall",
                ResourceLocation.fromNamespaceAndPath(
                    TestMod.MODID,
                    "block/" + baseBlock.getId().getPath()
                )
            );
    }
}
