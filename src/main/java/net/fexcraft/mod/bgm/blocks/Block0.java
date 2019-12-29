package net.fexcraft.mod.bgm.blocks;

import net.fexcraft.lib.mc.api.registry.fBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFalling;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

@fBlock(modid = "bgm", name = "block0", variants = 16, item = Block0.IB.class, custom_variants = { "white", "orange", "magenta", "light_blue", "yellow", "lime", "pink", "gray", "silver", "cyan", "purple", "blue", "brown", "green", "red", "black" })
public class Block0 extends BlockFalling {

	public static final PropertyInteger COLOURS = PropertyInteger.create("color", 0, 15);

	public Block0(){
		super(Material.IRON); this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		this.setDefaultState(this.blockState.getBaseState().withProperty(COLOURS, 0));
	}
	
    @Override
    public boolean isFullBlock(IBlockState state){
    	return false;
    }

    @Override
    public boolean isFullCube(IBlockState state){
    	return false;
    }

    @Override
    public boolean isOpaqueCube(IBlockState state){
    	return false;
    }

    @Override
    public IBlockState getStateFromMeta(int meta){
        return this.getDefaultState().withProperty(COLOURS, meta);
    }

    @Override
    public int getMetaFromState(IBlockState state){
        return state.getValue(COLOURS);
    }

    @Override
    protected BlockStateContainer createBlockState(){
        return new BlockStateContainer(this, new IProperty[]{ COLOURS });
    }
    
    @Override
    public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player){
        return new ItemStack(this, 1, state.getValue(COLOURS));
    }
    
    public static class IB extends ItemBlock {

		public IB(Block block){
			super(block); this.setHasSubtypes(true);
		}

		@Override
		public int getMetadata(int meta){
			return meta;
		}
		
		@Override
		public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items){
	        if(!this.isInCreativeTab(tab)) return;
	        for(int i = 0; i < 16; i++) items.add(new ItemStack(block, 1, i));
	    }

	}

}
