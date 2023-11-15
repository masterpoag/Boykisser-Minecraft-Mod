package com.colby.boykisser.block;

import com.colby.boykisser.MinecraftMod;
import com.colby.boykisser.item.Moditems;
import com.colby.boykisser.sound.ModSounds;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MinecraftMod.MODID);

    public static final RegistryObject<Block> BOYKISSERIUM_BLOCK = registerBlock("boykisserium_block",
        ()-> new com.colby.boykisser.block.SoundBlock(BlockBehaviour.Properties.copy(Blocks.OBSIDIAN)
                .strength(6f).requiresCorrectToolForDrops())
    );

    public static final RegistryObject<Block> BOYKISSERIUM_ORE = registerBlock("boykisserium_ore",
            ()-> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(6f).requiresCorrectToolForDrops(),
                    UniformInt.of(3,5)));
    public static final RegistryObject<Block> DEEPSLATE_BOYKISSERIUM_ORE = registerBlock("deepslate_boykisserium_ore",
            ()-> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(6f).requiresCorrectToolForDrops(),
                    UniformInt.of(3,5)));



    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return Moditems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
