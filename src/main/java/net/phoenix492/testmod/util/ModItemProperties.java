package net.phoenix492.testmod.util;

import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.phoenix492.testmod.TestMod;
import net.phoenix492.testmod.component.ModDataComponents;
import net.phoenix492.testmod.item.ModItems;

public class ModItemProperties {
    public static void addCustomItemProperties() {
        ItemProperties.register(ModItems.CHISEL.get(), ResourceLocation.fromNamespaceAndPath(TestMod.MODID, "used"),
            (stack, level, entity, seed) -> stack.get(ModDataComponents.COORDINATES) != null ? 1f: 0f
        );
        makeCustomBow(ModItems.KAUPEN_BOW.get());
    }

    private static void makeCustomBow(Item item) {
        ItemProperties.register(
            item,
            ResourceLocation.withDefaultNamespace("pull"),
            (itemStack, level, entity, i) -> {
                if (entity == null) {
                    return 0.0F;
                } else {
                    return entity.getUseItem() != itemStack ? 0.0F : (float)(itemStack.getUseDuration(entity) - entity.getUseItemRemainingTicks()) / 20.0F;
                }
            }
        );
        ItemProperties.register(
            item,
            ResourceLocation.withDefaultNamespace("pulling"),
            (itemStack, level, entity, i) -> {
                return entity != null && entity.isUsingItem() && entity.getUseItem() == itemStack ? 1.0F : 0.0F;
            }
        );
    }
}
