package io.github.TKDroid555.Effects.custom;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;

public class AppetiteEffect extends MobEffect {
    public AppetiteEffect() {super(MobEffectCategory.NEUTRAL, 0x6E4C1E);}

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return true; // tick every tick
    }

    @Override
    public void applyEffectTick(LivingEntity entity, int amplifier) {
        if (entity instanceof Player player)
        {
            if (player.getFoodData().getFoodLevel() > 18)
                player.getFoodData().setFoodLevel(18);
        }
    }
}
