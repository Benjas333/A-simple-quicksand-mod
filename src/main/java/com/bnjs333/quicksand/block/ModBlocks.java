package com.bnjs333.quicksand.block;

import com.bnjs333.quicksand.Quicksand;
import com.bnjs333.quicksand.block.custom.QuicksandBlock;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {
    public static final Block QUICKSAND = registerBlock("quicksand",
            new QuicksandBlock(FabricBlockSettings.copyOf(Blocks.POWDER_SNOW).sounds(BlockSoundGroup.MUD).strength(0.5F)));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(Quicksand.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(Quicksand.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    private static void addItemsToNaturalItemGroup(FabricItemGroupEntries entries) {
        entries.add(QUICKSAND);
    }

    public static void registerModBlocks() {
        Quicksand.LOGGER.info("Registering ModBlocks for " + Quicksand.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(ModBlocks::addItemsToNaturalItemGroup);
    }
}
