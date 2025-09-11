package net.phoenix492.testmod.entity;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.phoenix492.testmod.TestMod;
import net.phoenix492.testmod.entity.custom.GeckoEntity;

import javax.swing.text.html.parser.Entity;
import java.util.function.Supplier;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(BuiltInRegistries.ENTITY_TYPE, TestMod.MODID);

    public static final Supplier<EntityType<GeckoEntity>> GECKO = ENTITY_TYPES.register(
        "gecko",
        ()-> EntityType.Builder.of(GeckoEntity::new, MobCategory.CREATURE)
            .sized(0.75f, 0.35f).build("gecko")
    );

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
