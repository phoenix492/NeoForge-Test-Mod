package net.phoenix492.testmod.item.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.DiggerItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;

import java.util.ArrayList;
import java.util.List;

public class HammerItem extends DiggerItem {
    public HammerItem(Tier tier, Properties properties) {
        super(tier, BlockTags.MINEABLE_WITH_PICKAXE, properties);
    }

    public static List<BlockPos> getBlocksToDestroy(int range, BlockPos initialBlockPos, ServerPlayer player) {
        List<BlockPos> positions = new ArrayList<>();

        BlockHitResult traceResult = player.level().clip(
            new ClipContext(
                player.getEyePosition(1f),
                player.getEyePosition(1f).add(player.getViewVector(1f).scale(6f)),
                ClipContext.Block.COLLIDER,
                ClipContext.Fluid.NONE,
                player
            )
        );

        if (traceResult.getType() == HitResult.Type.MISS) {
            return positions;
        }

        switch (traceResult.getDirection()) {
            case DOWN:
            case UP:
                for (int x = -range; x <= range; x++) {
                    for (int z = -range; z <= range; z++) {
                        positions.add(new BlockPos(initialBlockPos.getX() + x, initialBlockPos.getY(), initialBlockPos.getZ() + z));
                    }
                }
                break;
            case NORTH:
            case SOUTH:
                for (int x = -range; x <= range; x++) {
                    for (int y = -range; y <= range; y++) {
                        positions.add(new BlockPos(initialBlockPos.getX() + x, initialBlockPos.getY() + y, initialBlockPos.getZ()));
                    }
                }
                break;
            case EAST:
            case WEST:
                for (int y = -range; y <= range; y++) {
                    for (int z = -range; z <= range; z++) {
                        positions.add(new BlockPos(initialBlockPos.getX(), initialBlockPos.getY() + y, initialBlockPos.getZ() + z));
                    }
                }
                break;
        }

        return positions;

    }
}
