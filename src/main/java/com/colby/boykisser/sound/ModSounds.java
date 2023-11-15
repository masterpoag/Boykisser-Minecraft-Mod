package com.colby.boykisser.sound;

import com.colby.boykisser.MinecraftMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.common.util.ForgeSoundType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;



import static net.minecraft.core.Registry.registerForHolder;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENT =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, MinecraftMod.MODID);

    public static final RegistryObject<SoundEvent> METAL_DETECTOR_FOUND_ORE = registerSoundEvents("metal_detector_found_ore");

    public static final ForgeSoundType SOUND_BLOCK_SOUNDS = new ForgeSoundType(1f, 1f,
            ModSounds.METAL_DETECTOR_FOUND_ORE, ModSounds.METAL_DETECTOR_FOUND_ORE, ModSounds.METAL_DETECTOR_FOUND_ORE,
            ModSounds.METAL_DETECTOR_FOUND_ORE, ModSounds.METAL_DETECTOR_FOUND_ORE);

    private static RegistryObject<SoundEvent> registerSoundEvents(String name){
        return SOUND_EVENT.register(name, () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(MinecraftMod.MODID, name)));
    }

    public static void register(IEventBus eventBus){
        SOUND_EVENT.register(eventBus);
    }
}
