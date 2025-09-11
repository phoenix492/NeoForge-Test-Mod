package net.phoenix492.testmod.event;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.phoenix492.testmod.TestMod;
import net.phoenix492.testmod.entity.ModEntities;
import net.phoenix492.testmod.entity.client.GeckoModel;
import net.phoenix492.testmod.entity.custom.GeckoEntity;

@EventBusSubscriber(modid = TestMod.MODID)
public class ModEventBusEvents {

    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(GeckoModel.LAYER_LOCATION, GeckoModel::createBodyLayer);

    }
    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.GECKO.get(), GeckoEntity.createAttributes().build());
    }
}
