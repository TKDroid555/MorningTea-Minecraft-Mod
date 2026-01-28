package io.github.TKDroid555.Effects.custom;

import io.github.TKDroid555.Effects.ModEffects;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class DrunkEffect extends MobEffect{
    public DrunkEffect() { super(MobEffectCategory.HARMFUL, 0x6E4C1E);}

    private static ArrayList<String> drunkTexts = new ArrayList<String>();
    static {
        drunkTexts.add("kiLL ALL NIgGers...!!!");
        drunkTexts.add("Burn in hell... fucking GAYS!!.!!");
        drunkTexts.add("FuCk! YoU! NEGROS!!!");
        drunkTexts.add("I'M sO FucKiNg... HAtE ISrAel...!");
        drunkTexts.add("FuCKIng GoBLiN BEnJAmiN NetANyAhU...!!!");
        drunkTexts.add("HEIL HITLER!!!");
        drunkTexts.add("MaY ALL THe NIGgeRs DIE!!!");
    }
    public static String getDrunkText() {
        int randomIndex = ThreadLocalRandom.current().nextInt(0, drunkTexts.size());
        return drunkTexts.get(randomIndex);
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return true; // tick every tick
    }

    @Override
    public void applyEffectTick(LivingEntity entity, int amplifier) {
        int interval = Math.max(100 - (10*amplifier), 40);

        if (entity.level().isClientSide) return;
        entity.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 100, amplifier, false, true));
        if (entity.level().getGameTime() % interval != 0) return;

        var server = entity.getServer();
        if (server == null) return;

        server.getPlayerList().broadcastSystemMessage(
                Component.literal("<" + entity.getName().getString() + "> " + getDrunkText()),
                false
        );

        // SERVER-side logic only (optional)
    }
}
