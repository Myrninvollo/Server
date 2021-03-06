package net.minecraft.item;

import net.minecraft.block.Block;

public class ItemColored extends ItemBlock
{
    private final Block field_150944_b;
    private String[] field_150945_c;
    private static final String __OBFID = "CL_00000003";

    public ItemColored(Block p_i45332_1_, boolean p_i45332_2_)
    {
        super(p_i45332_1_);
        this.field_150944_b = p_i45332_1_;

        if (p_i45332_2_)
        {
            this.setMaxDamage(0);
            this.setHasSubtypes(true);
        }
    }

    /**
     * Returns the metadata of the block which this Item (ItemBlock) can place
     */
    public int getMetadata(int p_77647_1_)
    {
        return p_77647_1_;
    }

    public ItemColored func_150943_a(String[] p_150943_1_)
    {
        this.field_150945_c = p_150943_1_;
        return this;
    }

    /**
     * Returns the unlocalized name of this item. This version accepts an ItemStack so different stacks can have
     * different names based on their damage or NBT.
     */
    public String getUnlocalizedName(ItemStack p_77667_1_)
    {
        if (this.field_150945_c == null)
        {
            return super.getUnlocalizedName(p_77667_1_);
        }
        else
        {
            int var2 = p_77667_1_.getItemDamage();
            return var2 >= 0 && var2 < this.field_150945_c.length ? super.getUnlocalizedName(p_77667_1_) + "." + this.field_150945_c[var2] : super.getUnlocalizedName(p_77667_1_);
        }
    }
}
