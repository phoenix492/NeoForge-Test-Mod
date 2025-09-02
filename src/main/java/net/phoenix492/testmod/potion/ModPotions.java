package net.phoenix492.testmod.potion;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.alchemy.Potion;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.phoenix492.testmod.TestMod;
import net.phoenix492.testmod.effect.ModEffects;

public class ModPotions {
    public static final DeferredRegister<Potion> POTIONS = DeferredRegister.create(BuiltInRegistries.POTION, TestMod.MODID);

    public static final Holder<Potion> SLIMY_POTION = POTIONS.register(
        "slimy_potion",
        () -> new Potion(new MobEffectInstance(ModEffects.SLIMY_EFFECT, 1200,0))
    );

    public static void register(IEventBus eventBus) {
        POTIONS.register(eventBus);
    }

}
