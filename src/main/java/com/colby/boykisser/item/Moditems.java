package com.colby.boykisser.item;

import com.colby.boykisser.MinecraftMod;
import com.colby.boykisser.item.custom.boykisser;
import com.colby.boykisser.item.custom.thrower;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SnowballItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class Moditems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MinecraftMod.MODID);

    public static final RegistryObject<Item> BOYKISSERIUM = ITEMS.register("boykisserium",
            () -> new boykisser(new Item.Properties()));
    public static final RegistryObject<Item> RAW_BOYKISSERIUM = ITEMS.register("raw_boykisserium",
            () -> new thrower(new Item.Properties().stacksTo(64)
                    ));
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
