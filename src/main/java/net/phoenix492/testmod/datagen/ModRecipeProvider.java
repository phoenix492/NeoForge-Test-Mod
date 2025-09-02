package net.phoenix492.testmod.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import net.phoenix492.testmod.TestMod;
import net.phoenix492.testmod.block.ModBlocks;
import net.phoenix492.testmod.item.ModItems;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    List<ItemLike> BISMUTH_SMELTABLES = List.of(ModItems.RAW_BISMUTH, ModBlocks.BISMUTH_ORE, ModBlocks.BISMUTH_DEEPSLATE_ORE);

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.BISMUTH_BLOCK.get())
                .pattern("BBB")
                .pattern("BBB")
                .pattern("BBB")
                .define('B', ModItems.BISMUTH.get())
                .unlockedBy("has_bismuth", has(ModItems.BISMUTH))
                .save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.BISMUTH.get(), 9)
            .requires(ModBlocks.BISMUTH_BLOCK)
            .unlockedBy("has_bismuth_block", has(ModBlocks.BISMUTH_BLOCK))
            .save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.BISMUTH.get(), 18)
            .requires(ModBlocks.MAGIC_BLOCK)
            .unlockedBy("has_magic_block", has(ModBlocks.MAGIC_BLOCK))
            .save(recipeOutput, "phoenixtestmod:bismuth_from_magic_block");

        slab(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.BISMUTH_SLAB.get(), ModItems.BISMUTH.get());
        wall(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.BISMUTH_WALL.get(), ModItems.BISMUTH.get());
        pressurePlate(recipeOutput, ModBlocks.BISMUTH_PRESSURE_PLATE.get(), ModItems.BISMUTH.get());

        stairBuilder(ModBlocks.BISMUTH_STAIRS.get(), Ingredient.of(ModItems.BISMUTH.get()))
            .group("bismuth")
            .unlockedBy("has_bismuth", has(ModItems.BISMUTH.get()))
            .save(recipeOutput);
        fenceBuilder(ModBlocks.BISMUTH_FENCE.get(), Ingredient.of(ModItems.BISMUTH.get()))
            .group("bismuth")
            .unlockedBy("has_bismuth", has(ModItems.BISMUTH.get()))
            .save(recipeOutput);
        fenceGateBuilder(ModBlocks.BISMUTH_FENCE_GATE.get(), Ingredient.of(ModItems.BISMUTH.get()))
            .group("bismuth")
            .unlockedBy("has_bismuth", has(ModItems.BISMUTH.get()))
            .save(recipeOutput);
        doorBuilder(ModBlocks.BISMUTH_DOOR.get(), Ingredient.of(ModItems.BISMUTH.get()))
            .group("bismuth")
            .unlockedBy("has_bismuth", has(ModItems.BISMUTH.get()))
            .save(recipeOutput);
        buttonBuilder(ModBlocks.BISMUTH_BUTTON.get(), Ingredient.of(ModItems.BISMUTH.get()))
            .group("bismuth")
            .unlockedBy("has_bismuth", has(ModItems.BISMUTH.get()))
            .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BISMUTH_TRAPDOOR.get())
            .pattern("BB")
            .pattern("BB")
            .define('B', ModItems.BISMUTH.get())
            .unlockedBy("has_bismuth", has(ModItems.BISMUTH))
            .save(recipeOutput);


        oreSmelting(recipeOutput, BISMUTH_SMELTABLES, RecipeCategory.MISC, ModItems.BISMUTH.get(), 0.25f, 200, "bismuth");
        oreBlasting(recipeOutput, BISMUTH_SMELTABLES, RecipeCategory.MISC, ModItems.BISMUTH.get(), 0.25f, 100, "bismuth");

        trimSmithing(recipeOutput, ModItems.PHOENIX_SMITHING_TEMPLATE.get(), ResourceLocation.fromNamespaceAndPath(TestMod.MODID, "phoenix"));


        super.buildRecipes(recipeOutput);
    }

    protected static <T extends AbstractCookingRecipe> void oreCooking(
        RecipeOutput recipeOutput,
        RecipeSerializer<T> serializer,
        AbstractCookingRecipe.Factory<T> recipeFactory,
        List<ItemLike> ingredients,
        RecipeCategory category,
        ItemLike result,
        float experience,
        int cookingTime,
        String group,
        String suffix
    ) {
        for (ItemLike itemlike : ingredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), category, result, experience, cookingTime, serializer, recipeFactory)
                .group(group)
                .unlockedBy(getHasName(itemlike), has(itemlike))
                .save(recipeOutput, TestMod.MODID + getItemName(result) + suffix + "_" + getItemName(itemlike));
        }
    }

    protected static void oreSmelting(
        RecipeOutput recipeOutput,
        List<ItemLike> ingredients,
        RecipeCategory category,
        ItemLike result,
        float experience,
        int cookingTime,
        String group
    ) {
        oreCooking(
            recipeOutput,
            RecipeSerializer.SMELTING_RECIPE,
            SmeltingRecipe::new,
            ingredients,
            category,
            result,
            experience,
            cookingTime,
            group,
            "_from_smelting"
        );
    }

    protected static void oreBlasting(
        RecipeOutput recipeOutput, List<ItemLike> ingredients, RecipeCategory category, ItemLike result, float experience, int cookingTime, String group
    ) {
        oreCooking(
            recipeOutput,
            RecipeSerializer.BLASTING_RECIPE,
            BlastingRecipe::new,
            ingredients,
            category,
            result,
            experience,
            cookingTime,
            group,
            "_from_blasting"
        );
    }
}
