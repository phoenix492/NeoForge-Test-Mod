package net.phoenix492.testmod.item.custom;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.phoenix492.testmod.component.ModDataComponents;

import java.util.List;
import java.util.Map;

public class ChiselItem extends Item {
    private static final Map<ResourceLocation, ResourceLocation> CHISEL_MAP =
            Map.of(
                    ResourceLocation.parse("minecraft:stone"), ResourceLocation.parse("minecraft:stone_bricks"),
                    ResourceLocation.parse("minecraft:end_stone"), ResourceLocation.parse("minecraft:end_stone_bricks"),
                    ResourceLocation.parse("minecraft:deepslate"), ResourceLocation.parse("minecraft:deepslate_bricks"),
                    ResourceLocation.parse("minecraft:glowstone"), ResourceLocation.parse("minecraft:shroomlight"),
                    ResourceLocation.parse("phoenixtestmod:bismuth_ore"), ResourceLocation.parse("phoenixtestmod:bismuth_deepslate_ore")
            );

    public ChiselItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        Block clickedBlock = level.getBlockState(context.getClickedPos()).getBlock();

        if (CHISEL_MAP.containsKey(BuiltInRegistries.BLOCK.getKey(clickedBlock))) {

            if (!level.isClientSide()) {
                level.setBlockAndUpdate(context.getClickedPos(), BuiltInRegistries.BLOCK.get(CHISEL_MAP.get(BuiltInRegistries.BLOCK.getKey(clickedBlock))).defaultBlockState());

                context.getItemInHand().hurtAndBreak(1, ((ServerLevel) level), context.getPlayer(),
                        item -> context.getPlayer().onEquippedItemBroken(item, EquipmentSlot.MAINHAND));

                level.playSound(null, context.getClickedPos(), SoundEvents.GRINDSTONE_USE, SoundSource.BLOCKS);

                context.getItemInHand().set(ModDataComponents.COORDINATES, context.getClickedPos());
            }

        }

        return InteractionResult.SUCCESS;
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        if (Screen.hasShiftDown()) {
        tooltipComponents.add(Component.translatable("tooltip.tutorialmod.chisel.shift_down"));
        } else {
            tooltipComponents.add(Component.translatable("tooltip.tutorialmod.chisel"));
        }

        if (stack.get(ModDataComponents.COORDINATES) != null) {
            tooltipComponents.add(Component.literal("Last Block changed at " + stack.get(ModDataComponents.COORDINATES).getX() + " " + stack.get(ModDataComponents.COORDINATES).getY() + " " + stack.get(ModDataComponents.COORDINATES).getZ()));
        }
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }
}
