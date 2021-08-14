#!/bin/bash

# scripts are from mod_utils project on my GitHub.

ID='simpleores'
NAME='SimpleOres2'
TOPDIR=`pwd`
PROJNAME=`basename $TOPDIR`
if [ $PROJNAME != $NAME ]; then
    echo "Running in wrong directory!"
    exit 1
fi

# blockstates
TARGETDIR=${TOPDIR}/src/main/resources/assets/${ID}/blockstates
if [ ! -d $TARGETDIR ]; then
    mkdir -p $TARGETDIR
fi
cd $TARGETDIR

# make simple blockstates
gen_blockstate_jsons.py --type=simple raw_tin_block
gen_blockstate_jsons.py --type=simple raw_mythril_block
gen_blockstate_jsons.py --type=simple raw_adamantium_block
gen_blockstate_jsons.py --type=simple deepslate_tin_ore
gen_blockstate_jsons.py --type=simple deepslate_mythril_ore
gen_blockstate_jsons.py --type=simple deepslate_adamantium_ore

# models
TARGETDIR=${TOPDIR}/src/main/resources/assets/${ID}/models
if [ ! -d $TARGETDIR ]; then
    mkdir -p $TARGETDIR
fi
cd $TARGETDIR

# block models
gen_model_jsons.py --type=block raw_tin_block 
gen_model_jsons.py --type=block raw_mythril_block 
gen_model_jsons.py --type=block raw_adamantium_block 
gen_model_jsons.py --type=block deepslate_tin_ore
gen_model_jsons.py --type=block deepslate_mythril_ore
gen_model_jsons.py --type=block deepslate_adamantium_ore

#inventory items
gen_model_jsons.py --type=inventory --item_only raw_tin
gen_model_jsons.py --type=inventory --item_only raw_mythril
gen_model_jsons.py --type=inventory --item_only raw_adamantium
gen_model_jsons.py --type=inventory --item_only deepslate_tin_ore
gen_model_jsons.py --type=inventory --item_only deepslate_mythril_ore
gen_model_jsons.py --type=inventory --item_only deepslate_adamantium_ore

