package net.phoenix492.testmod.item;


import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.phoenix492.testmod.TestMod;
import net.phoenix492.testmod.item.custom.ChiselItem;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(TestMod.MODID);

    public static final DeferredItem<Item> BISMUTH = ITEMS.register(
            "bismuth",
            () -> new Item(new Item.Properties())
    );

    public static final DeferredItem<Item> RAW_BISMUTH = ITEMS.register(
            "raw_bismuth",
            () -> new Item(new Item.Properties())
    );

    public static final DeferredItem<Item> CHISEL = ITEMS.register(
            "chisel",
            () -> new ChiselItem(new Item.Properties().durability(32))
    );

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
