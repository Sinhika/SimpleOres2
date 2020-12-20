#!/bin/bash

# scripts are from mod_utils project on my GitHub.

TOPDIR=`pwd`
PROJNAME=`basename $TOPDIR`
if [ $PROJNAME != 'SimpleOres2' ]; then
    echo "Running in wrong directory!"
    exit 1
fi

# recipes
TARGETDIR=${TOPDIR}/src/main/resources/data/simpleores/recipes
if [ ! -d $TARGETDIR ]; then
    mkdir -p $TARGETDIR
fi
cd $TARGETDIR

# Silent's Mechanisms recipes

# crusher

# ingots
make_silents_recipes.py --type=crusher --ticks=200 --ingredient='#forge:ingots/adamantium' \
    --result='simpleores:adamantium_dust' adamantium_dust_from_ingot
make_silents_recipes.py --type=crusher --ticks=200 --ingredient='simpleores:tin_ingot' \
    --result='simpleores:tin_dust' tin_dust_from_ingot
make_silents_recipes.py --type=crusher --ticks=200 --ingredient='#forge:ingots/mythril' \
    --result='simpleores:mythril_dust' mythril_dust_from_ingot

# ores
make_silents_recipes.py --type=crusher --ticks=400 --ingredient='simpleores:adamantium_ore' \
    --result 'simpleores:crushed_adamantium_ore,2' 'minecraft_cobblestone,0.1' \
    -- crushed_adamantium_ore
make_silents_recipes.py --type=crusher --ticks=400 --ingredient='simpleores:mythril_ore' \
    --result 'simpleores:crushed_mythril_ore,2' 'minecraft_cobblestone,0.1' \
    -- crushed_mythril_ore
make_silents_recipes.py --type=crusher --ticks=400 --ingredient='simpleores:tin_ore' \
    --result 'simpleores:crushed_tin_ore,2' 'minecraft_cobblestone,0.1' \
    -- crushed_tin_ore

# ore chunks
make_silents_recipes.py --type=crusher --ingredient='#silents_mechanisms:chunks/adamantium' \
    --result 'simpleores:adamantium_dust' 'simpleores:adamantium_dust,0.1' \
    -- adamantium_dust
make_silents_recipes.py --type=crusher --ingredient='#silents_mechanisms:chunks/mythril' \
    --result 'simpleores:mythril_dust' 'simpleores:mythril_dust,0.1' \
    -- mythril_dust
make_silents_recipes.py --type=crusher --ingredient='simpleores:crushed_tin_ore' \
    --result 'simpleores:tin_dust' 'simpleores:tin_dust,0.1' \
    -- tin_dust

