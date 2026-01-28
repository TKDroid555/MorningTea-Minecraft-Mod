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
        drunkTexts.add("FuCKiNg HeLL wHy THe WoRLd IS sPInNiNg?!??!");
        drunkTexts.add("WhY iS eVeRYthiNg so dAMn LOuD??!");
        drunkTexts.add("THis iS sOMe wEIrD-aSs bUlLsHIt.!!");
        drunkTexts.add("I sWEaR I waS StANdiNg sTILl a sEcONd AGo...");
        drunkTexts.add("WHo the FUcK moVEd tHe fLOoR?!!?!");
        drunkTexts.add("THiS ShiT dOeSN’t mAkE aNy daMN sEnSe??!!?");
        drunkTexts.add("WHy IS WaLKinG sUdDEnlY sO DAmN HARD...?!!?");
        drunkTexts.add("FuCK lIFe, FUCK EVERYTHING...!!.!");
        drunkTexts.add("StUPiD vilLAGerS GEt OuT ThE FUCkINg wAy!!..!!.!");
    }
    private static int prevRandomIndex = 0;
    public static String getDrunkText() {
        int randomIndex = ThreadLocalRandom.current().nextInt(0, drunkTexts.size());
        while (randomIndex == prevRandomIndex)
            {randomIndex = ThreadLocalRandom.current().nextInt(0, drunkTexts.size());}
        prevRandomIndex = randomIndex;

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
    }
}
