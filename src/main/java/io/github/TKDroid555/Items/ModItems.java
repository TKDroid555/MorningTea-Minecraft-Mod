package io.github.TKDroid555.Items;

import io.github.TKDroid555.Items.custom.BeerItem;
import io.github.TKDroid555.Items.custom.BitterLeafTeaItem;
import io.github.TKDroid555.MorningTea;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MorningTea.MODID);

    // Spruce Tea register
    public static final RegistryObject<Item> BITTER_LEAF_TEA = ITEMS.register("bitter_leaf_tea",
            () -> new BitterLeafTeaItem( new BitterLeafTeaItem.Properties().stacksTo(16)));
    public static final RegistryObject<Item> BEER = ITEMS.register("beer",
            () -> new BeerItem( new BeerItem.Properties().stacksTo(16)));

    public static void register(IEventBus eventBus) {ITEMS.register(eventBus);}
}
