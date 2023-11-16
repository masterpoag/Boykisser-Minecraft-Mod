package com.colby.boykisser.item;

import com.colby.boykisser.MinecraftMod;
import com.colby.boykisser.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MinecraftMod.MODID);

    public static final RegistryObject<CreativeModeTab> TAB = CREATIVE_MODE_TABS.register("tab",
            () -> CreativeModeTab.builder().icon(()-> new ItemStack(Moditems.BOYKISSERIUM.get()))
                    .title(Component.translatable("creativetab.boykisser_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(Moditems.BOYKISSERIUM.get());
                        pOutput.accept(Moditems.RAW_BOYKISSERIUM.get());
                        pOutput.accept(ModBlocks.BOYKISSERIUM_BLOCK.get());
                        pOutput.accept(ModBlocks.DEEPSLATE_BOYKISSERIUM_ORE.get());
                        pOutput.accept(ModBlocks.BOYKISSERIUM_ORE.get());
                        pOutput.accept(ModBlocks.RAW_BOYKISSERIUM_BLOCK.get());
                        pOutput.accept(ModBlocks.COMPRESSED_BOYKISSERIUM_BLOCK.get());
                    })
                    .build());

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
/*
        event.accept(Moditems.BOYKISSERIUM);
        event.accept(Moditems.RAW_BOYKISSERIUM);
        event.accept(ModBlocks.BOYKISSERIUM_BLOCK);
        event.accept(ModBlocks.DEEPSLATE_BOYKISSERIUM_ORE);
        event.accept(ModBlocks.BOYKISSERIUM_ORE);
 */
