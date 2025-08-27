package net.phoenix492.testmod.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.TagKey;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.phoenix492.testmod.util.ReusableTagKeys;

import java.util.List;
import java.util.Map;

public class MagicBlock extends Block {

    public MagicBlock(Properties properties) {
        super(properties);
    }

    private static final Map<ResourceLocation, ResourceLocation> MAGIC_MAP_ITEMS =
            Map.of(
                    ResourceLocation.parse("phoenixtestmod:bismuth"), ResourceLocation.parse("minecraft:diamond")
            );
    private static final Map<TagKey<Item>, ResourceLocation> MAGIC_MAP_TAGS =
            Map.of(
                    ReusableTagKeys.Items.TRANSFORMABLE_INTO_DIAMOND, ResourceLocation.parse("minecraft:diamond")
            );

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        level.playSound(player, pos, SoundEvents.AMETHYST_CLUSTER_PLACE, SoundSource.BLOCKS, 1, 1);
        return InteractionResult.SUCCESS;
    }

    @Override
    public void stepOn(Level level, BlockPos pos, BlockState state, Entity entity) {
        if (entity instanceof ItemEntity itemEntity) {
            ResourceLocation itemResourceLocation = BuiltInRegistries.ITEM.getKey(itemEntity.getItem().getItem());
            if(MAGIC_MAP_ITEMS.containsKey(itemResourceLocation)) {
                itemEntity.setItem(new ItemStack(BuiltInRegistries.ITEM.get(MAGIC_MAP_ITEMS.get(itemResourceLocation)), itemEntity.getItem().getCount()));
                level.playSound(null, pos, SoundEvents.LIGHTNING_BOLT_IMPACT, SoundSource.BLOCKS, 1, 1);
            } else {
                MAGIC_MAP_TAGS.forEach((k, v) -> {
                    if (itemEntity.getItem().is(k)) {
                        itemEntity.setItem(new ItemStack(BuiltInRegistries.ITEM.get(v), itemEntity.getItem().getCount()));
                    };
                });
            }
        }

        super.stepOn(level, pos, state, entity);
    }

    @Override
    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        tooltipComponents.add(Component.translatable("tooltip.phoenixtestmod.magic_block.tooltip"));
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }
}
