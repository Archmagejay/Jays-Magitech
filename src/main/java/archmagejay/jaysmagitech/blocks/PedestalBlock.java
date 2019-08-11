package archmagejay.jaysmagitech.blocks;

import archmagejay.jaysmagitech.JaysMagitech;
import archmagejay.jaysmagitech.blocks.tiles.PedestalTESR;
import archmagejay.jaysmagitech.blocks.tiles.PedestalTileEntity;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;

@SuppressWarnings("deprecation")
public class PedestalBlock extends Block implements ITileEntityProvider {
    public static final IProperty<Boolean> IS_HANDLES = PropertyBool.create("is_handles");

    public PedestalBlock() {
        super(Material.ROCK);
        setUnlocalizedName(JaysMagitech.MODID + ".pedestal");
        setRegistryName("pedestal");
        setDefaultState(blockState.getBaseState().withProperty(IS_HANDLES, false));
    }

    @Override
    public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos) {
        return state.withProperty(IS_HANDLES, false);
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, IS_HANDLES);
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        return getDefaultState();
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return 0;
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(getRegistryName(), "inventory"));
        ClientRegistry.bindTileEntitySpecialRenderer(PedestalTileEntity.class, new PedestalTESR());
    }

    @Nullable
    @Override
    public TileEntity createNewTileEntity(World world, int i) {
        return new PedestalTileEntity();
    }

    @Override
    public boolean isBlockNormalCube(IBlockState state) {
        return false;
    }

    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    private PedestalTileEntity getTE(World w, BlockPos pos) {
        return (PedestalTileEntity) w.getTileEntity(pos);
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if (!worldIn.isRemote) {
            PedestalTileEntity te = getTE(worldIn, pos);
            if (te.getStack().isEmpty()) {
                if (!playerIn.getHeldItem(hand).isEmpty()) {
                    //No item in the pedestal and the players hand is not empty
                    te.setStack(playerIn.getHeldItem(hand));
                    playerIn.inventory.setInventorySlotContents(playerIn.inventory.currentItem, ItemStack.EMPTY);
                    playerIn.openContainer.detectAndSendChanges();
                }
            } else {
                //There is a stack in the pedestal
                ItemStack stack = te.getStack();
                te.setStack(ItemStack.EMPTY);
                if (!playerIn.inventory.addItemStackToInventory(stack)) {
                    EntityItem entityItem = new EntityItem(worldIn, pos.getX(), pos.getY()+1, pos.getZ(), stack);
                    worldIn.spawnEntity(entityItem);
                } else {
                    playerIn.openContainer.detectAndSendChanges();
                }
            }
         }
        return true;
    }
}
