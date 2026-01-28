package io.github.TKDroid555.Effects;

import io.github.TKDroid555.Effects.custom.DrunkEffect;
import io.github.TKDroid555.Effects.custom.AppetiteEffect;
import io.github.TKDroid555.MorningTea;
import net.minecraft.world.effect.MobEffect;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEffects {
    public static final DeferredRegister<MobEffect> EFFECTS = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, MorningTea.MODID);

    public static final RegistryObject<MobEffect> DRUNK_EFFECT = EFFECTS.register("drunk", DrunkEffect::new);
    public static final RegistryObject<MobEffect> APPETITE_EFFECT = EFFECTS.register("appetite", AppetiteEffect::new);

    public static void register(IEventBus eventBus)
    {EFFECTS.register(eventBus);}
}
