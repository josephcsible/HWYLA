package mcp.mobius.waila.api;

import java.util.List;

import codechicken.nei.api.ItemInfo.Layout;
import mcp.mobius.waila.ConfigHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public interface IWailaBlock {
	/*
	 *  Use this method to return an item stack in case the default lookup system fails.
	 *  Return null if you want to use the default lookup system.
	 *  You get the world, the player and the location of the block. With that, it is easy to gather information & tile entities
	 */
	ItemStack    getWailaStack(World world, EntityPlayer player, MovingObjectPosition mop, IConfigHandler config);
	
	/* Waila HUD is divided into 3 zones. The head corresponds to the item name, 
	 * body to where you mostly want to put informations, and I reserve the tail for modname display 
	 */ 
	
	/* Those 2 methods works exactly the same way, except they are related to a different zone in Waila HUD.
	 * You get in input world, player and the block location. You also get the itemstack as returned by the default lookup system or getWailaStack().
	 * ConfigHandler provides the current Waila config state so you can show/hide elements depending on the configuration. Refer the ConfigHandler class for more info.
	 * currenttip represents the current list of text lines in the tooltip zone.
	 * For example, getWailaHead() will have the current item name as currenttip.
	 * You can modify the tips, add more, remove some, etc.
	 * When you are done, just returns the currenttip and it will display in Waila.
	 * 
	 * Always return the currenttip is you don't want to modify the current zone.
	 */
	
	List<String> getWailaHead(ItemStack itemStack, World world, EntityPlayer player, MovingObjectPosition mop, List<String> currenttip, IConfigHandler config);
	List<String> getWailaBody(ItemStack itemStack, World world, EntityPlayer player, MovingObjectPosition mop, List<String> currenttip, IConfigHandler config);
}