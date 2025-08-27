package net.phoenix492.testmod.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

import java.util.Map;

public class MagicBlock extends Block {

    public MagicBlock(Properties properties) {
        super(properties);
    }

    private static final Map<ResourceLocation, ResourceLocation> MAGIC_MAP =
            Map.of(
                    ResourceLocation.parse("phoenixtestmod:bismuth"), ResourceLocation.parse("minecraft:diamond")
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
            if(MAGIC_MAP.containsKey(itemResourceLocation)) {
                itemEntity.setItem(new ItemStack(BuiltInRegistries.ITEM.get(MAGIC_MAP.get(itemResourceLocation)), itemEntity.getItem().getCount()));
                level.playSound(null, pos, SoundEvents.LIGHTNING_BOLT_IMPACT, SoundSource.BLOCKS, 1, 1);
            }
        }

        super.stepOn(level, pos, state, entity);
    }
}
