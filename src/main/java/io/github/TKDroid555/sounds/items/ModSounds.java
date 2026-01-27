package io.github.TKDroid555.sounds.items;

import io.github.TKDroid555.MorningTea;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUNDS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, MorningTea.MODID);

    public static final RegistryObject<SoundEvent> TEA_DRINK =
            SOUNDS.register(
                    "item.tea.drink",
                    () -> SoundEvent.createVariableRangeEvent(
                            new ResourceLocation(MorningTea.MODID, "item.tea.drink")
                    )
            );

    public static void register(IEventBus bus) {SOUNDS.register(bus);}
}
