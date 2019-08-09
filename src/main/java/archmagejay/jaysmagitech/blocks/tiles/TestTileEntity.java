package archmagejay.jaysmagitech.blocks.tiles;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TestTileEntity extends TileEntity {
    private int counter;

    public int decrement() {
        counter--;
        markDirty();
        return counter;
    }

    public int increment() {
        counter++;
        markDirty();
        return counter;
    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
        counter = compound.getInteger("counter");
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        super.writeToNBT(compound);
        compound.setInteger("counter", counter);
        return compound;
    }
}
