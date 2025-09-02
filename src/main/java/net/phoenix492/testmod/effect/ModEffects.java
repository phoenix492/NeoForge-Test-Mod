package net.phoenix492.testmod.effect;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.phoenix492.testmod.TestMod;

public class ModEffects {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS = DeferredRegister.create(BuiltInRegistries.MOB_EFFECT, TestMod.MODID);

    public static final Holder<MobEffect> SLIMY_EFFECT = MOB_EFFECTS.register(
        "slimy",
        () -> new SlimyEffect(MobEffectCategory.NEUTRAL, 0x36ebab)
            .addAttributeModifier(
                Attributes.MOVEMENT_SPEED,
                ResourceLocation.fromNamespaceAndPath(TestMod.MODID, "slimy"),
                -0.25f,
                AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL
            )
    );

    public static void register(IEventBus eventBus) {
        MOB_EFFECTS.register(eventBus);
    }
}
